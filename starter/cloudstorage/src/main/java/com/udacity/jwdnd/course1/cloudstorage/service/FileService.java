package com.udacity.jwdnd.course1.cloudstorage.service;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.ArrayList;
@Service
public class FileService {
    private final FileMapper fileMapper;
    private UserService userService;

    public FileService(FileMapper fileMapper, UserService userService) {
        this.fileMapper = fileMapper;
        this.userService = userService;
    }

    public int uploadFile(File file, Authentication authentication) {
        User curr = userService.getUser(authentication.getName());
        return fileMapper.insert(new File(null, "zcttony", "txt", "125kb",curr.getUserId()));
        //return fileMapper.insert(new File(null, file.getFilename(), file.getContenttype(), file.getFilesize(), file.getUserId(),file.getFiledata()));
    }

    public ArrayList<File> getFilesByUserId(Integer userid) {
        return fileMapper.getFilesByUserId(userid);
    }
    //User user = userMapper.getUser(username);
    //List<File> fileList =
    //public List<File> displayFile(User username) {
    //    return fileMapper.getUser(username);


    //}

}
