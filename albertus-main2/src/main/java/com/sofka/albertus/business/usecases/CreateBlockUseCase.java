package com.sofka.albertus.business.usecases;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.application.helpers.BlockHashResponse;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlock;
import com.sofka.albertus.domain.events.BlockCreated;
import com.sofka.albertus.domain.values.BlockChainId;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static io.netty.util.CharsetUtil.UTF_8;


@Component
@Slf4j
public class CreateBlockUseCase {

    private final DomainEventRepository repository;

    private final EventBus bus;

    public CreateBlockUseCase(DomainEventRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public Mono<BlockHashResponse> apply(Mono<CreateBlock> createBlockCommand){

        return createBlockCommand.flatMap(command -> repository.findById(command.getBlockChainID())
                .collectList()
                .map(eventsFromRepository -> {
                    BlockChain blockChain = BlockChain.from(BlockChainId.of("1"),eventsFromRepository);
                    var confirmation = blockChain.getApplications().stream().filter(application ->
                            application.identity().value().equals(command.getApplicationID())
                    ).collect(Collectors.toList());

                    if (confirmation.size() > 0){

                        var overCharge = blockChain.getBlocks().stream().filter(block ->
                                block.value().TimeStamp().atZone(ZoneId.systemDefault()).getDayOfYear() == LocalDateTime.now().getDayOfMonth()
                        ).collect(Collectors.toList());


                        String previousHash = blockChain.getBlocks().get(blockChain.getBlocks().size()-1).value().hash();
                        String nonce = String.valueOf((int) (Math.random() * 10000));
                        Map<String, Object> data = command.getData();

                        Instant instant = Instant.now();
                        String timeStamp = String.valueOf(instant);

                        Boolean hasOverCharge = overCharge.size() == 5 ? true :  false;

                        String hasOverChargeString = hasOverCharge.toString();
                        String dataToHash = timeStamp + nonce + data.toString() + previousHash + hasOverChargeString;
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

                        blockChain.CreateBlock(data, command.getApplicationID(),
                                hash,
                                instant,
                                Integer.valueOf(nonce),
                                hasOverCharge,
                                previousHash );
                    }
                    return (BlockCreated)blockChain.getUncommittedChanges().get(0);
                }).flatMap(event -> repository.saveEvent((DomainEvent) event))
                .map(event -> {
                    bus.publish(event);
                    return BlockHashResponse.from((BlockCreated) event);
                })
                .doOnError(error -> log.error(String.valueOf(error))));
    }


}