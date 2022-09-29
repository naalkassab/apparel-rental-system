package apparel.rental.system.Users;

import apparel.rental.system.BorrowMe.DatabaseConnection;

import java.sql.SQLException;

//This class is the parent class for the two types of users, renters and customers
public abstract class Users {

    public String Firstname;
    public String Lastname;
    public String email;
    public String password;
    public String streetName;
    public String city;
    public String zipCode;



    public Registration RegistrationType;  // <----Composition / HAS-A for Strategy design pattern

    public void register() throws SQLException {
        RegistrationType.insertIntoDb(this, DatabaseConnection.getInstance().getConnection());
    }

    public void deleteRecord() throws SQLException {
        RegistrationType.delete(this, DatabaseConnection.getInstance().getConnection());
    }


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
    public Users(String Firstname, String Lastname, String email, String password,
                 String streetName,String city,String zipCode) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.email = email;
        this.password = password;
        this.streetName = streetName;
        this.city=city;
        this.zipCode=zipCode;
    }

    public String getEmail() {return email;}
    public String getPassword() {return password;}




}
