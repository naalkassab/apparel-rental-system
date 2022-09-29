package apparel.rental.system.Users;

//this class registers customers who want to rent items
public class Customer extends Users {

    /**
     * This method is used to register a user
     * @param Firstname name of the item
     * @param Lastname brand of the item
     * @param email colour of the item
     * @param password the dates the item is available for rent
     * Their address info is also registered:
     * @param streetName name of the street
     * @param city city they reside in
     * @param zipCode their zipcode
     */
    public Customer(String Firstname, String Lastname, String email, String password,
                    String streetName, String city,String zipCode) {
        super(Firstname, Lastname, email, password, streetName, city, zipCode);
        RegistrationType = new CustomerRegistration();
    }



}