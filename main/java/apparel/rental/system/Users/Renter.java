package apparel.rental.system.Users;


//this class registers Renters who want to rent out their items
public class Renter extends Users{

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
    public Renter(String Firstname, String Lastname, String email, String password,
                  String streetName, String city,String zipCode) {
        super(Firstname, Lastname, email, password, streetName, city, zipCode);
        RegistrationType = new RenterRegistration();

    }

}
