
public class Distributor {
    private String distributorName;
    private String distributorAddress;
    private String itemName;
    private int distributorID;
    private int amountOrdered;
    private double dprice;
    private static int nextId=0;

    public Distributor(String distributorName, int distributorID, String distributorAddress, double dprice, String itemName)
    {
        this.distributorName = distributorName;
        this.itemName = itemName;
        this.distributorAddress = distributorAddress;
        this.dprice = dprice;
        distributorID = nextId;
        nextId++;

    }

       public String getItemName(){
        return itemName;
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

    public void updateAordered(int amount)
    {
       this.amountOrdered= amount; 
    }

    public void updateName(String distName)
    {
     this.distributorName = distName;
    }

    public void updateAddress(String distAddress)
    {
        this.distributorAddress = distAddress;
    }

    public void updatePrice(double dprice)
    {   
     this.dprice = dprice;
    }

		public void updateItemName(String name){
			this.itemName = name;
		}

    public String toString()
	{
		return this.getDID()+";"+this.distributorName +";"+this.distributorAddress+";"+this.itemName+";"+this.dprice +";"+this.getAmountOrdered();
	}
}
