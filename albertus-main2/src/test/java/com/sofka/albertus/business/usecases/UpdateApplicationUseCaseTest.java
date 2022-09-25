package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlockChain;
import com.sofka.albertus.business.usecases.gateways.commands.RegisterApplication;
import com.sofka.albertus.business.usecases.gateways.commands.UpdateApplication;
import com.sofka.albertus.domain.events.ApplicationRegistered;
import com.sofka.albertus.domain.events.ApplicationUpdated;
import com.sofka.albertus.domain.events.BlockChainCreated;
import com.sofka.albertus.domain.events.GenesisBlockCreated;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateApplicationUseCaseTest {


    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private UpdateApplicationUseCase useCaseMock;

    @Test
    @DisplayName("updateApplicationUseCaseTest. Should save both events and publish to Rabbit")
    void updateApplicationUseCaseTest(){

        //Arrange
        CreateBlockChain createBlockChainCommand = new CreateBlockChain(
                "1", "Albertus"
        );

        BlockChainCreated blockChainCreatedEvent = new BlockChainCreated(
                createBlockChainCommand.getBlockChainId(),
                createBlockChainCommand.getBlockChainName()
        );

        RegisterApplication registerApplicationCommand = new RegisterApplication(
                "Original Application Name",
                "Original Description"
        );

        ApplicationRegistered applicationRegistered = new ApplicationRegistered(
                registerApplicationCommand.getNameApplication(),
                registerApplicationCommand.getDescription(),
                true,
                "userId"
        );


        UpdateApplication updateApplicationCommand = new UpdateApplication(
                "12345",
                "Application name amended",
                "This is the description just amended"
        );


        ApplicationUpdated applicationUpdated = new ApplicationUpdated(
                updateApplicationCommand.getApplicationID(),
                updateApplicationCommand.getNameApplication(),
                updateApplicationCommand.getDescription()
        );


        BDDMockito
                .when(this.repositoryMock.findById(ArgumentMatchers.anyString()))
                .thenReturn(Flux.just(blockChainCreatedEvent, applicationRegistered));


        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenReturn(Mono.just(applicationUpdated));



        //Act
        Mono<List<DomainEvent>> savedEvents = this.useCaseMock.apply(Mono.just(updateApplicationCommand))
                .collectList();

        //Assert
        StepVerifier.create(savedEvents)
                .expectNextMatches(events ->
                        events.size() == 3 && events.get(0) instanceof BlockChainCreated &&
                                events.get(1) instanceof ApplicationRegistered &&
                                events.get(2) instanceof ApplicationUpdated)
                .verifyComplete();

        BDDMockito.verify(this.eventBusMock, BDDMockito.times(1))
                .publish(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(2))
                .saveEvent(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .findById(ArgumentMatchers.anyString());

    }


}