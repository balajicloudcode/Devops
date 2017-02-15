package com.capgemini.docker.domain;

/**
 * Created by sanrawat on 2/13/2017.
 */
public class Message {

    private int id;

    private String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
