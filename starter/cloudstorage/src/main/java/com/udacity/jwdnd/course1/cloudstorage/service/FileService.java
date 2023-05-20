package com.udacity.jwdnd.course1.cloudstorage.service;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
//import org.graalvm.compiler.bytecode.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.ArrayList;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    private final FileMapper fileMapper;
    private UserService userService;

    public FileService(FileMapper fileMapper, UserService userService) {
        this.fileMapper = fileMapper;
        this.userService = userService;
    }

    public int uploadFile(MultipartFile file, Integer currUserID) throws IOException, IllegalStateException  {
        System.out.println(file);

        byte[] bytes = file.getBytes();
        InputStream fis = file.getInputStream();
        //User curr = userService.getUser(authentication.getName());
        //String fileName = multipartFile.getOriginalFilename();
        return fileMapper.insert(new File(null, file.getOriginalFilename(), file.getContentType(), file.getSize(),currUserID,bytes));
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

    public File downloadFilesByFileId(Integer fileId) {
        //
        return fileMapper.downloadFilesByFileId(fileId);
    }

    public boolean deleteFileByFileId(Integer fileId) {

        return fileMapper.deleteFileByFileId(fileId);
    }

}
