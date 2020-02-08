package com.murilobatista.rxretrofit.model;

public class PostModel {
    public int userId;
    public int id;
    public String title;
    public String body;

    public PostModel() {
    }

    public PostModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}