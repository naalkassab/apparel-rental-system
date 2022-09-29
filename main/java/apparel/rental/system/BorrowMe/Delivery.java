package apparel.rental.system.BorrowMe;
import apparel.rental.system.ProductsForRent.itemsForRent;
import apparel.rental.system.Users.Customer;
import apparel.rental.system.Users.Renter;

//This is a delivery interface implemented by all delivery methods
public interface Delivery {
  String deliveryDescription();
  void deliver(itemsForRent item, Customer customer, Renter renter);
  double deliveryFees();
}
