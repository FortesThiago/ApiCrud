package com.fortes.thiago.poc2.user.resource;

import com.fortes.thiago.poc2.user.facade.UserContractFacade;
import com.fortes.thiago.poc2.user.model.request.UserRequest;
import com.fortes.thiago.poc2.user.model.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("POC API REST")
@RequestMapping(path = "/users")
@RestController
@AllArgsConstructor
public class Controller {
    private UserContractFacade facade;

    @ApiOperation(value = "Return a user from his id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return the user"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id) {
        return facade.findById(id);
    }

    @ApiOperation(value = "Save an user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid UserRequest user){
        return facade.create(user);
    }

    @ApiOperation(value = "Find all users saved")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Users found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @GetMapping
    public List<UserResponse> findAllUsers() {
        return facade.findAllUsers();
    }


    @ApiOperation(value = "Delete an user from his id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User deleted"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable String id){
        facade.deleteUserById(id);
    }
}
