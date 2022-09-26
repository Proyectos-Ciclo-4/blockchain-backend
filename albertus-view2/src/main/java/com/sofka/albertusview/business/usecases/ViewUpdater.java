package com.sofka.albertusview.business.usecases;


import com.sofka.albertusview.business.gateways.DomainViewRepository;
import com.sofka.albertusview.business.gateways.EventBus;
import com.sofka.albertusview.business.gateways.models.ApplicationViewModel;
import com.sofka.albertusview.business.gateways.models.BlockChainModel;
import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import com.sofka.albertusview.business.generics.DomainUpdater;
import com.sofka.albertusview.domain.events.ApplicationDeleted;
import com.sofka.albertusview.domain.events.ApplicationRegistered;
import com.sofka.albertusview.domain.events.BlockChainCreated;
import com.sofka.albertusview.domain.events.BlockCreated;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ViewUpdater extends DomainUpdater {

    //Complete the implementation of the view updater
    private final DomainViewRepository repository;

    private final EventBus bus;

    public ViewUpdater(DomainViewRepository repository,
                       EventBus bus) {
        this.repository = repository;
        this.bus = bus;

        listen((BlockChainCreated blockChainCreated) -> {
            BlockChainModel blockChainModel = new BlockChainModel(
                    blockChainCreated.getBlockChainId(),
                    blockChainCreated.getBlockChainName(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()

            );
            //bus.publishBlockChain(blockChainModel);
            repository.saveNewBlockChain(blockChainModel).subscribe();
        });

        listen((BlockCreated blockCreated) -> {
            BlockViewModel blockViewModel = new BlockViewModel(
                    blockCreated.getApplicationID(),
                    blockCreated.getData(),
                    blockCreated.getHash(),
                    blockCreated.getTimeStamp(),
                    blockCreated.getNonce(),
                    blockCreated.getHasOverCharge(),
                    blockCreated.getPreviusHash()
            );
            //bus.publishBlockChain();
            repository.addBlock(blockViewModel).subscribe();
        });

        listen((ApplicationRegistered applicationRegistered) -> {
            ApplicationViewModel applicationViewModel = new ApplicationViewModel(
                    applicationRegistered.getApplicationId(),
                    applicationRegistered.getNameApplication(),
                    applicationRegistered.getDescription(),
                    applicationRegistered.getActive(),
                    applicationRegistered.getUserId()
            );
            repository.saveNewApplication(applicationViewModel).subscribe();
        });

        listen((ApplicationDeleted applicationDeleted) -> {
            repository.updateDeleteApplication(applicationDeleted.getApplicationID()).subscribe();
        });



    }
}
