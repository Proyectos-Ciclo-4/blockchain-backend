package com.sofka.albertusview.application.adapters.repository;


import com.google.gson.Gson;
import com.sofka.albertusview.business.gateways.DomainViewRepository;
import com.sofka.albertusview.business.gateways.models.BlockChainModel;
import com.sofka.albertusview.business.gateways.models.BlockViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class MongoViewRepository implements DomainViewRepository {

    private final ReactiveMongoTemplate template;

    private final Gson gson = new Gson();

    public MongoViewRepository(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Mono<BlockChainModel> findByAggregateId(String aggregateId) {

        var query = new Query(Criteria.where("blockChainId").is(aggregateId));
        return template.findOne(query, BlockChainModel.class);
    }


    @Override
    public Mono<BlockChainModel> saveNewBlockChain(BlockChainModel blockChainModel) {

        return template.save(blockChainModel);
    }

    @Override
    public Mono<BlockChainModel> addBlockToBlockChain(BlockViewModel block) {
    var update = new Update();
    update.addToSet("blocks").value(block);
    var query =  Query.query(
            Criteria.where("blockChainId").is("1")
    );
    return template.updateFirst(query,update,"blockChainModel").flatMap(block2 ->{
        return Mono.empty();
    });


       /* var algo = this.findByAggregateId("1")
                .flatMap(blockChainModel -> {
                    blockChainModel.getBlocks().add(block);

                    return template.save(blockChainModel);
                });
        return algo;*/
    }

    @Override
    public Mono<BlockViewModel> addBlock(BlockViewModel block) {
        return template.save(block);
    }

    @Override
    public Mono<BlockViewModel> getBlockByHash(String hash) {
        var query =  Query.query(
                Criteria.where("hash").is(hash)
        );
        return template.findOne(query,BlockViewModel.class);
    }


    public Flux<BlockViewModel> getAllBlocksByApplicationId(String idApplication) {
        var query =  Query.query(
                Criteria.where("applicationId").is(idApplication)
        );
        return template.find(query,BlockViewModel.class);
    }
}
