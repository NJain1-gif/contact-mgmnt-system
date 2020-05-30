package com.ehi.contactmanagementsystem.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class DeleteContactDetailsRequest {
    @JsonProperty("email")
    String email;

    @JsonProperty("contact")
    String contact;
}
