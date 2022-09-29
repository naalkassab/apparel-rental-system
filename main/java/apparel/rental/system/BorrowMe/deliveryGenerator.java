package apparel.rental.system.BorrowMe;

//This class generates deliveries based on the requested type
//It is like a delivery factory
public class deliveryGenerator {

  /**
   * This method is used to create a delivery type
   * @param type is the type of delivery requested by the customer
   * @return the delivery object
   */
  public static Delivery createDelivery(String type) {
    Delivery delivery = null;

    if (type.equals("pickup")) {
      delivery = new pickup();
    } else if (type.equals("standard shipping")) {
      delivery = new standardShip();
    } else if (type.equals("expedited shipping")) {
      delivery = new expeditedShip();
    }

    return delivery;
  }
}
