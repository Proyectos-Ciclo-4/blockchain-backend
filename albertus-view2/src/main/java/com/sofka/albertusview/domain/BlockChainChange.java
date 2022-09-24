package com.sofka.albertusview.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.albertusview.domain.events.BlockChainCreated;
import com.sofka.albertusview.domain.events.BlockCreated;
import com.sofka.albertusview.domain.events.GenesisBlockCreated;
import com.sofka.albertusview.domain.values.Block;
import com.sofka.albertusview.domain.values.Name;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;

import static io.netty.util.CharsetUtil.UTF_8;

@Slf4j
public class BlockChainChange extends EventChange {
    public BlockChainChange(BlockChain blockChain) {

        apply((BlockChainCreated event) -> {
            blockChain.users = new HashSet<>();
            blockChain.blocks = new ArrayList<>();
            blockChain.applications = new ArrayList<>();
            blockChain.invoices = new ArrayList<>();
            blockChain.blockChainName = new Name(event.getBlockChainName());
        });

        apply((GenesisBlockCreated event) -> {
            //TODO: implementar logica de creadocion del bloque
            String nonce = String.valueOf((int) (Math.random() * 10000));
            Map<String, Object> data = event.getData();

            Instant instant = Instant.now();
            String timeStamp = String.valueOf(instant);
            String dataToHash = timeStamp + nonce + data.toString();
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
    }
}
