package com.example.HelpMeRelax_v1_0;

public class ReplyModel {
    private int id;
    private int post_id;
    private String reply_username;
    private String reply_content;
    private boolean isAnonymous;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getReply_username() {
        return reply_username;
    }

    public void setReply_username(String reply_username) {
        this.reply_username = reply_username;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public ReplyModel(int id, int post_id, String reply_username, String reply_content, boolean isAnonymous) {
        this.id = id;
        this.post_id = post_id;
        this.reply_username = reply_username;
        this.reply_content = reply_content;
        this.isAnonymous = isAnonymous;
    }

    @Override
    public String toString() {
        return "ReplyModel{" +
                "id=" + id +
                ", post_id=" + post_id +
                ", reply_username='" + reply_username + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", isAnonymous=" + isAnonymous +
                '}';
    }
}
