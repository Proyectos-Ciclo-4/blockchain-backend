package com.sofka.albertus.application.handlers;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.CreateBlockChainUseCase;
import com.sofka.albertus.domain.commands.CreateBlockChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CommandHandle {


  @Bean
  public RouterFunction<ServerResponse> create(CreateBlockChainUseCase useCase) {
    return route(
        POST("/create/block").and(accept(MediaType.APPLICATION_JSON)),
        request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromPublisher(
                useCase.apply(request.bodyToMono(CreateBlockChain.class)),
                DomainEvent.class))
    );
  }


}



