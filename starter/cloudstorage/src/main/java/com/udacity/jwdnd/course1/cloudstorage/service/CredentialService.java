package com.udacity.jwdnd.course1.cloudstorage.service;
import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import com.udacity.jwdnd.course1.cloudstorage.model.*;


import java.util.ArrayList;
@Service
public class CredentialService {
    private final CredentialMapper credentialMapper;

    private UserService userService;

    public CredentialService(CredentialMapper credentialMapper, UserService userService) {
        this.credentialMapper = credentialMapper;
        this.userService = userService;
    }

    public ArrayList<Credential> getCredentialsByUserId(Integer userid) {
        return credentialMapper.getCredsByUserId(userid);
    }

    public int uploadCredential(Credential credential,Integer currUserID) {
        //source https://knowledge.udacity.com/questions/433666 + https://github.com/ploratran/SuperDuperDrive
        if (credential.getCredentialId() == null) {
            return credentialMapper.insert(new Credential(credential.getCredentialId(), credential.getUrl(), credential.getUsername(), credential.getPassword(), currUserID));
            //return noteMapper.insert(new Note(null,"123","123", currUserID));
        } else {
            return credentialMapper.updateCredential(new Credential(credential.getCredentialId(), credential.getUrl(), credential.getUsername(), credential.getPassword(), currUserID));
        }
    }


}
