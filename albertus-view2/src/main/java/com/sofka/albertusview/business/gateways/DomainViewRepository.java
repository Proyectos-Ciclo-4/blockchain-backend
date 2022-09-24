package com.sofka.albertusview.business.gateways;


import com.sofka.albertusview.business.gateways.models.BlockChainModel;

import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import com.sofka.albertusview.domain.values.Block;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainViewRepository {
    Mono<BlockChainModel> findByAggregateId(String aggregateId);
    Mono<BlockChainModel> saveNewBlockChain(BlockChainModel blockChainModel);

    Mono<BlockChainModel> addBlockToBlockChain(BlockViewModel block);

    Mono<BlockViewModel> addBlock(BlockViewModel block);

    Mono<BlockViewModel> getBlockByHash(String hash);

    Flux<BlockViewModel> getAllBlocksByApplicationId(String applicationId);

}
