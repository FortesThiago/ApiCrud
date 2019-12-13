package com.fortes.thiago.poc2.service;

import com.fortes.thiago.poc2.exception.ApiException;
import com.fortes.thiago.poc2.mapper.UserMapper;
import com.fortes.thiago.poc2.model.UserModel;
import com.fortes.thiago.poc2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public UserModel findById(String id) {
        return UserMapper.mapToModel(userRepository.findById(id).orElseThrow(()-> new ApiException("User not found", HttpStatus.NOT_FOUND)));
    }

    public UserModel create(UserModel user){
        return UserMapper.mapToModel(userRepository.save(UserMapper.mapToEntity(user)));
    }

    public List<UserModel> findAllusers() {
        return userRepository.findAll().stream().map(UserMapper::mapToModel).collect(Collectors.toList());
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}
