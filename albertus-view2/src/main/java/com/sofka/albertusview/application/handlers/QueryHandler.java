package com.sofka.albertusview.application.handlers;


import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import com.sofka.albertusview.business.usecases.BlocksByApplicationIdUseCase;
import com.sofka.albertusview.business.usecases.BringBlockByHashUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
public class QueryHandler {

  @Bean
  public RouterFunction<ServerResponse> getBlockByHash(BringBlockByHashUseCase bringBlockByHashUseCase){
    log.info("Bringing  block");
    return route(GET("/block/{hash}"),
        request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromPublisher(bringBlockByHashUseCase.apply(request.pathVariable("hash")), BlockViewModel.class))
    );

  }

  @Bean
  public RouterFunction<ServerResponse> getAllBlocksByApplicationId(BlocksByApplicationIdUseCase blocksByApplicationIdUseCase){
    log.info("Bringing  block");
    return route(GET("/blocks/{idApplication}"),
            request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(blocksByApplicationIdUseCase.apply(request.pathVariable("idApplication")), BlockViewModel.class))
    );

  }

}
