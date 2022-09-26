package com.sofka.albertusview.application.adapters.bus;


import com.google.gson.Gson;
import com.sofka.albertusview.application.config.RabbitMqConfig;
import com.sofka.albertusview.business.gateways.EventBus;
import com.sofka.albertusview.business.gateways.models.ApplicationViewModel;
import com.sofka.albertusview.business.gateways.models.BlockChainModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMqEventBus implements EventBus {

  private final RabbitTemplate rabbitTemplate;
  private final Gson gson = new Gson();

  public RabbitMqEventBus(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }


  @Override
  public void publishApplication(ApplicationViewModel applicationViewModel) {

  }

  @Override
  public void publishBlockChain(BlockChainModel blockChainViewModel) {
    log.info("BLOCKCHAIN ADDED");
    rabbitTemplate.convertAndSend(
        RabbitMqConfig.EXCHANGE, RabbitMqConfig.PROXY_ROUTING_KEY_AGG_BLOCKCHAIN,
        gson.toJson(blockChainViewModel).getBytes()
    );
  }
}
