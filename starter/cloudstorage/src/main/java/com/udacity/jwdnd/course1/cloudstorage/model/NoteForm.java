package com.udacity.jwdnd.course1.cloudstorage.model;
//Source=https://knowledge.udacity.com/questions/789322
public class NoteForm {
    private String title;
    private String description;

    private Integer userId;

    public NoteForm(String title, String description, Integer userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
