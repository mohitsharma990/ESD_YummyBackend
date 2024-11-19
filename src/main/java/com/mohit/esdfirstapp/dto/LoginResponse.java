package com.mohit.esdfirstapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(
        @JsonProperty("message")
        String message,
        @JsonProperty("token")
        String token
) {
}
