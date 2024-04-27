# Property-Management-Portal

Property management portal is a web-based java project where house owners and customers can exchange information effectively and inexpensively. This system provides a user-friendly interface, satisfying the needs of the consumers.


There are four roles in this system: Owner, Admin, Customer, and Viewer.
- The viewer is the user who can only search and display properties. (Unregistered users)
- The owner is the user who owns the property and wants it to give it for rent/sale. The owner will upload all the details of the property such as the number of rooms, price etc...
- Admin manages all the users of the system.
- Customer is the one who is looking for a property. She/He can search the properties according to the requirements and get the results accordingly and submit an application for the property.

Dashboard Page for admins:
- Display the last 10 properties rented.
- Display 10 most recent customers.
- Add more features as you see fit.


####  Functional  Requirements
--- 
* Owners/Customers can register to the system.
* Owners can add properties.
    * Can upload pictures of the property.
    * Optional: Use cloud services like Microsoft Azure, Amazon S3 or Google Cloud Storage.
* Owners can see their own properties and manage them.
    * Can unlist, and edit the property.
* Owners and Customers can filter properties:
    * by price,
    * by property type,
    * by a number of rooms,
    * home type,
    * by location.
* Customers can submit an application to buy/rent the property.
    * Once an application is submitted, owner will get an email.
* Owners can display all applications and filter them
    * by property,
    * by submission date,
    * by location.
* Admin can manage customers and owners.
*  Admin can Activate/Deactivate customers and owners.
* Admin can reset passwords.
* Customers and owners can reset their password.
    * Users should follow a password reset link.
* Customers can add properties to their favorite lists.
    * Customers can have multiple favorite lists.
* Customers can manage their own favorite lists.
