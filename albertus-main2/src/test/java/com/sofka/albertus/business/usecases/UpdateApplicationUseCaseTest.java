package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.application.helpers.BlockHashResponse;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlock;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlockChain;
import com.sofka.albertus.business.usecases.gateways.commands.RegisterApplication;
import com.sofka.albertus.business.usecases.gateways.commands.UpdateApplication;
import com.sofka.albertus.domain.events.*;
import org.junit.jupiter.api.DisplayName;
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
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateApplicationUseCaseTest {



    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private UpdateApplicationUseCase usecase;

    @Test
    @DisplayName("updateApplicationUseCaseTest. Should save both events and publish to Rabbit")
    void updateApplicationUseCaseTest(){

        UpdateApplication updateApplication = new UpdateApplication(
                "appID",
                "Prueba",
                "soy una prueba"
        );

        ApplicationUpdated applicationUpdated = new ApplicationUpdated(
                "appID",
                "name changed",
                "descriptionchanged"
        );

        ApplicationRegistered applicationRegistered = new ApplicationRegistered(
                "appID",
                "Prueba",
                "soy una prueba",
                true,
                "101",
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
                ),genesisBlockCreatedEvent, applicationRegistered));


        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenReturn(Mono.just(applicationUpdated));

        //Act
        Mono<List<DomainEvent>> savedEvents = this.usecase.apply(Mono.just(updateApplication))
                .collectList();


        //Assert
        StepVerifier.create(savedEvents)
                .expectNextMatches(events ->{
                    var event = (ApplicationUpdated) events.get(0);
                    return event.getApplicationID().equals("appID")
                            && event.getNameApplication().equals("name changed")
                            && event.getDescription().equals("descriptionchanged")
                            &&events.size()==1 && events.get(0) instanceof ApplicationUpdated;
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