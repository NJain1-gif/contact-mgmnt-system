package com.ehi.contactmanagementsystem.service.impl;

import com.ehi.contactmanagementsystem.models.ContactDetails;
import com.ehi.contactmanagementsystem.repositories.ContactDetailsRepository;
import com.ehi.contactmanagementsystem.requests.CreateContactRequest;
import com.ehi.contactmanagementsystem.requests.DeleteContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.GetContactDetailsRequest;
import com.ehi.contactmanagementsystem.requests.UpdateContactDetailsRequest;
import com.ehi.contactmanagementsystem.responses.BaseResponse;
import com.ehi.contactmanagementsystem.responses.ContactDetailsResponse;
import com.ehi.contactmanagementsystem.responses.GetContactDetailsResponse;
import com.ehi.contactmanagementsystem.service.ContactManagementService;
import com.ehi.contactmanagementsystem.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContactManagementServiceImpl implements ContactManagementService {
    private Logger logger = Logger.getLogger(ContactManagementServiceImpl.class);

    @Autowired
    ContactDetailsRepository contactDetailsRepository;

    @Override
    public GetContactDetailsResponse getContactDetails(GetContactDetailsRequest getContactDetailsRequest) throws Exception{
        GetContactDetailsResponse response = new GetContactDetailsResponse();
        List<ContactDetails> contactDetailsList = new ArrayList<>();
        if(getContactDetailsRequest.getContact() != null || getContactDetailsRequest.getEmail() != null){
            ContactDetails contactDetails;
            if(getContactDetailsRequest.getContact() != null){
                 contactDetails = contactDetailsRepository.findByContact(getContactDetailsRequest.getContact());
                logger.info(contactDetails);

            } else {
                contactDetails = contactDetailsRepository.findByEmail(getContactDetailsRequest.getEmail());
                logger.info(contactDetails);

            }
            if(contactDetails != null) {
                contactDetailsList.add(contactDetails);
                response.setErrorCode(Constants.ErrorCodes.SUCCESS);
            } else {
                response.setErrorCode(Constants.ErrorCodes.FAILURE);
                response.setMessage(Constants.ErrorMessages.INVALID_CONTACT_OR_EMAIL);
            }
        } else if(getContactDetailsRequest.getFirstName() != null || getContactDetailsRequest.getLastName() != null){
            if(getContactDetailsRequest.getFirstName() == null){
                contactDetailsList = contactDetailsRepository.findByLastName(getContactDetailsRequest.getLastName());
            } else if(getContactDetailsRequest.getLastName() == null){
                contactDetailsList = contactDetailsRepository.findByFirstName(getContactDetailsRequest.getFirstName());
            } else {
                contactDetailsList = contactDetailsRepository.findByFirstNameAndLastName(getContactDetailsRequest.getFirstName(), getContactDetailsRequest.getLastName());
            }
            if(contactDetailsList != null) {
                response.setErrorCode(Constants.ErrorCodes.SUCCESS);
            } else {
                response.setErrorCode(Constants.ErrorCodes.FAILURE);
                response.setMessage(Constants.ErrorMessages.INVALID_CONTACT_OR_EMAIL);
            }
        } else {
            response.setErrorCode(Constants.ErrorCodes.FAILURE);
            response.setMessage(Constants.ErrorMessages.INVALID_REQUEST);
        }
        if(!contactDetailsList.isEmpty()){
            createContactResponseList(response, contactDetailsList);
        }
        return response;
    }

    @Override
    public BaseResponse createContact(CreateContactRequest createContactRequest) throws Exception{
        BaseResponse response = new BaseResponse();
        ContactDetails contactDetails;
        if(contactDetailsRepository.findByContact(createContactRequest.getContact()) != null || contactDetailsRepository.findByEmail(createContactRequest.getEmail())!=null){
            response.setErrorCode(Constants.ErrorCodes.FAILURE);
            response.setMessage(Constants.ErrorMessages.DUPLICATE_CONTACT);
        } else {
            contactDetails = new ContactDetails();
            contactDetails.setContact(createContactRequest.getContact());
            if(createContactRequest.getEmail() != null) {
                contactDetails.setEmail(createContactRequest.getEmail());
            }
            contactDetails.setFirstName(createContactRequest.getFirstName());
            if(createContactRequest.getLastName() != null) {
                contactDetails.setLastName(createContactRequest.getLastName());
            }
            contactDetails.setStatus(1);
            contactDetails.setCreated_at(new Date());
            contactDetails.setUpdated_at(new Date());
            logger.info(contactDetails);
            contactDetailsRepository.save(contactDetails);
            response.setErrorCode(Constants.ErrorCodes.SUCCESS);
            response.setMessage(Constants.ErrorMessages.CONTACT_SAVED+createContactRequest.getContact());
        }
        return response;
    }

    @Override
    public BaseResponse updateContact(UpdateContactDetailsRequest updateContactDetailsRequest) throws Exception {
        BaseResponse response = new BaseResponse();
        ContactDetails contactDetails = contactDetailsRepository.findByContact(updateContactDetailsRequest.getOldContact());
        if(contactDetails == null){
            response.setErrorCode(Constants.ErrorCodes.FAILURE);
            response.setMessage(Constants.ErrorMessages.CONTACT_NOT_FOUND+updateContactDetailsRequest.getOldContact());
        } else {
            if(updateContactDetailsRequest.getNewContact() != null){
                contactDetails.setContact(updateContactDetailsRequest.getNewContact());
            }
            if(updateContactDetailsRequest.getNewEmail() != null){
                contactDetails.setEmail(updateContactDetailsRequest.getNewEmail());
            }
            if(updateContactDetailsRequest.getNewFirstName() != null){
                contactDetails.setFirstName(updateContactDetailsRequest.getNewFirstName());
            }
            if(updateContactDetailsRequest.getNewLastName() != null){
                contactDetails.setLastName(updateContactDetailsRequest.getNewLastName());
            }
            if(updateContactDetailsRequest.getNewStatus() != null){
                contactDetails.setStatus(updateContactDetailsRequest.getNewStatus());
            }
            contactDetails.setUpdated_at(new Date());
            contactDetailsRepository.save(contactDetails);

            response.setErrorCode(Constants.ErrorCodes.SUCCESS);
            response.setMessage(Constants.ErrorMessages.CONTACT_UPDATED+updateContactDetailsRequest.getOldContact());
        }
        return response;
    }

    @Override
    public BaseResponse deleteContact(DeleteContactDetailsRequest deleteContactDetailsRequest) throws Exception {
        BaseResponse response = new BaseResponse();
        ContactDetails contactDetails;
        if(deleteContactDetailsRequest.getContact() != null){
            contactDetails = contactDetailsRepository.findByContact(deleteContactDetailsRequest.getContact());
            deleteContactUtil(response, contactDetails, Constants.ErrorMessages.CONTACT_NOT_FOUND+deleteContactDetailsRequest.getContact());
        } else if(deleteContactDetailsRequest.getEmail() != null){
            contactDetails = contactDetailsRepository.findByEmail(deleteContactDetailsRequest.getEmail());
            deleteContactUtil(response, contactDetails, Constants.ErrorMessages.INVALID_EMAIL);
        } else {
            response.setErrorCode(Constants.ErrorCodes.FAILURE);
            response.setMessage(Constants.ErrorMessages.INVALID_CONTACT_OR_EMAIL);
        }
        return response;
    }

    private void deleteContactUtil(BaseResponse response, ContactDetails contactDetails, String invalidContact) {
        if (contactDetails != null) {
            contactDetailsRepository.delete(contactDetails);
            response.setErrorCode(Constants.ErrorCodes.SUCCESS);
            response.setMessage(Constants.ErrorMessages.CONTACT_DELETED);
        } else {
            setErrorDetails(response, Constants.ErrorCodes.FAILURE, invalidContact);
        }
    }

    private void setErrorDetails(BaseResponse response, String failure, String invalidContact) {
        response.setErrorCode(failure);
        response.setMessage(invalidContact);
    }

    private void createContactResponseList(GetContactDetailsResponse response, List<ContactDetails> contactDetailsList) {
        List<ContactDetailsResponse> contactDetailsResponseList = new ArrayList<>();
        for(ContactDetails contactDetails: contactDetailsList){
            ContactDetailsResponse contactDetailsResponse = new ContactDetailsResponse();
            contactDetailsResponse.setFirstName(contactDetails.getFirstName());
            if(contactDetails.getLastName() != null) {
                contactDetailsResponse.setLastName(contactDetails.getLastName());
            }
            contactDetailsResponse.setContact(contactDetails.getContact());
            if(contactDetails.getEmail() != null){
                contactDetailsResponse.setEmail(contactDetails.getEmail());
            }
            contactDetailsResponse.setStatus(contactDetails.getStatus());
            contactDetailsResponseList.add(contactDetailsResponse);
        }
        response.setContactDetailsResponseList(contactDetailsResponseList);
    }
}
