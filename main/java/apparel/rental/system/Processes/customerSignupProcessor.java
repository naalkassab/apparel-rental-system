package apparel.rental.system.Processes;
import apparel.rental.system.Users.Users;


import java.sql.SQLException;

public class customerSignupProcessor extends Processor {
  public customerSignupProcessor(Processor nextProcessor) {
    super(nextProcessor);
  }

  public void process(requestName request, Users user) {
    if (request.getRequestName().equals("Signup as customer")) {
      System.out.println("Signing up in as customer");
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
