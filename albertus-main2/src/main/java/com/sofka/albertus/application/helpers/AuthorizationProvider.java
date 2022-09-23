package com.sofka.albertus.application.helpers;

import com.sofka.albertus.domain.commands.CreateBlock;

import static org.springframework.web.reactive.function.server.ServerRequest.Headers;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationProvider {

  public Mono<CreateBlock> getAuthorization(Mono<CreateBlock> command, Headers headers) {

    var header = headers.firstHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];

    return command.doOnNext(createBlock -> createBlock.setApplicationID(header));
  }
}
//    command.flatMap((commandHeader, ) ->{
//          commandHeader.setApplicationID(header);
//
//          return commandHeader;
//        }
//    );