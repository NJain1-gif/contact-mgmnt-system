package com.ehi.contactmanagementsystem.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public @Data class GetContactDetailsResponse extends BaseResponse {
    @JsonProperty("contact_details_list")
    List<ContactDetailsResponse> contactDetailsResponseList;
}
