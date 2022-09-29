package apparel.rental.system.BorrowMe;

import apparel.rental.system.ProductsForRent.Shoes;
import apparel.rental.system.ProductsForRent.giftNote;
import apparel.rental.system.ProductsForRent.insurance;
import apparel.rental.system.ProductsForRent.packaging;
import edu.bu.met.cs665.ProductsForRent.*;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderInvoiceTest {

  @Test
  public void getDescription() {
    OrderInvoice invoice = new OrderInvoice();
    assertEquals("A purchase transaction has been generated.", invoice.getDescription());
  }

  //confirm that the cost of the item for rent in the invoice is correct
  @Test
  public void getCost() {
    OrderInvoice invoice = new OrderInvoice();
    //create a list of dates available to add into shoe object creation
    ArrayList<String> datesAvail = new ArrayList<>();
    datesAvail.add("2022-12-12");
    Shoes s = new Shoes("Sneakers","LV","Black",datesAvail,12.00,6.5);
    //ensure that the price shown in the invoice is not equal to $12, since a service fee must be added
    assertEquals(s.setPrice(),invoice.getCost(s),0.00);

  }

  @Test
  //ensure that the cost includes all items such as addons
  public void getAllCosts() {

    //create a list of dates available to add into shoe object creation
    ArrayList<String> datesAvail = new ArrayList<>();
    Shoes s = new Shoes("Sneakers","LV","Black",datesAvail,12.00,6.5);

    //testing the addon:
    Purchase p = new OrderInvoice();
    System.out.println(p.getDescription() +"\n"+ p.getCost(s));

    //testing the addon insurance
    p = new insurance(p);
    System.out.println(p.getDescription() +"\n"+ p.getCost(s));
    assertEquals(25.35,p.getCost(s),0.00);

    //testing the addon packaging
    p = new packaging(p);
    System.out.println(p.getDescription() +"\n"+ p.getCost(s));
    assertEquals(35.35,p.getCost(s),0.00);

    //testing the addon giftnote
    p = new giftNote(p);
    System.out.println(p.getDescription() +"\n"+ p.getCost(s));
    assertEquals(37.35,p.getCost(s),0.00);


  }

  //testing getAllCosts with delivery
  @Test
  public void getAllCostsWithDelivery() {

    //create a list of dates available to add into shoe object creation
    ArrayList<String> datesAvail = new ArrayList<>();
    Shoes s = new Shoes("Sneakers","LV","Black",datesAvail,12.00,6.5);

    //testing standard shipping fees:
    Purchase p = new OrderInvoice();
    Delivery d1 = deliveryGenerator.createDelivery("standard shipping");
    assertEquals(27.36,p.getAllCosts(s,d1),0.00);

    //testing expedited shipping fees:
    Delivery d2 = deliveryGenerator.createDelivery("expedited shipping");
    assertEquals(37.36,p.getAllCosts(s,d2),0.00);

    //testing pick up shipping fees
    Delivery d3 = deliveryGenerator.createDelivery("pickup");
    assertEquals(12.36,p.getAllCosts(s,d3),0.00);
  }


}