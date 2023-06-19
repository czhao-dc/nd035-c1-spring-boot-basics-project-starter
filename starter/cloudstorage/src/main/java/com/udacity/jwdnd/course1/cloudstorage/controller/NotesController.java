package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Source=https://knowledge.udacity.com/questions/789322
@Controller
@RequestMapping("/notes")
public class NotesController {
    private UserService userService;
    private NoteService noteService;
    public NotesController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/addnote")

    public String addNote(Authentication authentication, @ModelAttribute("newNote") NoteForm newNote, Model model)
    {
        String username = authentication.getName();
        User user = userService.getUser(username);
        Note note = new Note();
        System.out.println("Note Title: " + newNote.getTitle());
        String title = newNote.getTitle();
        note.setNoteTitle(title);
        System.out.println("Note Description: " + newNote.getDescription());
        String description = newNote.getDescription();
        note.setNoteDescription(description);
        note.setUserId(user.getUserId());
        System.out.println("Controller Layer: " + note.getTitle() + " --- " + note.getDescription() + " --- " + note.getUserId());
        noteService.uploadNote(note);
        model.addAttribute("addNoteSuccess", true);
        return "redirect:/home";
    }

    //Source knowledge
    @GetMapping("/home")
    public String getNotesList( User user, Authentication authentication, Model model) {
        User curr = userService.getUser(authentication.getName());

        System.out.println("whatis");
        System.out.println(model);
        System.out.println(noteService.getNotesByUserId(curr.getUserId()).get(0).getTitle());
        return "redirect:/home";
        //th:text="uploadedNotesItems.noteTitle"
        //th:each="uploadedNotesItems: ${notes}"
    }
}