package com.ehi.contactmanagementsystem.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class GetContactDetailsRequest {
    @JsonProperty("email")
    String email;

    @JsonProperty("contact")
    String contact;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;
}
