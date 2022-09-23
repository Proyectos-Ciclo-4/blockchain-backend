package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlockChain;
import com.sofka.albertus.domain.values.BlockChainId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CreateBlockChainUseCase {

    private final DomainEventRepository repository;

    private final EventBus bus;

    public CreateBlockChainUseCase(DomainEventRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public Flux<DomainEvent> apply(Mono<CreateBlockChain> createBlockChainCommand){
        return createBlockChainCommand.flatMapIterable(command -> {
            BlockChain blockChain = new BlockChain(BlockChainId.of(command.getBlockChainId()),command.getBlockChainName());
            blockChain.CreateGenesisBlock("Albertus Genesis Block");
            return blockChain.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(event).thenReturn(event)).doOnNext(bus::publish)
                .doOnError(error -> log.error(String.valueOf(error)));
    }

}
