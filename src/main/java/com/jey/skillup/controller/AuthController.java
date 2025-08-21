package com.jey.skillup.controller;

import com.jey.skillup.request.AuthenticationRequest;
import com.jey.skillup.request.RegisterRequest;
import com.jey.skillup.service.AuthenticationService;
import com.jey.skillup.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication API Endpoints")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationService authenticationService;
    private UserService userService;

    @Operation(summary = "Register As New Student")
    @PostMapping("/register/student")
    public ResponseEntity<String> registerStudent(@RequestBody RegisterRequest request) throws Exception {
        authenticationService.register(request, "ROLE_STUDENT");
        return new ResponseEntity<>("Student registered successfully!", HttpStatus.CREATED);
    }

    @Operation(summary = "Register As New Instructor")
    @PostMapping("/register/instructor")
    public ResponseEntity<String> registerInstructor(@RequestBody RegisterRequest request) throws Exception {
        authenticationService.register(request, "ROLE_INSTRUCTOR");
        return new ResponseEntity<>("Instructor registered successfully!", HttpStatus.CREATED);

    }

    @Operation(summary = "Register As New Admin")
    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest request) throws Exception {
        authenticationService.register(request, "ROLE_ADMIN");
        return new ResponseEntity<>("Admin registered successfully!", HttpStatus.CREATED);
    }

    @Operation(summary = "Login With Email and Password")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request, HttpServletRequest httpRequest) {
        authenticationService.login(request, httpRequest);
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    @Operation(summary = "Logout Current Logged-In User")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        authenticationService.logout(request);
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }

    @Operation(summary = "Get Current Logged-In User")
    @GetMapping("/session-user")
    public String getLoggedInUser() {
        return userService.getCurrentUsername();
    }
}
