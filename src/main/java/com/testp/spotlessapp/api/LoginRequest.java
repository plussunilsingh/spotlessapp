package com.testp.spotlessapp.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Login request payload")
public class LoginRequest {
  @Schema(description = "Username for login", example = "john_doe")
  private String username;

  @Schema(description = "Password for login", example = "securePass123")
  private String password;

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
