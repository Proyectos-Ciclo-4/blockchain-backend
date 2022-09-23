package com.sofka.albertusview.application.adapters.bus;

import org.springframework.stereotype.Service;

@Service
public class RabbitMqEventBus implements EventBus {

    @Override
    public void publishPostCreated(PostViewModel postViewModel) {
        log.info("Publishing Post Created");
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE, RabbitMqConfig.PROXY_ROUTING_KEY_POST_CREATED, gson.toJson(postViewModel).getBytes()
        );
    }

    @Override
    public void publishCommentAdded(CommentViewModel commentViewModel) {
        log.info("Publishing comment added");
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE, RabbitMqConfig.PROXY_ROUTING_KEY_COMMENT_ADDED, gson.toJson(commentViewModel).getBytes()
        );
    }

}
