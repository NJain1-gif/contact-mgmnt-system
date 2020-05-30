package com.ehi.contactmanagementsystem.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class ContactDetailsResponse {
    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("email")
    String email;

    @JsonProperty("contact")
    String contact;

    @JsonProperty("status")
    Integer status;
}
