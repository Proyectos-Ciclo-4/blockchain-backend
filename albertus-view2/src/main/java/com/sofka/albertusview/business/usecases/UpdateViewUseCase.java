package com.sofka.albertusview.business.usecases;


import co.com.sofka.domain.generic.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Slf4j
@Service
public class UpdateViewUseCase implements Consumer<DomainEvent>{


    private final ViewUpdater updater;

    public UpdateViewUseCase(ViewUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void accept(DomainEvent domainEvent){
        log.info("Applying Events to consumer list");
    /*    bus.publish(domainEvent);*/
        updater.applyEvent(domainEvent);
    }
}
