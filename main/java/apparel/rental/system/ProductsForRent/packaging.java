package apparel.rental.system.ProductsForRent;

import apparel.rental.system.BorrowMe.Purchase;

// this is optional nice packaging that can be added by the customer in the event that they are gifting the purchase
public class packaging extends addOns{

  public packaging(Purchase purchase) {
    this.purchase = purchase;
  }

  /**
   * @return total cost of the item and the additional add on
   */
  public double getCost(itemsForRent item) {
    return Math.round((10.00 + purchase.getCost(item)) * 100.0) / 100.0;
  }

  /**
   * @return description of what was added to the purchase
   */
  public String getDescription() {
    return purchase.getDescription() + "\nPackaging was added";
  }

  /**
   * @return the individual cost of the add on
   */
  public double indiviualCost(){
    return 10.00;
  }

}
