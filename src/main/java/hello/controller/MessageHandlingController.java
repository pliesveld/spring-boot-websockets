package hello.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import hello.model.Message;
import hello.model.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MessageHandlingController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(),message.getText(),time);
    }
}
