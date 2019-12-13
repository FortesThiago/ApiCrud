package com.fortes.thiago.poc2.user.mapper;

import com.fortes.thiago.poc2.model.UserModel;
import com.fortes.thiago.poc2.user.model.request.UserRequest;
import com.fortes.thiago.poc2.user.model.response.UserResponse;

public class UserMapperContract {
    public static UserResponse mapToContract(UserModel userModel) {
        return UserResponse.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .email(userModel.getEmail())
                .build();
    }

    public static UserModel mapToImpl(UserRequest userRequest) {
        return UserModel.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build();
    }
}
