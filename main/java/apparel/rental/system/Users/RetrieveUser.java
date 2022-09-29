package apparel.rental.system.Users;
//this class is used to retrieve user information from the database

import java.sql.*;

public class RetrieveUser {

  /**
   * This method is used to check if a user exists in the database and they can successfully login
   * @param email is the email used to login
   * @param enteredPass is the password they claim to have
   * @param userType is either "Renters" or "Customers"
   * @param conn is the sql connection
   */
  public Boolean checkUser(String email,String enteredPass,String userType, Connection conn) throws SQLException {
    email = "'" +email + "'";
    userType = "'" +userType + "'";
    String sql =
        "SELECT name, lastname, email, pass_word, street, city, zip FROM " + userType + "WHERE email = " + email;

    try (PreparedStatement select = conn.prepareStatement(sql)) {
         try (ResultSet rs = select.executeQuery()) {
              //while(rs.next()){
                //to be moved if this isnt needed
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String Registeremail = rs.getString("email");
                String Registerpass = rs.getString("pass_word");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String zip = rs.getString("zip");

                if (name == null){
                  System.out.println("The entered email address does not exist in our system");
                  return false;
                }

                if (!Registerpass.equals(enteredPass)  ){
                  System.out.println("Incorrect password");
                  return false;
                }

                else {
                  System.out.println("Correct username and password have been entered");
                  return true;
                }
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }

         }
    return null;

   }

}





