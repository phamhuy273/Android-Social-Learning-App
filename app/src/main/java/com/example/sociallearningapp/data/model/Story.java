package com.example.sociallearningapp.data.model;

public class Story {
    private String userName;
    private int avatarResId;

    public Story(String userName, int avatarResId) {
        this.userName = userName;
        this.avatarResId = avatarResId;
    }
    public String getUserName() { return userName; }
    public int getAvatarResId() { return avatarResId; }


}
