package apparel.rental.system.Processes;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;
import edu.bu.met.cs665.Users.*;
import org.junit.Test;

import java.sql.SQLException;



//This test ensures the functionality of all classes under the Processes Package
public class ChainTest {

  @Test
  public void process() throws SQLException {
    System.out.println("The chain of responsbility is tested by\n" +
        "signing up a new a renter account, " +
    "and then using that same account to login.\n " +
    "The tests passes if the renter can login with the newly created email and password");
    Chain chain1 = new Chain();

    //start the chain of responsibility given a request
    Renter renter1 = new Renter("Bobby","Smith","bobby.smith@gmail.com",
        "bob123","58th St","Boston","10090");

    //an email address can only be entered once into a database. Therefore we have to delete the user above
    //before we test it again to avoid getting any unique value errors from SQL
    renter1.deleteRecord();

    chain1.process(new requestName("Signup as renter"),renter1);
    chain1.process(new requestName("Login as renter"),renter1);

    System.out.println("The same testing is then applied to requests associated with customers");
    Chain chain2 = new Chain();

    //start the chain of responsibility given a request
    Customer customer1 = new Customer("Bobby","Smith","bobby.smith@gmail.com",
        "bob123","58th St","Boston","10090");

    //an email address can only be entered once into a database. Therefore we have to delete the user above
    //before we test it again to avoid getting any unique value errors from SQL
    customer1.deleteRecord();
    //start the chain
    chain2.process(new requestName("Signup as renter"),customer1);
    chain2.process(new requestName("Login as renter"),customer1);
  }
}