# contact-management-system

Contact management Application implemented using Spring Boot, Maven and MySQL.
The application can be used for all CRUD operations on Contact details in DB (Table name: CONTACT_DETAILS). 

Project Structure:
--------------------
1. Package Controller
   This package is created to maintain all Controller classes. ContactManagementController class inside this package is the main
   RestController, where APIs are written for CRUD operations.
	 
2. Package Models
   This package is created to maintain all Entity classes. ContactDetails stores model fields for Contact.
    
3. Package Repositories (Persistent Layer)
   This package is created to implement of CRUD repositories. Class ContactDetailsRepository is used to do the DB opreations.
	 
4. Package Request
   This package is created to maintain all the Request classes. Classes inside this package will be used to define the request params      for the API calls.
	 
5. Package Response
   This package is created to maintain all the Response classes. Classes inside this package will be used to define the response params    the API will be returning.
	 
6. Package Service (Service Layer)
   This is the service layer which will be used to handle the business requirement. Required methods are declared in a Service              Interface, and the sub-package "impl" is created to write the implementation logic for service methods interface. All the method        implementation for business is written in impl classes.
	 
7. Package Utils
   Created to maintain all the utility classes. Constants interface inside this is created to maintain ErrorCodes and ErrorMessages.
	 
Application  testing
--------------------
Create entries in DataBase using SetUpQueries.sql in set-up folder. 
Changed DB details in application.properties file acoordingly.
APIs can be tested using Postman.

Below are postman curls for testing.

curl --location --request POST 'http://localhost:8080/contactManagementSystem/create-contact/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "first_name":"Abc",
  "last_name":"def",
  "contact":"1457689468",
  "email":"abc@gmail.com"
}'

curl --location --request PATCH 'http://localhost:8080/contactManagementSystem/update-contact/' \
--header 'Content-Type: application/json' \
--data-raw '{
	"old_contact":"0000000001",
	"new_first_name": "xyz123"
}'

curl --location --request GET 'http://localhost:8080/contactManagementSystem/get-contact-details/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "first_name":"Abc"
}'

curl --location --request DELETE 'http://localhost:8080/contactManagementSystem/delete-contact/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "email":"abc@gmail.com"
}'

