package com.sofka.albertus.application.bus;


import com.google.gson.Gson;
import com.sofka.albertus.application.controller.SocketController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

  public static final String PROXY_QUEUE = "events.proxy.application";
  private final Gson gson = new Gson();
  private final SocketController controller;


  public RabbitMqConsumer(SocketController controller) {
    this.controller = controller;
  }

  @RabbitListener(queues = PROXY_QUEUE)
  public void listenToCommentAddedQueue(String message) throws ClassNotFoundException {
    Object comment = gson.fromJson(message, Object.class);
    controller.sendModel("1", comment);
  }
}
