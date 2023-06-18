package com.udacity.jwdnd.course1.cloudstorage.model;
//Source=https://knowledge.udacity.com/questions/789322
public class Note {
    private Integer noteId;
    private String title;
    private String description;
    private Integer userId;

    public Note()
    {

    }

    public Note(Integer noteId, String title, String description, Integer userId) {
        this.noteId = noteId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setNoteTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setNoteDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
