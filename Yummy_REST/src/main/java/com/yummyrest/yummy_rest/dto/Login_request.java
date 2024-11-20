package com.yummyrest.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record Login_request(@NotBlank(message = "Email is required")
                            @Email(message="Email must be in correct format")
                            @JsonProperty("email")
                            String email,
                            @NotBlank(message="Password is required")
                            @Size(min=3,max=6,message="Invalid password size")
                            @JsonProperty("password")
                            String password
                            ) {
}
