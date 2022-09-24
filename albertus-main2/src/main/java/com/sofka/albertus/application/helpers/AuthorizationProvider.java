package com.sofka.albertus.application.helpers;

import com.sofka.albertus.business.usecases.gateways.commands.CreateBlock;

import static org.springframework.web.reactive.function.server.ServerRequest.Headers;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class AuthorizationProvider {

  public Mono<CreateBlock> getAuthorization(Mono<Object> info, Headers headers) {

    var createBlockCommand = new CreateBlock();
    LinkedHashMap<String, String> mapa;
    var header = headers.firstHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
    createBlockCommand.setApplicationID(header);

     return info.flatMap(data -> {
       createBlockCommand.setData((Map) data);
       return Mono.just(createBlockCommand);
     });

  }
}
//    command.flatMap((commandHeader, ) ->{
//          commandHeader.setApplicationID(header);
//
//          return commandHeader;
//        }
//    );