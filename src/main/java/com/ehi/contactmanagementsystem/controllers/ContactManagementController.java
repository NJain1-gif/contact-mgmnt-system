package com.ehi.contactmanagementsystem.controllers;

import com.ehi.contactmanagementsystem.requests.CreateContactRequest;
import com.ehi.contactmanagementsystem.requests.DeleteContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.GetContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.UpdateContactDetailsRequest;
import com.ehi.contactmanagementsystem.responses.BaseResponse;
import com.ehi.contactmanagementsystem.responses.GetContactDetailsResponse;
import com.ehi.contactmanagementsystem.service.ContactManagementService;
import org.apache.log4j.Logger;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/contactManagementSystem")
public class ContactManagementController {
    private Logger logger = Logger.getLogger(ContactManagementController.class);

    @Autowired
    ContactManagementService contactManagementService;

    @ApiMethod(path = "/get-contact-details", description = "API to get contact details")
    @RequestMapping(value = "/get-contact-details", method = RequestMethod.GET)
    public GetContactDetailsResponse getContactDetails(@RequestBody GetContactDetailsRequest getContactDetailsRequest) {
        GetContactDetailsResponse response = new GetContactDetailsResponse();
        try{
            response = contactManagementService.getContactDetails(getContactDetailsRequest);
        } catch (Exception e){
            logger.error("Exception occurred while fetching contact details");
        }
        return response;
    }

    @ApiMethod(path = "/create-contact", description = "API to create a new contact")
    @RequestMapping(value = "/create-contact", method = RequestMethod.POST)
    public BaseResponse createContact(@Valid @RequestBody CreateContactRequest createContactRequest) {
        BaseResponse response = new BaseResponse();
        try{
            response = contactManagementService.createContact(createContactRequest);
        } catch (Exception e){
            logger.error("Exception occurred while creating new contact: ", e);
        }
        return response;
    }

    @ApiMethod(path = "/update-contact", description = "API to update an existing contact")
    @RequestMapping(value = "/update-contact", method = RequestMethod.PATCH)
    public BaseResponse updateContact(@Valid @RequestBody UpdateContactDetailsRequest updateContactDetailsRequest) {
        BaseResponse response = new BaseResponse();
        try{
            response = contactManagementService.updateContact(updateContactDetailsRequest);
        } catch (Exception e){
            logger.error("Exception occurred while updating new contact: ", e);
        }
        return response;
    }

    @ApiMethod(path = "/delete-contact", description = "API to delete a contact")
    @RequestMapping(value = "/delete-contact", method = RequestMethod.DELETE)
    public BaseResponse deleteContact(@Valid @RequestBody DeleteContactDetailsRequest deleteContactDetailsRequest) {
        BaseResponse response = new BaseResponse();
        try{
            response = contactManagementService.deleteContact(deleteContactDetailsRequest);
        } catch (Exception e){
            logger.error("Exception occurred while updating new contact: ", e);
        }
        return response;
    }
}
