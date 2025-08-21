package com.jey.skillup.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticationRequest {

    @Email(message = "Give a valid email")
    private String email;

    @Size(min = 5, max = 30, message = "Password must be at least 5 characters")
    private String password;
}
