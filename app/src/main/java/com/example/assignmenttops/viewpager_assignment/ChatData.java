package com.example.assignmenttops.viewpager_assignment;

public class ChatData {

    private String name;
    private String chat;
    private String time;

    public ChatData() {

    }

    public ChatData(String name, String chat, String time) {
        this.name = name;
        this.chat = chat;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getDate() {
        return time;
    }

    public void setDate(String time) {
        this.time = time;
    }


}
