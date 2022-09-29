package apparel.rental.system.BorrowMe;

//this is a type of payment method
public class payPal implements paymentMethods{

  private String username;
  private String password;


  public payPal(String username, String password){
    this.username=username;
    this.password=password;

  }


  @Override
  public void pay(double amount) {
    System.out.println(amount  + " has been paid using payPal");
  }

  public String getPayType(){
    return "Paypal";
  }
}
