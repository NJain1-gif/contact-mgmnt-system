package com.ehi.contactmanagementsystem.utils;

public interface Constants {
    public interface ErrorCodes{
        public String SUCCESS = "success";
        public String FAILURE = "failure";
    }

    public interface ErrorMessages{
        public String INVALID_REQUEST = "Invalid Request";
        public String INVALID_CONTACT_OR_EMAIL = "Invalid contact or email ID";
        public String INVALID_EMAIL = "Email not found!";
        public String DUPLICATE_CONTACT = "Duplicate contact";
        public String CONTACT_SAVED = "Contact has been saved successfully with phone number: ";
        public String CONTACT_DELETED = "Contact has been deleted successfully";
        public String CONTACT_NOT_FOUND = "Invalid contact number: ";
        public String CONTACT_UPDATED = "Contact has been updated successfully for phone number: ";
    }
}
