
public class User{
  private String username;
  private String password;

  public User(String username, String password){
    this.username = username;
    this.password = password;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public void updateUsername(String uName){
    //Scanner scan = new Scanner(System.in);
    //System.out.println("Enter new username")
    //String uName = scan.nextline();
    username = uName;
  }

  public void updatePassword(String pword){
    password = pword;
  }

  public void verifyLogin(String username){}

  

  
  
}