package apparel.rental.system.Processes;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;


//this is a facade that encompasses processes associated with entering the website
public class WebsiteEntry {

  /**
   * This method handles what kind of request is needed to enter the website
   *
   * @param renter is the type of user on the website, a renter object
   * @param request is either "Signup as renter" or "Login as renter"
   */
  public void RenterEnterWebsite(Renter renter, String request) {
    Chain chain = new Chain();
    chain.process(new requestName(request), renter);
  }

  /**
   * This method handles what kind of request is needed to enter the website
   *
   * @param customer is the type of user on the website, a customer object
   * @param request is either "Login as customer" or "Signup as customer"
   */
  public void CustomerEnterWebsite(Customer customer, String request) {
    Chain chain = new Chain();
    chain.process(new requestName(request), customer);
  }
}
