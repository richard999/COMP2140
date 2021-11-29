import java.util.ArrayList;

public class Customer{
  private String customerName;
  private int customerID;
  private String customerAddress;
  private String email;
  private int amountBought;
  private static int nextid =0;

  public Customer(String customerName, String customerAddress, String email, int amountBought){
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.email = email;
    this.amountBought = amountBought;
    customerID = nextid;
		nextid++;
  }

  public int getAmount(){
    return amountBought;
  }

  public String getCName(){
    return customerName;
  }

  public String getCAddress(){
    return customerAddress;
  }
  public String getEmail(){
    return email;
  }

  protected void setID(int customerID){
    this.customerID = customerID;
  }  

  public int getCID(){
    return customerID;
  }

  public static void resetId()
	{
		nextid=0;
	}

  public void updateCname(String name){
    customerName = name;
  }

  public void updateCaddress(String address){
    customerAddress = address;
  }

  public void updateAmount(int amount){
    amountBought = amount;
  }

  public void updateEmail(String mail){
    email = mail;
  }
}
