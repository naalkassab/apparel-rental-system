package apparel.rental.system.BorrowMe;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

//This class is used to establish a connection to the SQL Database used to store the program's data
public class DatabaseConnection {

  // This is a private static variable to ensure that one instance of DatabaseConnection is ever created
  private static DatabaseConnection OneConnection;
  private static Connection connection;

  private DatabaseConnection() {}
  /**
   * @return the same one instance of DatabaseConnection if it was already created
   */
  public static DatabaseConnection getInstance(){
    if (OneConnection == null) {
      OneConnection = new DatabaseConnection();
    }
    return OneConnection;
  }

  /**
   * @return an SQL connection
   */
  public Connection getConnection() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(getURL());
      } catch (SQLException ex) {
        System.out.println("There has been an error with retrieving with database\n" +ex.getMessage()+"\n"+ex.getErrorCode());
      }
    }
    return connection;
  }

  /**
   * get the URL associated with the Database
   */
  private static String getURL(){
    //Get the path of the database:
    Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    //set start of URL
    String urlStart = "jdbc:sqlite:";
    //set end of URL which is the name of the database in the Assignment file
    String urlEnd = "/622.db";
    //the final url is:
    return urlStart + path + urlEnd;
  }
}
