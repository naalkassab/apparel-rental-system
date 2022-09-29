package apparel.rental.system.Processes;

import apparel.rental.system.Users.Users;

import java.sql.SQLException;

public class renterSignupProcessor extends Processor{

  public renterSignupProcessor(Processor nextProcessor) {
    super(nextProcessor);
  }

  public void process(requestName request, Users user) {
    if (request.getRequestName().equals("Signup as renter")) {
      System.out.println("Signing up as renter");
      try {
        user.register();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    } else {
      super.process(request, user);
    }

  }
}
