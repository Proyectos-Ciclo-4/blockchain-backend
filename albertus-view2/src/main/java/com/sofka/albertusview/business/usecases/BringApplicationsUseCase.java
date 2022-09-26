package com.sofka.albertusview.business.usecases;

import com.sofka.albertusview.application.adapters.repository.MongoViewRepository;
import com.sofka.albertusview.business.gateways.models.ApplicationViewModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;
@Service
public class BringApplicationsUseCase implements Function<String, Flux<ApplicationViewModel>> {

    public  final MongoViewRepository repository;

    public BringApplicationsUseCase(MongoViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<ApplicationViewModel> apply(String userId) {
        return repository.getAllApplicationsByUserId(userId);
    }
}
