package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
//import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.AuthenticationService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/home")
public class HomeController {
    //@RequestMapping("/home")
    //public String getHomePage() {
        //return "home";
    //}
    private final FileService fileService;
    private UserService userService;
    private UserMapper userMapper;




    public HomeController(FileService fileService, UserService userService, UserMapper userMapper) {
        this.fileService = fileService;
        this.userService = userService;
        this.userMapper = userMapper;


    }
    //@GetMapping()
    //public String homeView() {
    //    return "home";
    //}
    ArrayList<File> uploadedFiles = new ArrayList<>();



    @PostMapping()
    public String uploadFile(@RequestParam("fileUpload") MultipartFile fileUpload,Authentication authentication) throws IOException, IllegalStateException {


        //InputStream fis = fileUpload.getInputStream();
        Integer currUserID = userService.getUser(authentication.getName()).getUserId();
        //String fileOriginalName = fis.readAllBytes().
        fileService.uploadFile(fileUpload, currUserID);

        return "redirect:/home";
    }


    @GetMapping()
    public String displayFile(@ModelAttribute User user, Model model,Authentication authentication) {

        User curr = userService.getUser(authentication.getName());


        model.addAttribute("uploadedFiles",fileService.getFilesByUserId(curr.getUserId()));
        
        return "home";
    }

    @GetMapping()
}
