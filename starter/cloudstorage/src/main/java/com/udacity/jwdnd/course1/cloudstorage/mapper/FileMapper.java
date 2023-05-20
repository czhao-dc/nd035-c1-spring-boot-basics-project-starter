package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.udacity.jwdnd.course1.cloudstorage.model.*;


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

    @Select("SELECT filedata FROM FILES WHERE fileId = #{fileId)")
    byte[] getFile(Integer fileId);
}
