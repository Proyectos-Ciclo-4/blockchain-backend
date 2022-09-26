package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.domain.entity.Application;
import com.sofka.albertus.domain.entity.Invoice;
import com.sofka.albertus.domain.values.Block;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BlockChainCreated extends DomainEvent {

    private String blockChainId;
    private String  blockChainName;

    private List<Block> blocks = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    public BlockChainCreated(String blockChainId, String blockChainName) {
        super("sofka.albertus.domain.BlockChainCreated");
        this.blockChainId = blockChainId;
        this.blockChainName = blockChainName;
    }
    public BlockChainCreated() {
        super("sofka.albertus.domain.BlockChainCreated");
    }

    public String getBlockChainId() {
        return blockChainId;
    }

    public String getBlockChainName() {
        return blockChainName;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
