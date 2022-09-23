package com.sofka.albertusview.business.gateways;

public interface EventBus {

    void publishApplicationCreated(PostViewModel postViewModel);
    void publishBlockCreated(BlockViewModel blockViewModel);


}
