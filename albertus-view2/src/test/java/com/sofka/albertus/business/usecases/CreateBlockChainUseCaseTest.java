/*package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlockChain;
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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateBlockChainUseCaseTest {

    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private CreateBlockChainUseCase useCaseMock;

    @Test
    @DisplayName("createBlockChainUseCaseTest. Should save both events and publish to Rabbit")
    void createBlockChainUseCaseTest(){

        //Arrange
        CreateBlockChain createBlockChainCommand = new CreateBlockChain("1", "Albertus");

        BlockChainCreated blockChainCreatedEvent = new BlockChainCreated(
                createBlockChainCommand.getBlockChainId(),
                createBlockChainCommand.getBlockChainName()
        );

        GenesisBlockCreated genesisBlockCreatedEvent = new GenesisBlockCreated(
                  "Genesis Block"
        );

        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(BlockChainCreated.class)))
                .thenReturn(Mono.just(blockChainCreatedEvent));

        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(GenesisBlockCreated.class)))
                .thenReturn(Mono.just(genesisBlockCreatedEvent));

        //Act
        Mono<List<DomainEvent>> savedEvents = this.useCaseMock.apply(Mono.just(createBlockChainCommand))
                .collectList();

        //Assert
        StepVerifier.create(savedEvents)
                .expectNextMatches(events ->
                        events.size() == 2 && events.get(0) instanceof BlockChainCreated &&  events.get(1) instanceof GenesisBlockCreated )
                .verifyComplete();

        BDDMockito.verify(this.eventBusMock, BDDMockito.times(2))
                .publish(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(2))
                .saveEvent(ArgumentMatchers.any(DomainEvent.class));

    }

}*/