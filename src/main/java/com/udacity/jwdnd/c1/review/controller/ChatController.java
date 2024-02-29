package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.service.MessagService;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessagService messageService;
    private MessageMapper messageMapper;

    public ChatController(MessagService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @GetMapping
    public String getChatPage(ChatForm newChatForm, Model model){
        model.addAttribute("chatMessages", this.messageMapper.getAllMessages());
        return "chat";
    }
    @PostMapping
    public String postChatPage(Authentication authentication, ChatForm chatForm, Model model){
        chatForm.setUsername(authentication.getName());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageMapper.getAllMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () { return new String[] { "Say", "Shout", "Whisper" }; }
}
