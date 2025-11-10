package com.testp.spotlessapp.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Login response containing authentication token")
public class LoginResponse {
  @Schema(description = "JWT token", example = "mocked-jwt-token-for-john_doe")
  private String token;

  public LoginResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
