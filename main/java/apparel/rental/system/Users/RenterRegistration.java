package apparel.rental.system.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//this class is used to register renters into the database
public class RenterRegistration implements Registration{

  /**
   * This method is used to register a user into the database
   * @param renter object that needs to be registered
   * @param conn is the connection the database where the item needs to be registered
   */
  public void insertIntoDb(Users renter, Connection conn) throws SQLException {
    String sql = "INSERT INTO Renters(name,lastname,email,pass_word,street,city,zip) " +
        "VALUES (?,?,?,?,?,?,?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, renter.Firstname);
      pstmt.setString(2, renter.Lastname);
      pstmt.setString(3, renter.email);
      pstmt.setString(4, renter.password);
      pstmt.setString(5, renter.streetName);
      pstmt.setString(6, renter.city);
      pstmt.setString(7, renter.zipCode);
      pstmt.executeUpdate();

    }
    System.out.println("You have been signed up as a renter");
  }

  public void delete(Users renter, Connection conn) throws SQLException {
    String sql = "DELETE FROM Renters WHERE email = ? ";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, renter.email);
      pstmt.executeUpdate();

    }
    System.out.println("The username " +renter.getEmail()+ " has been deleted");

  }
}
