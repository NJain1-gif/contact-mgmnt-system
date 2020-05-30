package com.ehi.contactmanagementsystem.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

public @Data class CreateContactRequest {
    @NotEmpty(message = "First name can't be empty!")
    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("email")
    String email;

    @NotEmpty(message = "Contact number can't be empty!")
    @JsonProperty("contact")
    String contact;
}
