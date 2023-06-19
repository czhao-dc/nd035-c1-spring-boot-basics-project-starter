package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.*;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

import java.util.ArrayList;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userId = #{userid}")
    ArrayList<Note> getNotesByUserId(Integer userid);

    @Insert("INSERT INTO NOTES (noteTitle, noteDescription, userId) VALUES(#{title}, #{description},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    //@Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    //File editNotesByNoteId(Integer noteId);


    @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
    boolean deleteNoteByNoteId(Integer noteId);
}
