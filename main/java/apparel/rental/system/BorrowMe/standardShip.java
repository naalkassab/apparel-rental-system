package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.itemsForRent;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;


//this is a type of delivery
public class standardShip implements Delivery{

  public String deliveryDescription() {
    return "This is a standard delivery method";
  }

  /**
   * This method lets us know who the item was shipped to and by who
   */
  public void deliver(itemsForRent item, Customer customer, Renter renter) {
    System.out.println(item.getName() + " will be shipped to " + customer.Firstname+ "by " + renter.Firstname +
        "within 10 business days");
  }

  /**
   * @return the delivery fees associated with this delivery method
   */
  public double deliveryFees() {
    return 15.00;
  }

}
