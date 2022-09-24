package com.sofka.albertus.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.domain.events.BlockChainCreated;
import com.sofka.albertus.domain.entity.Application;
import com.sofka.albertus.domain.entity.Invoice;
import com.sofka.albertus.domain.entity.User;
import com.sofka.albertus.domain.events.BlockCreated;
import com.sofka.albertus.domain.events.GenesisBlockCreated;
import com.sofka.albertus.domain.values.Block;
import com.sofka.albertus.domain.values.BlockChainId;
import com.sofka.albertus.domain.values.Name;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BlockChain  extends AggregateEvent<BlockChainId> {

    protected Name blockChainName;
    protected Set<User> users;
    protected List<Block> blocks;
    protected List<Application> applications;
    protected List<Invoice> invoices;


    public List<Application> getApplications() {
        return applications;
    }

    public BlockChain(BlockChainId entityId, String blockChainName) {
        super(entityId);
        appendChange(new BlockChainCreated(entityId.value(),blockChainName));
    }

    private BlockChain(BlockChainId entityId) {
        super(entityId);
        subscribe( new BlockChainChange(this));
    }

    public static BlockChain from(BlockChainId blockChainId, List<DomainEvent> events){
        var blockChain = new BlockChain(blockChainId);
        events.forEach(blockChain::applyEvent);
        return blockChain;
    }

    public void CreateGenesisBlock( String data){
        Objects.requireNonNull(data);
        appendChange(new GenesisBlockCreated(data)).apply();
    }

    public void CreateBlock(Map<String, Object> data, String applicationId, String hash, Instant timeStamp, Integer nonce, Boolean hasOverCharge, String previousHash){
        Objects.requireNonNull(data);
        Objects.requireNonNull(applicationId);
        appendChange(new BlockCreated(applicationId, data, hash, timeStamp, nonce, hasOverCharge, previousHash)).apply();
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
