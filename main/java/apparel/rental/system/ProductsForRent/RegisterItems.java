package apparel.rental.system.ProductsForRent;

import java.sql.*;

public class RegisterItems {



  /**
   * This method is used to register an item for rent
   * @param shoes object that needs to be registered
   * @param conn is the connection the database where the item needs to be registered
   */
  public void insertIntoDb(Shoes shoes, Connection conn) throws SQLException {
    String sql = "INSERT INTO Shoes(item_name,item_brand,color,dates_avail,renter_price,size) " +
        "VALUES (?,?,?,?,?,?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)){
      pstmt.setString(1,shoes.name);
      pstmt.setString(2,shoes.brand);
      pstmt.setString(3,shoes.color);
      pstmt.setString(4,shoes.datesAvail.toString());
      pstmt.setDouble(5, shoes.RenterPrice);
      pstmt.setDouble(6, shoes.itemSize);
      pstmt.executeUpdate();

    }

  }

  /**
   * This method is used to register an item for rent
   * @param bag object that needs to be registered
   * @param conn is the connection the database where the item needs to be registered
   */
  public void insertIntoDb(Bags bag, Connection conn) throws SQLException {
    String sql = "INSERT INTO Bags(item_name,item_brand,color,dates_avail,renter_price) " +
        "VALUES (?,?,?,?,?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)){
      pstmt.setString(1,bag.name);
      pstmt.setString(2,bag.brand);
      pstmt.setString(3,bag.color);
      pstmt.setString(4,bag.datesAvail.toString());
      pstmt.setDouble(5, bag.RenterPrice);
      pstmt.executeUpdate();

    }

  }






}
