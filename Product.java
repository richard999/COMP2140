import java.util.*;
public class Product {
  
    private int productID;
    private int productAmount;
    private String productName;
    private double productSellPrice;
		private double productCostPrice;
		private int threshhold =0;
    private static int nextId =0;
   

    public Product(String productName, int productAmount, double productSellPrice, double productCostPrice, int threshhold)
    {
        this.productAmount = productAmount;
        this.productName = productName;
        this.productSellPrice = productSellPrice;
				this.productCostPrice = productCostPrice;
				this.threshhold = threshhold;
        productID = nextId;
        nextId++;

    }
    
    public int getProductID()
    {
      return productID;
    }
    
    public String getProductName()
    {
        return productName;
    }

    public int getProductAmount()
    {
     return productAmount;
    }

    public double getProductSellPrice()
    {
     return  productSellPrice;        
    }

		public double getProductCostPrice()
    {
     return  productCostPrice;        
    }

		public int getThreshhold(){
			return threshhold;
		}
    
		public void updateProductName(String name){
			this.productName = name;
		}
		
    public void updateProductAmount(int amount)
    {
     this.productAmount = amount;
    }

    public void updateProductSellPrice(double price)
    {
        this.productSellPrice = price;
    }

		public void updateProductCostPrice(double price)
    {
        this.productCostPrice = price;
    }

		public void updateThreshhold(int threshhold){
			this.threshhold = threshhold;
		}

		public double calcProfit(){
			return (productSellPrice - productCostPrice);
		}
   
   public String toString()
	{
		return this.getProductID()+";"+this.productName +";"+this.productAmount+";"+this.productPrice;
	}
    
}