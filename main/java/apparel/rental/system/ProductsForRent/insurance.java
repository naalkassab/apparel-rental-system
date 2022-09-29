package apparel.rental.system.ProductsForRent;

import apparel.rental.system.BorrowMe.Purchase;

// this is optional insurance that can be added by the customer to
// avoid paying for damage and clean up fees of their item
public class insurance extends addOns{
  public insurance(Purchase purchase) {
    this.purchase = purchase;
  }

  /**
   * @return total cost of the item and the additional add on
   */
  public double getCost(itemsForRent item) {
    return Math.round((12.99 + purchase.getCost(item) )* 100.0) / 100.0;
  }

  /**
   * @return description of what was added to the purchase
   */
  public String getDescription() {
    return purchase.getDescription() + "\nInsurance was added";
  }

  /**
   * @return the individual cost of the add on
   */
  public double indiviualCost(){
    return 12.99;
  }
}
