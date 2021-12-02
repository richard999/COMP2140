import java.util.*;
public class Functionality{
	private ArrayList<DeliveryMen> drivers = new ArrayList<DeliveryMen>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Distributor> distributors = new ArrayList<Distributor>();
	private final double payRate = 1500.00;
	private static double profit=0;

	public Functionality(){
		
	}

//Accepts the neccessary attributes of a DeliveryMen object creates one then appends the list of Delivery Men.
	public void addDeliveryMen(String username,String password,  int trips, int hours){
		
	drivers.add(new DeliveryMen(username, password, trips, hours));
	}

//Traverses through the list of delivery men in databasse via the delivery id and removes them if found
	public void removeDeliveryMen(int dID){
		for(int i=0; i<drivers.size();i++){
			if(drivers.get(i).getDeliveryID()==dID){
				drivers.remove(i);
			}
		}
	}

//Calculates the pay of Delivery man then updates the proper attribute
	public void updateDManPay(int dID){
		for(DeliveryMen d:drivers){
			if(d.getDeliveryID()==dID){
				double pay = d.getTrips()*payRate;
				d.updatePay(pay);
			}
		}
	}

//Traverses through the list of Delivery Men and Products in the database via the delivery id and product id then updates the amount of trips taken by the delivery man, updates the remaining product stocks and profit from selling the product and updates the proper customer attributes.
	public void makeDelivery(int dID, Product prod,int prodAmount, Customer cus){
		for(DeliveryMen d:drivers){
			if(d.getDeliveryID()==dID){
				d.updateTrips();
			}
		}

		for(Product p:products){
			if(p.getProductID()==prod.getProductID()){
				int q = p.getProductAmount() - prodAmount;
				p.updateProductAmount(q);
				profit+=(prodAmount*p.calcProfit());
			}
		}

		for(Customer c:customers){
			if(c.getCID()==cus.getCID()){
				c.updateAmount(prodAmount);
			}
		}
	}

//Accepts the neccessary attributes of a Product object creates one then appends the list of Products.
	public void addProduct(String productName, int productAmount, double productSellPrice, double productCostPrice,int threshhold){
		products.add(new Product(productName, productAmount, productSellPrice, productCostPrice, threshhold));
	}

//Traverses through the list of products in databasse via the product id and removes them if found
	public void removeProduct(int pID){
		for(int i=0; i<products.size();i++){
			if(products.get(i).getProductID()==pID){
				products.remove(i);
			}
		}
	}


//Update/Override the product information
	public void updateProduct(int pID, String productName, int productAmount, double productSellPrice, double productCostPrice, int threshhold){
			for(int i=0; i<products.size();i++){
				if(products.get(i).getProductID()==pID){
					products.get(i).updateProductName(productName);
					products.get(i).updateProductAmount(productAmount);
					products.get(i).updateProductSellPrice(productSellPrice);
					products.get(i).updateProductCostPrice(productCostPrice);
					products.get(i).updateThreshhold(threshhold);
			}
		}
	}

//Checks to see if product amount is below threshhold urging the owner to restock if found true.
	public String checkStock(int pID){
		String str = "Product not found";
		for(int i = 0; i < products.size();i++){
				if(products.get(i).getProductID()==pID){
					if(products.get(i).getProductAmount() < products.get(i).getThreshhold()){
						str = "Product: " + products.get(i).getProductName() + " is running low in stock. Remaining amount: " + products.get(i).getProductAmount();
					}
					str = "Product stock is above threshhold";
				}
		}
		return str;
	}

//Display the total profit made so far
	public double showProfit(){
		return profit;
	}

//Resets profit to 0
	public void resetProfit(){
		profit=0;
	}

//Accepts the neccessary attributes of a Customer object creates one then appends the list of Customers.
	public void addCustomer(String customerName, String customerAddress, String email, int amountBought){
		customers.add(new Customer(customerName, customerAddress, email,amountBought));
	}

//Traverse throught the customer databe via id and removes the customer if found
	public void removeCustomer(int cID){
		for(int i = 0; i < customers.size();i++){
			if(customers.get(i).getCID()==cID){
				customers.remove(i);
			}
		}
	}
	
	//Traverse throught customer databe via id and updates a specific customer
	public void updateCustomer(int customerID,String newName, String newAddress, String newEmail, int newAmountBought){
		for(int i = 0; i < customers.size();i++){
			if(customers.get(i).getCID()==customerID){
				customers.get(i).updateCname(newName);
				customers.get(i).updateCaddress(newAddress);
				customers.get(i).updateEmail(newEmail);
				customers.get(i).updateAmount(newAmountBought);
			}
		}
	}
	
	//Get tired the Distributor is the last one might not be up to answer answer calls till 12 tomorrow never get much sleep the night before either T_T
	public void addDistributor(String distributorName, String distributorAddress, double dprice, String itemName){
		distributors.add(new Distributor(distributorName, distributorAddress, dprice, itemName));
	}

//Traverse throught the distributor databe via id and removes the distributor if found
	public void removeDistirbutor(int dID){
		for(int i = 0; i < distributors.size();i++){
			if(distributors.get(i).getDID()==dID){
				distributors.remove(i);
			}
		}
	}

//Traverse throught distributor databe via id and updates a specific distributor
	public void updateDistributor(int dID, String distName, String distAddress, int distributorID, double dprice, int amount, String itemName){
		for(int i = 0; i < distributors.size();i++){
			if(distributors.get(i).getDID()==dID){
				distributors.get(i).updateName(distName);
				distributors.get(i).updateAddress(distAddress);
				distributors.get(i).updateAordered(amount);
				distributors.get(i).updatePrice(dprice);
				distributors.get(i).updateItemName(itemName);
			}
		}
	}

//Places an order with a specific distributor, updates the product amount in stocks and prints the product name and cost of order.
	public void placeDOrder(int dID, Product prod, int prodAmount){
		String str = "Distributor not found";
		for(int i = 0; i < distributors.size();i++){
			if(distributors.get(i).getDID()==dID){
				int newAmount = distributors.get(i).getAmountOrdered() + prodAmount;
				distributors.get(i).updateAordered(newAmount);
				str = "Order placed with Distributor: " + distributors.get(i).getDname() + "for " + prodAmount + " " + distributors.get(i).getItemName() + " costs: $" + distributors.get(i).getDprice() * prodAmount;
				prod.updateProductAmount(newAmount);
			}
		}
		System.out.println(str);
	}
}