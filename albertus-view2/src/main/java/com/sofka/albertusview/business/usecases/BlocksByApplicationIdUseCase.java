package com.sofka.albertusview.business.usecases;

import com.sofka.albertusview.application.adapters.repository.MongoViewRepository;
import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class BlocksByApplicationIdUseCase implements Function<String, Flux<BlockViewModel>> {

    public  final MongoViewRepository repository;

    public BlocksByApplicationIdUseCase(MongoViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<BlockViewModel> apply(String idApplication) {
        return repository.getAllBlocksByApplicationId(idApplication);
    }
}
