package com.fortes.thiago.poc2.facade;

import com.fortes.thiago.poc2.model.UserModel;
import com.fortes.thiago.poc2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserImplFacade {

    private UserService service;

    public UserModel create(UserModel user) {
        return service.create(user);
    }

    public UserModel findById(String id) {
        return service.findById(id);
    }

    public List<UserModel> findAllUsers(){
        return service.findAllusers();
    }

    public void deleteUserById(String id){
        service.deleteUserById(id);
    }
}
