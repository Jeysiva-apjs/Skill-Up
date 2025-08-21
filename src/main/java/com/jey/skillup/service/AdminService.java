package com.jey.skillup.service;

import com.jey.skillup.entity.User;
import com.jey.skillup.response.UserResponse;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
    UserResponse convertStudentToInstructor(long userId);
    void deleteNonAdminUser(long userId);
}