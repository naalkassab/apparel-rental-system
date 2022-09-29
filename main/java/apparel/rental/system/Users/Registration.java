package apparel.rental.system.Users;

import java.sql.Connection;
import java.sql.SQLException;

//this is a regisration interface implemented by CustomerRegistration and UserRegistration
public interface Registration {
  void insertIntoDb(Users user, Connection conn) throws SQLException;
  void delete(Users user, Connection conn) throws SQLException;
}
