package apparel.rental.system.ProductsForRent;

import apparel.rental.system.BorrowMe.Purchase;

//this interface is used by add ons to the rental of the item
public abstract class addOns extends Purchase {
  Purchase purchase; // HAS-A

  public abstract String getDescription();
  public abstract double getCost(itemsForRent item);
  public abstract double indiviualCost();

}
