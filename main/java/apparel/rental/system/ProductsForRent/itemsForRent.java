package apparel.rental.system.ProductsForRent;

import java.io.Serializable;
import java.util.ArrayList;

//this class is the parent for all items listed for rent
public abstract class itemsForRent implements Serializable {

    public String name;
    public String brand;
    public String color;
    public ArrayList<String> datesAvail;
    public double RenterPrice;

    /**
     * This method is used to register an item for rent
     * @param name name of the item
     * @param brand brand of the item
     * @param color colour of the item
     * @param datesAvail the dates the item is available for rent
     * @param RenterPrice the price per day the renter sets for the item
     */
    public itemsForRent(String name, String brand, String color,ArrayList<String> datesAvail, Double RenterPrice)
    {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.datesAvail = datesAvail;
        this.RenterPrice = RenterPrice;

    }


    /**
     * This method gets the name of the item
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method gets the brand of the item
     */
    public String getBrand() { return brand; }

    /**
     * This method gets the base price of the item
     */
    public double getBasePrice()
    {   return RenterPrice; }

    /**
     * This method gets the colour of the item
     */
    public String getColor() {
        return color;
    }

    /**
     * This method sets the renting price of the item. A service fee is charged based on the item type
     */
    public abstract Double setPrice();


    //abstract method that will be set by each item for rent class
    abstract void displayInfo();



}
