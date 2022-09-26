package com.sofka.albertus.application.controller;


import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/retrieve/{correlationId}")
public class SocketController {

  private static final Logger logger = Logger.getLogger(SocketController.class.getName());
  private static Map<String, Map<String, Session>> sessions;

  private final Gson gson = new Gson();


  public SocketController() {
    if (Objects.isNull(sessions)) {
      sessions = new ConcurrentHashMap<>();
    }
  }

  @OnOpen
  public void onOpen(Session session, @PathParam("correlationId") String correlationId) {
    logger.info("Connected from " + correlationId);
    var map = sessions.getOrDefault(correlationId, new HashMap<>());
    map.put(session.getId(), session);
    sessions.put(correlationId, map);
  }

  @OnClose
  public void onClose(Session session, @PathParam("correlationId") String correlationId) {
    sessions.get(correlationId).remove(session.getId());
    logger.info("Desconnect by " + correlationId);

  }

  @OnError
  public void onError(Session session, @PathParam("correlationId") String correlationId, Throwable throwable) {
    sessions.get(correlationId).remove(session.getId());
    logger.log(Level.SEVERE, throwable.getMessage());

  }

  public void sendModel(String correlationId, Object model) {

    var message = gson.toJson(model);
    if (Objects.nonNull(correlationId) && sessions.containsKey(correlationId)) {
      logger.info("sent from " + correlationId);

      sessions.get(correlationId).values()
          .forEach(session -> {
            try {
              session.getAsyncRemote().sendText(message);
            } catch (RuntimeException e){
              logger.log(Level.SEVERE, e.getMessage(), e);
            }
          });
    }
  }




  }


