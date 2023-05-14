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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

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
    public String uploadFile(File file, Authentication authentication) {

        //uploadedFiles.add(file);
        fileService.uploadFile(file, authentication);
        //uploadedFiles.add(new File(null, file.getFilename(),file.getContenttype(),file.getFilesize(),file.getUserId(),file.getFiledata()));
        //model.addAttribute("files")
        //System.out.println(uploadedFiles.get(0).getFilename());



        return "redirect:/home";
    }


    @GetMapping()
    public String displayFile(@ModelAttribute User user, Model model,Authentication authentication) {
        //fileService.uploadFile(new File(null, "test.txt","txt","15kb",1,"testdata"));
        //uploadedFiles.add(new File(null, "test.txt","txt","15kb",1,"testdata"));
        //uploadedFiles.add(new File(null, "test1.txt","txt","15kb",1,"testdata"));
        //model.addAttribute("uploadedFiles",uploadedFiles);


        //model.addAttribute("uploadedFiles",fileService.displayFile());
        //User curr = userService.getUser(authentication.getName());
        //System.out.println(authentication.getName().getClass().getSimpleName());
        //System.out.println(authentication.getName());
        //model.addAttribute("uploadedFiles",fileService.getFilesByUserId("zcttony"));
        //System.out.println(fileService.getFilesByUserId("zcttony"));
        //System.out.println(authentication.getName());
        //fileService.getFilesByUserId('zcttony');

        User curr = userService.getUser(authentication.getName());

        //System.out.println(curr.getUserId());
        //System.out.println(curr.getUsername());
        model.addAttribute("uploadedFiles",fileService.getFilesByUserId(curr.getUserId()));
        //System.out.println(fileService.getFilesByUserId("zcttony"));
        return "home";
    }
}
