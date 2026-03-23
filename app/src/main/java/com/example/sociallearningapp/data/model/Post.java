package com.example.sociallearningapp.data.model;

public class Post {
    private String authorName;
    private String time;
    private String content;
    private int avatarResId;

    public Post(String authorName, String time, String content, int avatarResId) {
        this.authorName = authorName;
        this.time = time;
        this.content = content;
        this.avatarResId = avatarResId;
    }

    public String getAuthorName() { return authorName; }
    public String getTime() { return time; }
    public String getContent() { return content; }
    public int getAvatarResId() { return avatarResId; }
}
