package apparel.rental.system.ProductsForRent;

import apparel.rental.system.BorrowMe.Purchase;

//this is an addon a customer can choose to add to their purchase
public class giftNote extends addOns{

  public giftNote(Purchase purchase) {
    this.purchase = purchase;
  }

  /**
   * @return total cost of the item and the additional add on
   */
  public double getCost(itemsForRent item) {
    return Math.round((2.00 + purchase.getCost(item)) * 100.0) / 100.0;
  }

  /**
   * @return description of what was added to the purchase
   */
  public String getDescription() {
    return purchase.getDescription() + "\nGift note was added";
  }

  /**
   * @return the individual cost of the add on
   */
  public double indiviualCost(){
    return 2.00;
  }
}
