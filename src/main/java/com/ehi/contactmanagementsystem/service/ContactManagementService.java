package com.ehi.contactmanagementsystem.service;

import com.ehi.contactmanagementsystem.requests.CreateContactRequest;
import com.ehi.contactmanagementsystem.requests.DeleteContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.GetContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.UpdateContactDetailsRequest;
import com.ehi.contactmanagementsystem.responses.BaseResponse;
import com.ehi.contactmanagementsystem.responses.GetContactDetailsResponse;

public interface ContactManagementService {
    GetContactDetailsResponse getContactDetails(GetContactDetailsRequest getContactDetailsRequest) throws Exception;
    BaseResponse createContact(CreateContactRequest createContactRequest) throws Exception;
    BaseResponse updateContact(UpdateContactDetailsRequest updateContactDetailsRequest) throws Exception;
    BaseResponse deleteContact(DeleteContactDetailsRequest deleteContactDetailsRequest) throws Exception;
}
