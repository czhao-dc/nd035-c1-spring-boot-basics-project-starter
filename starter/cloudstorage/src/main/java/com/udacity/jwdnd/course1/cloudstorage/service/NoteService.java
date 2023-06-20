package com.udacity.jwdnd.course1.cloudstorage.service;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    private UserService userService;

    public NoteService(NoteMapper noteMapper, UserService userService) {
        this.noteMapper = noteMapper;
        this.userService = userService;
    }

    public ArrayList<Note> getNotesByUserId(Integer userid) {
        return noteMapper.getNotesByUserId(userid);
    }
    //Source: knowledge
    public int uploadNote(Note note) {
        //source https://knowledge.udacity.com/questions/433666 + https://github.com/ploratran/SuperDuperDrive
        if (note.getNoteId() == null) {
            return noteMapper.insert(note);
            //return noteMapper.insert(new Note(null,"123","123", currUserID));
        } else {
            return noteMapper.updateNote(new Note(note.getNoteId(), note.getTitle(), note.getDescription(), note.getUserId()));
        }

    }

    public int updateNote(Note note) {
        return noteMapper.updateNote(new Note(note.getNoteId(), note.getTitle(), note.getDescription(), note.getUserId()));
    }

    public int deleteNote(int noteId) {
        return noteMapper.deleteNoteByNoteId(noteId);
    }

}
