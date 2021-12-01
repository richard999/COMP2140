public class Driver 
{

    

    private String DriverName;
    private String DriverAddress;
    private int DriverNumber;
    private static int NewId;
    private int DriverId;
    private int PackagesDelivered;
    private float DriverRevenue;
    


    public Driver(String DriverName, String DriverAddress, int DriverNumber){


        this.DriverName= DriverName;
        this.DriverAddress= DriverAddress;
        this.DriverNumber=DriverNumber;
        PackagesDelivered= 0;
        this.DriverRevenue=0;
        DriverId= NewId;
        NewId= NewId + 1;
        
    }

 // returns driver name (STRING)
    public String getDriverName()
    {
        return DriverName;

    }
 // returns driver addy (STRING)
    public String getDriverAddress()
    {
        return DriverAddress;

    }
 // Returns driver number (INT)
    public int getDriverNum()
    {
        return DriverNumber;

    }
 // returns driver ID (INT)
    public int getDriverId()
    {
        return DriverId;

    }
 // Returns driver revenue (FLOAT)
    public float getDriverRevenue()
    {
        return DriverRevenue;

    }
 // Updates driver revenue 
    public void updateDriverRevenue(float NewRev)
    {
        DriverRevenue= NewRev;

    }
    public static void main(String[] args) 
 
    {
    // This main method is for testing 
    /*
    String info;
    int inf;
    float in;
    Driver Driver1 = new Driver("Richard","Black River",5743976);
    info= Driver1.getDriverName();
    System.out.println(info);
    info= Driver1.getDriverAddress();
    System.out.println(info);
    inf=Driver1.getDriverNum();
    System.out.println(inf);
    Driver1.updateDriverRevenue(500);
    in=Driver1.getDriverRevenue();
    System.out.println(in);
    }

    */

}
// End of class
 




