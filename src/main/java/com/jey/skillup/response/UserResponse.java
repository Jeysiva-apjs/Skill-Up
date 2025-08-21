package com.jey.skillup.response;

import com.jey.skillup.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserResponse {

    private long id;
    private String fullName;
    private String email;
    private List<Authority> authorities;

}
