package com.jey.skillup.controller;

import com.jey.skillup.response.UserResponse;
import com.jey.skillup.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin - Management API Endpoints")
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "Get All Users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return adminService.getAllUsers();
    }

    @Operation(summary = "Convert Student To Instructor")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{userId}")
    public UserResponse promoteToAdmin(@PathVariable @Min(1) long userId) {
        return adminService.convertStudentToInstructor(userId);
    }

    @Operation(summary = "Delete Student/Instructor")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable @Min(1) long userId) {
        adminService.deleteNonAdminUser(userId);
    }
}
