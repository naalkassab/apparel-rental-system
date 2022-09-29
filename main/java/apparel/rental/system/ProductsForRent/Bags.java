package apparel.rental.system.ProductsForRent;

import java.util.ArrayList;


public class Bags extends itemsForRent {


    /**
     * create a new shoes object
     * This method is used to register an item for rent
     * @param name name of the item
     * @param brand brand of the item
     * @param color colour of the item
     * @param datesAvail the dates the item is available for rent
     * @param RenterPrice the price per day the renter sets for the item
     */
    public Bags(String name, String brand, String color, ArrayList<String> datesAvail,
                Double RenterPrice) {
        super(name, brand, color, datesAvail, RenterPrice);

    }

    /**
     * Return the renter's set price in addition to a 5% service fee for the website
     */
    public Double setPrice() {
        return this.RenterPrice*1.05;
    }


    /**
     * Display information about the bag object
     */
    public void displayInfo() {
        System.out.println("Name: " + name + " Brand: " + brand + " Color: " + color);
        System.out.println("This item is priced at: " + RenterPrice);
        System.out.println();
    }



}
