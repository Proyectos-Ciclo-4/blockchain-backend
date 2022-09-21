package com.sofka.albertus.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.albertus.domain.events.BlockChainCreated;
import com.sofka.albertus.domain.events.GenesisBlockCreated;
import com.sofka.albertus.domain.values.Name;

import java.util.ArrayList;
import java.util.HashSet;

public class BlockChainChange extends EventChange {
    public BlockChainChange(BlockChain blockChain) {

        apply((BlockChainCreated event)->{
            blockChain.users = new HashSet<>();
            blockChain.blocks = new ArrayList<>();
            blockChain.applications = new ArrayList<>();
            blockChain.invoices = new ArrayList<>();
            blockChain.blockChainName =  new Name(event.getBlockChainName());
        });

        apply((GenesisBlockCreated event)->{
          //TODO: implementar logica de creadocion del bloque
        });
    }
}
