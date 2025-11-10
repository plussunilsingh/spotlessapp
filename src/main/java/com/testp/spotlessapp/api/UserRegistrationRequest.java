package com.testp.spotlessapp.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User registration request payload")
public class UserRegistrationRequest {
  @Schema(description = "Unique username", example = "john_doe")
  private String username;

  @Schema(description = "User password", example = "securePass123")
  private String password;

  // Getters and Setters
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
