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
    public int uploadNote(Note note)  {

        return noteMapper.insert(note);
        //return noteMapper.insert(new Note(null,"123","123", currUserID));
    }

}