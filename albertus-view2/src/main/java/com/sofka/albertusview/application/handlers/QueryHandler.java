package com.sofka.albertusview.application.handlers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
public class QueryHandler {

//  @Bean
//  public RouterFunction<ServerResponse> getAllPosts(BringAllPostsUseCase bringAllPostsUseCase){
//    log.info("Bringing all posts");
//    return route(GET("/bringallposts"),
//        request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//            .body(BodyInserters.fromPublisher(bringAllPostsUseCase.get(), PostViewModel.class))
//    );
//
//  }


}
