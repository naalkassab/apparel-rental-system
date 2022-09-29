package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.itemsForRent;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;


//this is a type of delivery option
public class pickup implements Delivery {
  public String deliveryDescription() {
    return "This is a pick up purchase method";
  }
  /**
   * This method lets us know who the item will be picked up from customer by renter
   */
  public void deliver(itemsForRent item, Customer customer, Renter renter) {
    System.out.println(item.getName() + " will be picked up by " + customer.Firstname+ "from " + renter.Firstname);
  }
  /**
   * @return the delivery fee associated with this delivery method
   */
  public double deliveryFees() {
    return 00.00;
  }
}

