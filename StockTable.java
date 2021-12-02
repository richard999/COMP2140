import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.io.*;

public class StockTable extends JFrame{
    private JButton     add;
    private JButton     edit;
    private JButton     delete;
    private JButton     close;
    private JPanel      display;
    private StockTable thisForm;
    private ArrayList<Product> products = new ArrayList<Product>();
    private JScrollPane scrollPane;
    private JTable      table;
    private DefaultTableModel   model;
    File h= new File("stock.txt");
    
    public StockTable(){
      new GridLayout(2,1);
      
        products =new ArrayList<Product>();
        display= new JPanel();
        String[] columnNames= {"ID", "Name","Price", "Amount in Stock"};
        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        table.setEnabled(false);
        showTable(products);
        table.setPreferredScrollableViewportSize(new Dimension(500, products.size()*15 +50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);

        add(scrollPane);
        add= new JButton("Add");
        edit= new JButton("Edit");
        delete= new JButton("Delete");
        close= new JButton("Close");

        
        add.addActionListener(new AddProductListener());
        delete.addActionListener(new DeleteProductListener());
        edit.addActionListener(new EditProductListener());
        close.addActionListener(new CloseButtonListener());

       
        display.add(add);
        display.add(edit);
        display.add(delete);
        display.add(close);

        add(display);

    }

    private void addToFile(Product p){
        String[] parts= p.toString().split(";");
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(h, true));
            writer.append(parts[0]);
            writer.append(' ');
            writer.append(parts[1]);
            writer.append(' ');
            writer.append(parts[2]);
            writer.append(' ');
            writer.append(parts[3]);
            writer.append(' ');
            writer.append("\n");
            writer.close();
        }catch(IOException e){

        }

    }

    public void addProd(Product p){
        products.add(p);
        addToTable(p);
        addToFile(p);
    }

    public void deleteProd(int pdx){
        try {
            products.remove(pdx);
            h.delete();
            for(Product p: products){
                addToFile(p);
            }
            model.removeRow(pdx);
        }catch(IndexOutOfBoundsException e){}

    }

    public void editProd (int pdx, Product p) {
        products.set(pdx, p);
        h.delete();
        for (Product pr : products) {
            addToFile(pr);
        }
        model.removeRow(pdx);
        String[] parts = p.toString().split(";");
        String[] item = {String.valueOf(pdx), parts[0], "" + parts[1], "" + parts[2], "" + parts[3]};
        model.insertRow(pdx,item);
    }

    private void showTable(ArrayList<Product> products)
    {
        for(Product p:products){
            addToTable(p);
        }


    }

    private void addToTable(Product p) {
        String[] parts = p.toString().split(";");
        String[] item = {parts[0], parts[1], "" + parts[2], "" + parts[3]};
        model.addRow(item);
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

    private class AddProductListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            ProductEntry prod = new ProductEntry(thisForm);
            System.out.println(prod);
        }
    }

    private class DeleteProductListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            DeleteProduct prod = new DeleteProduct(thisForm, products);
            System.out.println(prod);
        }
    }

    private class EditProductListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            EditProduct prod = new EditProduct(thisForm, products);
            System.out.println(prod);
        }
    }

    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

    }

  
}
