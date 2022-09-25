package com.sofka.albertus.business.usecases;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.UpdateApplication;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.domain.entity.Application;
import com.sofka.albertus.domain.values.BlockChainId;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Component
public class UpdateApplicationUseCase {

    private final DomainEventRepository repository;

    private final EventBus bus;


    public UpdateApplicationUseCase(DomainEventRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public Flux<DomainEvent> apply(Mono<UpdateApplication> updateApplicationCommand){

        return  updateApplicationCommand.flatMapMany(command -> repository.findById("1")
                .collectList()
                .flatMapIterable(eventsFromRepository -> {
                    BlockChain blockChain = BlockChain.from(BlockChainId.of("1"),eventsFromRepository);
                    blockChain.updateApplication(command.getApplicationID(),command.getNameApplication(), command.getDescription());
                    return blockChain.getUncommittedChanges();
                }).map(event -> {
                    bus.publish(event);
                    return event;
                }).flatMap(event -> repository.saveEvent(event)));

    }

}
