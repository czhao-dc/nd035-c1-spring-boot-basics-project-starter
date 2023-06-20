package com.udacity.jwdnd.course1.cloudstorage.model;
//Source=https://knowledge.udacity.com/questions/789322
public class NoteForm {
    private String title;
    private String description;

    private Integer userId;
    private Integer noteId;


    public NoteForm(String title, String description, Integer userId, Integer noteId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.noteId = noteId;

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
