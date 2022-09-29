package apparel.rental.system.Processes;

import apparel.rental.system.Users.RetrieveUser;
import apparel.rental.system.Users.Users;
import apparel.rental.system.BorrowMe.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class renterLoginProcessor extends Processor {

  public renterLoginProcessor(Processor nextProcessor) {
    super(nextProcessor);
  }

  public void process(requestName request, Users user)
  {
    if (request.getRequestName().equals("Login as renter"))
    {
      System.out.println("Logging in as renter");
      //connect to the database
      Connection con = DatabaseConnection.getInstance().getConnection();
      //create a RetrieveUser object to start searching
      RetrieveUser retrieveUser = new RetrieveUser();
      //check for the user with the given email and password
      try {
        retrieveUser.checkUser(user.getEmail(),user.getPassword(),"Renters",con);
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    else
    {
      super.process(request, user);
    }
  }
}
