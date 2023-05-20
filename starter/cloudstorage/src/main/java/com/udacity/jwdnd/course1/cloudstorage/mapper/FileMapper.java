package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.*;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import org.springframework.core.io.InputStreamResource;


import java.io.InputStream;
import java.util.ArrayList;

@Mapper
public interface FileMapper {

    //@Select("SELECT * FROM FILES WHERE userId = #{userId}")
    @Select("SELECT * FROM FILES WHERE userId = #{userId}")
    //List<File> getFilename();
    ArrayList<File> getFilesByUserId(Integer userid);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userId, filedata) VALUES(#{filename}, #{contenttype}, #{filesize}, #{userId},#{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(File file);

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File downloadFilesByFileId(Integer fileId);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    boolean deleteFileByFileId(Integer fileId);
}
