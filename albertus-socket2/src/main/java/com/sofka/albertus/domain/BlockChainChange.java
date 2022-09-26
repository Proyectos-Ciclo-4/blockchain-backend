package com.sofka.albertus.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.albertus.domain.entity.Application;
import com.sofka.albertus.domain.events.*;
import com.sofka.albertus.domain.values.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;

import static io.netty.util.CharsetUtil.UTF_8;

@Slf4j
public class BlockChainChange extends EventChange {
    public BlockChainChange(BlockChain blockChain) {

        apply((BlockChainCreated event) -> {
            blockChain.users = new HashSet<>();
            blockChain.blocks = event.getBlocks();
            blockChain.applications = event.getApplications();
            blockChain.invoices = event.getInvoices();
            blockChain.blockChainName = new Name(event.getBlockChainName());
        });

        apply((GenesisBlockCreated event) -> {
            //TODO: implementar logica de creadocion del bloque
            String nonce = String.valueOf((int) (Math.random() * 10000));
            String data = event.getData();
            Instant instant = Instant.now();
            String timeStamp = String.valueOf(instant);
            String dataToHash = timeStamp + nonce + data;
            MessageDigest digest = null;
            byte[] bytes = null;
            try {
                digest = MessageDigest.getInstance("MD5");
                bytes = digest.digest(dataToHash.getBytes(UTF_8));
            } catch (NoSuchAlgorithmException ex) {
                log.info((Marker) Level.SEVERE, ex.getMessage());
            }

            StringBuffer buffer = new StringBuffer();
            for (byte b : bytes) {
                buffer.append(String.format("%02x", b));
            }
            String hash = buffer.toString();

            blockChain.blocks.add(new Block(hash, "", data, instant, Integer.valueOf(nonce), false, ""));
        });

        apply((BlockCreated event) -> {
            blockChain.blocks.add(new Block(
                    event.getHash(),
                    event.getPreviusHash(),
                    event.getData(),
                    event.getTimeStamp(),
                    event.getNonce(),
                    event.getHasOverCharge(),
                    event.getApplicationID())
            );
        });

        apply((ApplicationUpdated event) -> {
            var application = blockChain.getApplicationByID(ApplicationId.of(event.getApplicationID())).orElseThrow(() -> new IllegalArgumentException("Invalid ID to retrive Application"));
            application.updateApplication(event.getNameApplication(), event.getDescription());
        });

        apply((ApplicationRegistered event) -> {
            blockChain.applications.add(new Application(
                    (ApplicationId.of(event.getApplicationId())),
                    new Name(event.getNameApplication()),
                    new Description(event.getDescription()),
                    new IsActive(event.getActive()),
                    new UserId(event.getUserId()),
                    new CreationDate(event.getCreationDate()),
                    new ModificationDate(event.getModificationDate())
            ));
        });

        apply((ApplicationDeleted event)->{
           var deleteApplication = blockChain.getApplicationByID(ApplicationId.of(
               event.getApplicationID())).orElseThrow(() -> new IllegalArgumentException("Invalid ID to retrive Application"));
           deleteApplication.deleteApplication();

        });

    }
}
