package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.itemsForRent;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;


//this is a type of delivery
public class expeditedShip implements Delivery{
  public String deliveryDescription() {
    return "This is an expedited delivery method";
  }

  /**
   * This method lets us know who the item was shipped to and by who
   */
  public void deliver(itemsForRent item, Customer customer, Renter renter) {
  System.out.println(item.getName() + " will be shipped to " + customer.Firstname+ "by " + renter.Firstname +
      "within 3 days");
  }
  /**
   * @return the delivery fees associated with this delivery method
   */
  public double deliveryFees() {
    return 25.00;
  }
}
