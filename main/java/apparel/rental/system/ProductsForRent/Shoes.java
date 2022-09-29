package apparel.rental.system.ProductsForRent;

import java.io.*;
import java.util.ArrayList;


public class Shoes extends itemsForRent implements Serializable {

    public Double itemSize;

    /**
     * create a new shoes object
     * This method is used to register an item for rent
     * @param name name of the item
     * @param brand brand of the item
     * @param color colour of the item
     * @param datesAvail the dates the item is available for rent
     * @param RenterPrice the price per day the renter sets for the item
     * @param shoeSize is the size of the object
     */
    public Shoes(String name, String brand, String color, ArrayList<String> datesAvail, Double RenterPrice
            , Double shoeSize) {
        super(name, brand, color, datesAvail, RenterPrice);
        this.itemSize = shoeSize;
    }


    /**
     * Return the renter's set price in addition to a 3% service fee for the website
     */
    public Double setPrice() {
        return this.RenterPrice*1.03;
    }

    /**
     * Display information about the shoe object
     */
    public void displayInfo() {

        System.out.println("Name: " + name + " Brand: " + brand + " Color: " + color +" Size: "+ itemSize);
        System.out.println("This item is priced at: " + setPrice() );
        System.out.println();

    }



}

