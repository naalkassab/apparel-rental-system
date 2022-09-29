package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.itemsForRent;

//this class represents how purchases are set up
//Decorators such as "insurance" can be added to OrderInvoice objects
public class OrderInvoice extends Purchase {

  public double getCost(itemsForRent item){
    return item.setPrice();
  }


}
