package com.udacity.jwdnd.course1.cloudstorage.mapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
@Mapper
//Source https://github.com/ploratran/SuperDuperDrive
public interface CredentialMapper {
    // GET all credentials from Credential DB by userId:
    @Select("SELECT * FROM CREDENTIALS WHERE userId = #{userId}")
    ArrayList<Credential> getCredsByUserId(int userId);

    // INSERT/ADD new url, username, password into Credential DB by credId:
    @Insert("INSERT INTO CREDENTIALS (url, username, password, userId) " +
            "VALUES (#{url}, #{username}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insert(Credential credential);

    // UPDATE/EDIT a new credential by credentialId:
    @Update("UPDATE CREDENTIALS SET url=#{url}, username=#{username}, password=#{password} " +
            "WHERE (credentialid=#{credentialId})")
    int updateCredential(Credential credential);

    // DELETE a credential by credentialId:
    @Delete("DELETE FROM CREDENTIALS WHERE credentialId=#{credentialId}")
    int deleteCredentialById(int credentialId);

    // GET a credential by its credentialId
    // use in CredentialController to retrieve a credential
    // in order to decrypt a password:
    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    Credential getCredentialById(int credentialId);
}
