package com.ehi.contactmanagementsystem.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

public @Data class UpdateContactDetailsRequest {
    @NotEmpty(message = "Existing contact details cannot be null")
    @JsonProperty("old_contact")
    String oldContact;

    @JsonProperty("new_email")
    String newEmail;

    @JsonProperty("new_contact")
    String newContact;

    @JsonProperty("new_first_name")
    String newFirstName;

    @JsonProperty("new_last_name")
    String newLastName;

    @JsonProperty("new_status")
    Integer newStatus;
}
