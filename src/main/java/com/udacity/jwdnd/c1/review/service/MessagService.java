package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class MessagService {
//    public List<ChatMessage> chatMessage;
    @Autowired
    public MessageMapper messageMapper;


    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageSerive bean");
//        this.chatMessage = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        chatMessageObject.setUsername(auth.getPrincipal().toString());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
//                chatMessageObject.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
//                chatMessageObject.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
//                chatMessageObject.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
//        chatMessage.add(newMessage);
        messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
//        return chatMessage;
        return messageMapper.getAllMessages();
    }




}
