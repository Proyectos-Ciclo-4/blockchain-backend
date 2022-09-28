package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.business.usecases.gateways.commands.DeleteApplication;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeleteApplicationUseCaseTest {

    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private DeleteApplicationUseCase usecase;

    @Test
    @DisplayName("DeleteApplicationUseCaseTest.")
    void DeleteApplicationUseCaseTest() {

        DeleteApplication deleteApplication = new DeleteApplication(
                "appID"
        );

        ApplicationDeleted applicationDeleted = new ApplicationDeleted(
                "appID"
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
                ), genesisBlockCreatedEvent, applicationRegistered));

        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenReturn(Mono.just(applicationDeleted));

        Mono<List<DomainEvent>> savedEvents = this.usecase.apply(Mono.just(deleteApplication))
                .collectList();

        StepVerifier.create(savedEvents)
                .expectNextMatches(events -> {
                            var event = (ApplicationDeleted) events.get(0);
                            return event.getApplicationID().equals("appID") &&
                                    events.size()== 1 &&
                                    events.get(0) instanceof ApplicationDeleted;
                        }
                )
                .verifyComplete();

        BDDMockito.verify(this.eventBusMock, BDDMockito.times(1))
                .publish(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .saveEvent(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .findById(ArgumentMatchers.anyString());
    }
}