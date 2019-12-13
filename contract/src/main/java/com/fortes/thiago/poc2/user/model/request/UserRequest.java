package com.fortes.thiago.poc2.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "E-mail cannot be blank")
    @Email(message = "Email is not a valid format")
    private String email;
}
