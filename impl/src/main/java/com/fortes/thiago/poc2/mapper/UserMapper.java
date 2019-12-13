package com.fortes.thiago.poc2.mapper;

import com.fortes.thiago.poc2.model.UserModel;
import com.fortes.thiago.poc2.repository.UserEntity;

public class UserMapper {
    public static UserModel mapToModel(UserEntity userEntity) {
        return UserModel.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }

    public static UserEntity mapToEntity(UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .email(userModel.getEmail())
                .build();
    }
}
