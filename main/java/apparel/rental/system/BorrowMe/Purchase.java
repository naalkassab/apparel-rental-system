package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.itemsForRent;


//this class handles the purchasing aspect of the item
//it is the parent of OrderInvoice and addOns
public abstract class Purchase {

  String description = "A purchase transaction has been generated.";

  public String getDescription() {
    return description;
  }

  public abstract double getCost(itemsForRent item);

  /**
   * This method is used to create a delivery type
   * @param item that the customer wants to purchase
   * @param d, the delivery object
   * @return total of all costs gathered including delivery and addons
   */
  public double getAllCosts(itemsForRent item, Delivery d){
    double allCosts = getCost(item)+d.deliveryFees();
    System.out.println("The total for this purchase is " + allCosts);
    return getCost(item)+d.deliveryFees();
  }

  public void processPayment(paymentMethods paymentMethod, itemsForRent item, Delivery d){
    double total = getCost(item)+d.deliveryFees();
    paymentMethod.pay(total);
  }
}
