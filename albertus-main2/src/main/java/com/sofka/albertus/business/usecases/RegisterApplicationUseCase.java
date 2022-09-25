package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.RegisterApplication;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.domain.values.BlockChainId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RegisterApplicationUseCase {

    private final DomainEventRepository repository;

    private final EventBus bus;

    public RegisterApplicationUseCase(DomainEventRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public Flux<DomainEvent> apply(Mono<RegisterApplication> registerApplicationCommand) {
        return registerApplicationCommand.flatMapMany(command -> repository.findById("1")
                .collectList()
                .flatMapIterable(eventsFromRepository -> {
                    BlockChain blockChain = BlockChain.from(BlockChainId.of("1"), eventsFromRepository);
                    blockChain.registerApplication(
                            command.getApplicationId(),
                            command.getNameApplication(),
                            command.getDescription(),
                            true,
                            command.getUserId());
                    return blockChain.getUncommittedChanges();

                }).map(event ->{
                    bus.publish(event);
                    return event;
                }).flatMap(event -> repository.saveEvent(event)));
    }
}
