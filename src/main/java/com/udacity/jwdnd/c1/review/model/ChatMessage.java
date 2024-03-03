package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {

    public int messageid;

    public String username;
    public String messageText;

    public ChatMessage() {

    }

    public ChatMessage(int messageid, String username, String messageText) {
        this.messageid = messageid;
        this.username = username;
        this.messageText = messageText;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getmessagetext() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public String getMessageText() {
        return messageText;
    }
}
