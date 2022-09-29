package apparel.rental.system.Processes;
import apparel.rental.system.Users.Users;

public class Chain {

    Processor chain;

    public Chain(){
      buildChain();
    }

    private void buildChain(){
      chain = new customerLoginProcessor
          (new customerSignupProcessor
              (new renterLoginProcessor
                  (new renterSignupProcessor(null))));
    }

    public void process(requestName request, Users user) {
      chain.process(request,user);
    }

  }

