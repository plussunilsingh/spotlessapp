package com.testp.spotlessapp.api;

import io.swagger.v3.oas.annotations.Operation;
// Avoid wildcard imports: io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
// Avoid wildcard imports: io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
// Avoid wildcard imports: java.util.*
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Avoid wildcard imports: org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "Operations related to user registration and login")
public class UserController {
  private final Map<String, String> userStore = new HashMap<>();

  @Operation(
      summary = "Register a new user",
      description = "Creates a new user in the system with a username and password")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
      })
  @PostMapping("/register")
  public ResponseEntity<String> registerUser(
      @RequestBody(
              description = "User registration payload",
              required = true,
              content = @Content(schema = @Schema(implementation = UserRegistrationRequest.class)))
          @org.springframework.web.bind.annotation.RequestBody
          UserRegistrationRequest request) {
    if (userStore.containsKey(request.getUsername())) {
      return ResponseEntity.badRequest().body("User already exists");
    }
    userStore.put(request.getUsername(), request.getPassword());
    return ResponseEntity.ok("User registered successfully");
  }

  @Operation(
      summary = "User login",
      description = "Logs in a user and returns a mock authentication token")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Login successful",
            content = @Content(schema = @Schema(implementation = LoginResponse.class))),
        @ApiResponse(responseCode = "401", description = "Invalid credentials")
      })
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(
      @RequestBody(
              description = "User login credentials",
              required = true,
              content = @Content(schema = @Schema(implementation = LoginRequest.class)))
          @org.springframework.web.bind.annotation.RequestBody
          LoginRequest request) {
    String storedPassword = userStore.get(request.getUsername());
    if (storedPassword != null && storedPassword.equals(request.getPassword())) {
      return ResponseEntity.ok(new LoginResponse("mocked-jwt-token-for-" + request.getUsername()));
    }
    return ResponseEntity.status(401).body("Invalid credentials");
  }
}
