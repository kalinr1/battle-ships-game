package com.example.examprep1.models.dtoS.binding;

import com.example.examprep1.validations.validateUserLoginDTO.UserLoginValidate;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@UserLoginValidate
public class UserLoginDTO {

    @Size(min = 3, max = 10)
    private String username;

    @Size(min = 3)
    private String password;
}
