
public class DeliveryMen extends User {
  
    private int deliveryID;
    private int amountDelivered;
    private int trips=0;
    private int hours;
		private double pay;
    private static int nextId=0;
   

    public DeliveryMen(String username,String password, int trips, int hours)
    {
        super(username, password);
        this.trips = trips;
        this.hours = hours;
        deliveryID = nextId;
        nextId++;
				pay=0;
    }
    
	
    public int getDeliveryID()
    {
      return deliveryID;
    }
    

    public int getTrips()
    {
     return trips;
    }

    public int getAmountDelivered()
    {
     return  amountDelivered;        
    }
    
    public int gethours()
    {
        return hours;
    }

    public void updateAmountdelivered(int aDelivered)
    {
       this.amountDelivered= aDelivered; 
    }

    public void updateHours(int time)
    {
     this.hours = time;
    }

    public void updateTrips()
    {
        this.trips+=1;
    }
    
    public void updateDeliveryID(int delivID)
    {   
     this.deliveryID = delivID;
    }

		public void updatePay(double pay){
			this.pay = pay;
		}

		public double getPay(){
			return pay;
		}
}