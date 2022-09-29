package apparel.rental.system.Processes;

import apparel.rental.system.Users.Users;

//this class processes the request
public abstract class Processor {

    private Processor nextProcessor;

    public Processor(Processor nextProcessor){
      this.nextProcessor = nextProcessor;
    };

    public void process(requestName request, Users user){
      if(nextProcessor != null)
        nextProcessor.process(request, user);
    };

}
