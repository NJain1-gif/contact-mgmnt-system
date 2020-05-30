package com.ehi.contactmanagementsystem.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class BaseResponse {
    @JsonProperty("error_code")
    String errorCode;

    @JsonProperty("message")
    String message;
}
