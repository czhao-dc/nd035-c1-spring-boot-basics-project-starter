package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller

public class HomeController {
    //@RequestMapping("/home")
    //public String getHomePage() {
        //return "home";
    //}
    private final FileService fileService;
    private UserService userService;

    private NoteService noteService;
    private UserMapper userMapper;




    public HomeController(FileService fileService, UserService userService, UserMapper userMapper,NoteService noteService) {
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
        this.userMapper = userMapper;


    }
    //@GetMapping()
    //public String homeView() {
    //    return "home";
    //}
    ArrayList<File> uploadedFiles = new ArrayList<>();
    ArrayList<Note> notes = new ArrayList<>();


    //@RequestMapping("/home")
    @PostMapping("/home")
    public String uploadFile(@RequestParam("fileUpload") MultipartFile fileUpload,Authentication authentication) throws IOException, IllegalStateException {


        //InputStream fis = fileUpload.getInputStream();
        Integer currUserID = userService.getUser(authentication.getName()).getUserId();
        //String fileOriginalName = fis.readAllBytes().
        fileService.uploadFile(fileUpload, currUserID);

        return "redirect:/home";
    }

    //@RequestMapping("/home")
    @GetMapping("/home")
    public String displayFile(@ModelAttribute User user, Model model,Authentication authentication,@ModelAttribute("newNote") NoteForm newNote) {

        User curr = userService.getUser(authentication.getName());


        model.addAttribute("uploadedFiles",fileService.getFilesByUserId(curr.getUserId()));
        model.addAttribute("notes", noteService.getNotesByUserId(curr.getUserId()));
        return "home";
    }

    //@RequestMapping()
    //Source = https://knowledge.udacity.com/questions/830529
    @GetMapping (value = "/files/download_file/{fileId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<byte[]> downloadFile(@PathVariable Integer fileId) throws IOException {
        //return fileService.downloadFilesByFileId(fileId);
        File file = fileService.downloadFilesByFileId(fileId);
        String fileName = file.getFilename();
        System.out.println(fileName);
        System.out.println(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContenttype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+fileName+"\"")
                .body(file.getFiledata());
    }


    @GetMapping("/files/delete_file/{fileId}")
    public String deleteFile(Authentication authentication,
                             @PathVariable Integer fileId,
                             Model model) {
        String userName = authentication.getName();
        User user = userService.getUser(userName);
        Integer userId = user.getUserId();
        fileService.deleteFileByFileId(fileId);
        model.addAttribute("uploadedFiles", fileService.getFilesByUserId(userId));
        model.addAttribute("successful", true);
        return "redirect:/home";
    }





}
