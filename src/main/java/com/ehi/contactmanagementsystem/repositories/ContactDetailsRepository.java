package com.ehi.contactmanagementsystem.repositories;

import com.ehi.contactmanagementsystem.models.ContactDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Integer> {
    List<ContactDetails> findByFirstName(String firstName);
    List<ContactDetails> findByLastName(String lastName);
    List<ContactDetails> findByFirstNameAndLastName(String firstName, String lastName);
    ContactDetails findByContact(String contact);
    ContactDetails findByEmail(String email);
}
