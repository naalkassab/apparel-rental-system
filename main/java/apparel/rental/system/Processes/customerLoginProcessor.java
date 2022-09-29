package apparel.rental.system.Processes;

import apparel.rental.system.Users.RetrieveUser;
import apparel.rental.system.Users.Users;
import apparel.rental.system.BorrowMe.DatabaseConnection;


import java.sql.Connection;
import java.sql.SQLException;

public class customerLoginProcessor extends Processor{
  public customerLoginProcessor(Processor nextProcessor) {
    super(nextProcessor);
  }

  public void process(requestName request, Users user)
  {
    if (request.getRequestName().equals("Login as customer"))
    {
      System.out.println("Logging in as customer");
      //connect to the database
      Connection con = DatabaseConnection.getInstance().getConnection();
      //create a RetrieveUser object to start searching
      RetrieveUser retrieveUser = new RetrieveUser();
      //check for the user with the given email and password
      try {
        retrieveUser.checkUser(user.getEmail(),user.getPassword(),"Customers",con);
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
