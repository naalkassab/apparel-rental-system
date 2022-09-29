package apparel.rental.system.BorrowMe;

//this is a type of payment method
public class creditCard implements paymentMethods{

  private String cardName;
  private String cardNumber;
  private String cvv;
  private String expiryDate;

  public creditCard(String cardName, String cardNumber, String cvv, String expiryDate){
    this.cardName=cardName;
    this.cardNumber=cardNumber;
    this.cvv=cvv;
    this.expiryDate=expiryDate;
  }


  @Override
  public void pay(double amount) {
    System.out.println(amount  + " has been paid by credit card");
  }

  public String getPayType(){
    return "Credit card";
  }
}
