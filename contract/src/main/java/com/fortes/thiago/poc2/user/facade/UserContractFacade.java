package com.fortes.thiago.poc2.user.facade;

import com.fortes.thiago.poc2.facade.UserImplFacade;
import com.fortes.thiago.poc2.user.mapper.UserMapperContract;
import com.fortes.thiago.poc2.user.model.request.UserRequest;
import com.fortes.thiago.poc2.user.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserContractFacade {
    UserImplFacade userImplFacade;

    public UserResponse findById(String id) {
        return UserMapperContract.mapToContract(userImplFacade.findById(id));
    }

    public UserResponse create(UserRequest user) {
        return UserMapperContract.mapToContract(userImplFacade.create(UserMapperContract.mapToImpl(user)));
    }

    public List<UserResponse> findAllUsers(){
        return userImplFacade.findAllUsers().stream()
                .map(UserMapperContract::mapToContract)
                .collect(Collectors.toList());
    }

    public void deleteUserById(String id){
        userImplFacade.deleteUserById(id);
    }
}
