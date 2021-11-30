public class Distributor {
    private String distributorName;
    private String distributorAddress;
    private int distributorID;
    private int amountOrdered;
    private double dprice;
    private int orderID;
    private static int nextId=0;

    public Distributor(String distributorName, String distributorAddress, int distributorID)
    {
        this.distributorName = distributorName;
        this.distributorAddress = distributorAddress;
        distributorID = nextId;
        nextId++;

    }
    
    public String getDname()
    {
      return distributorName;
    }
    
    public String getDAddress()
    {
        return distributorAddress;
    }

    public int getDID()
    {
     return distributorID;
    }

    public int getAmountOrdered()
    {
     return  amountOrdered;        
    }
    
    public double getDprice()
    {
        return dprice;
    }
    
    public int getOrderID()
    {
        return orderID;
    }

    public void updateAordered(int amountOrdered)
    {
       this.amountOrdered= amountOrdered; 
    }

    public void updateName(String distName)
    {
     this.distributorName = distName;
    }

    public void updateAddress(String distAddress)
    {
        this.distributorAddress = distName;
    }

    public void updatePrice(double Dprice)
    {   
     this.dprice = Dprice;
    }

    public void addDistributor(String distributorName, String distributorAddress, String distributorID)
    {

    }

    public void updateDistributor(String distributorName, String distributorAddress, String distributorID)
    {
        
    }

    public void removeDistributor(String distributorName)
    {
        
    }

}
