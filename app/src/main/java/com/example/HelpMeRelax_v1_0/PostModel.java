package com.example.HelpMeRelax_v1_0;

public class PostModel {

    private int id;
    private String username;
    private String title, content;
    private int postSessionID;
    private boolean isAnonymous;

    // constructors


    public PostModel(int id, String username, String title, String content, int postSessionID, boolean isAnonymous) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.postSessionID = postSessionID;
        this.isAnonymous = isAnonymous;
    }

    // toString is necessary for printing the contents of a class object

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", age=" + postSessionID +
                ", isAnonymous=" + isAnonymous +
                '}';
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostSessionID() {
        return postSessionID;
    }

    public void setPostSessionID(int postSessionID) {
        this.postSessionID = postSessionID;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
