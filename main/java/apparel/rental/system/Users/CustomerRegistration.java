package apparel.rental.system.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//this class is used to register customers into the database
public class CustomerRegistration implements Registration {
  /**
   * This method is used to register a user into the database
   *
   * @param customer object that needs to be registered
   * @param conn     is the connection the database where the item needs to be registered
   */
  public void insertIntoDb(Users customer, Connection conn) throws SQLException {
    String sql = "INSERT INTO Customers(name,lastname,email,pass_word,street,city,zip) " +
        "VALUES (?,?,?,?,?,?,?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, customer.Firstname);
      pstmt.setString(2, customer.Lastname);
      pstmt.setString(3, customer.email);
      pstmt.setString(4, customer.password);
      pstmt.setString(5, customer.streetName);
      pstmt.setString(6, customer.city);
      pstmt.setString(7, customer.zipCode);
      pstmt.executeUpdate();

    }
    System.out.println("You have been signed up as a customer");
  }

  public void delete(Users customer, Connection conn) throws SQLException {
    String sql = "DELETE FROM Customers WHERE email = ? ";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, customer.email);
      pstmt.executeUpdate();

    }
    System.out.println("The username " +customer.getEmail()+ " has been deleted");

  }
}