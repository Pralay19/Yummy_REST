package com.yummyrest.yummy_rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Customer_response(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("email")
        String email
) {

}
