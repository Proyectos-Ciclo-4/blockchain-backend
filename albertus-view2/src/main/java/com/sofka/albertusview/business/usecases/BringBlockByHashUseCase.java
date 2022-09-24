package com.sofka.albertusview.business.usecases;

import com.sofka.albertusview.application.adapters.repository.MongoViewRepository;
import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;
@Service
public class BringBlockByHashUseCase implements Function<String, Mono<BlockViewModel>> {

    public  final MongoViewRepository repository;

    public BringBlockByHashUseCase(MongoViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BlockViewModel> apply(String hash) {
        return this.repository.getBlockByHash(hash);
    }


}
