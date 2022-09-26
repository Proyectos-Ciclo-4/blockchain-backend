package com.sofka.albertus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class SocketApplication {

  public static void main(String[] args) {

    SpringApplication.run(SocketApplication.class, args);

  }
}