package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.RegisterApplication;
import com.sofka.albertus.domain.events.ApplicationRegistered;
import com.sofka.albertus.domain.events.BlockChainCreated;
import com.sofka.albertus.domain.events.GenesisBlockCreated;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegisterApplicationUseCaseTest {
    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private RegisterApplicationUseCase usecase;

    @Test
    void RegisterApplicationUseCase(){
        RegisterApplication registerApplication = new RegisterApplication(
                "appID",
                "appName",
                "appDescription",
                true,
                "appUserID"
        );

        ApplicationRegistered applicationRegistered = new ApplicationRegistered(
                "appID",
                "appName",
                "appDescription",
                true,
                "appUserID",
                Instant.now(),
                Instant.now()
        );

        GenesisBlockCreated genesisBlockCreatedEvent = new GenesisBlockCreated(
                "Genesis Block"
        );

        BDDMockito
                .when(this.repositoryMock.findById(ArgumentMatchers.anyString()))
                .thenReturn(Flux.just(new BlockChainCreated(
                        "098098098",
                        "Santiago Sierra"
                ),genesisBlockCreatedEvent));

        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenReturn(Mono.just(applicationRegistered));

        Mono<List<DomainEvent>> savedEvents = this.usecase.apply(Mono.just(registerApplication))
                .collectList();

        StepVerifier.create(savedEvents)
                .expectNextMatches(events ->{
                    var event = (ApplicationRegistered) events.get(0);
                    return event.getApplicationId().equals("appID")
                            && event.getNameApplication().equals("appName")
                            && event.getActive().equals(true)
                            && events.get(0) instanceof ApplicationRegistered;
                })
                .verifyComplete();


        BDDMockito.verify(this.eventBusMock, BDDMockito.times(1))
                .publish(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .saveEvent(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .findById(ArgumentMatchers.anyString());
    }

}