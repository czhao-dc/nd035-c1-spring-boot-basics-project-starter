package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/credentials")
public class CredentialController {
    private UserService userService;
    private CredentialService credentialService;

    public CredentialController(UserService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @PostMapping("/addcredential")

    public String addNote(Authentication authentication, @ModelAttribute("newCredential") Credential credential, Model model)
    {
        String username = authentication.getName();
        User user = userService.getUser(username);
        //Credential credential = new Credential();
        System.out.println("Cred URL: " + credential.getUrl());


        credentialService.uploadCredential(credential,user.getUserId());
        model.addAttribute("addNoteSuccess", true);
        return "redirect:/home";
    }
    @GetMapping("/delete/{credentialId}")
    public String deleteCredential(@PathVariable("credentialId") int credentialId) {
        //Source https://github.com/ploratran/SuperDuperDrive
        //String errorMessage = null;

        int deletedCredentialId = credentialService.deleteCredential(credentialId);
        return "redirect:/home";


    }
}
