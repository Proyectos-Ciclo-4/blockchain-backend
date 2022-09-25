package com.sofka.albertus.application.handlers;


import co.com.sofka.domain.generic.DomainEvent;
import com.fasterxml.jackson.annotation.JsonKey;
import com.sofka.albertus.application.helpers.AuthorizationProvider;
import com.sofka.albertus.application.helpers.CreateBlockDeserialize;
import com.sofka.albertus.business.usecases.CreateBlockChainUseCase;
import com.sofka.albertus.business.usecases.CreateBlockUseCase;
import com.sofka.albertus.business.usecases.DeleteApplicationUseCase;
import com.sofka.albertus.business.usecases.RegisterApplicationUseCase;
import com.sofka.albertus.business.usecases.UpdateApplicationUseCase;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlock;
import com.sofka.albertus.business.usecases.gateways.commands.CreateBlockChain;
import com.sofka.albertus.business.usecases.gateways.commands.DeleteApplication;
import com.sofka.albertus.business.usecases.gateways.commands.RegisterApplication;
import com.sofka.albertus.business.usecases.gateways.commands.UpdateApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CommandHandle {
  private final AuthorizationProvider authorizationProvider;


  public CommandHandle(AuthorizationProvider authorizationProvider) {
    this.authorizationProvider = authorizationProvider;
  }

  @Bean
  public RouterFunction<ServerResponse> create(CreateBlockChainUseCase useCase) {
    return route(
        POST("/create/blockchain").and(accept(MediaType.APPLICATION_JSON)),
        request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromPublisher(
                useCase.apply(request.bodyToMono(CreateBlockChain.class)),
                DomainEvent.class))
    );
  }

  @Bean
  public RouterFunction<ServerResponse> createBlock(CreateBlockUseCase useCase) {
    return route(
            POST("/create/block").and(accept(MediaType.APPLICATION_JSON)),
            request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(
                            useCase.apply(authorizationProvider.getAuthorization(request.bodyToMono(Object.class), request.headers())),
                            DomainEvent.class))
    );
  }

  @Bean
  public RouterFunction<ServerResponse> updateApplication(UpdateApplicationUseCase useCase){
    return route(
      PUT("/update/application").and(accept(MediaType.APPLICATION_JSON)),
            request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(UpdateApplication.class)), DomainEvent.class))
    );
  }

  @Bean
  public RouterFunction<ServerResponse> deleteApplication(DeleteApplicationUseCase useCase){
    return route(
        PUT("/delete").and(accept(MediaType.APPLICATION_JSON)),
        request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(DeleteApplication.class)), DomainEvent.class))
    );
  }


  @Bean
  public RouterFunction<ServerResponse> registerApplication(RegisterApplicationUseCase useCase) {
    return route(
            POST("/register/application").and(accept(MediaType.APPLICATION_JSON)),
            request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(
                            useCase.apply(request.bodyToMono(RegisterApplication.class)), DomainEvent.class))
    );
  }


}



