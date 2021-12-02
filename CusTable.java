import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.io.*;

public class CusTable extends JFrame{
    private JButton     add;
    private JButton     edit;
    private JButton     delete;
    private JButton     close;
    private JPanel      display;
    private CusTable thisForm;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private JScrollPane scrollPane;
    private JTable      ctable;
    private DefaultTableModel   model;
    File f= new File("customer.txt");
    
    public CusTable(){
      new GridLayout(2,1);
      
        customers =new ArrayList<Customer>();
        display= new JPanel();
        String[] columnNames= {"ID", "Name","Address", "Email"};
        model=new DefaultTableModel(columnNames,0);
        ctable = new JTable(model);
        showTable(customers);
        ctable.setEnabled(false);
        ctable.setPreferredScrollableViewportSize(new Dimension(500, customers.size()*15 +50));
        ctable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(ctable);

        add(scrollPane);
        add= new JButton("Add");
        edit= new JButton("Edit");
        delete= new JButton("Delete");
        close= new JButton("Close");

        
        add.addActionListener(new AddCustomerListener());
        delete.addActionListener(new DeleteCustomerListener());
        edit.addActionListener(new EditCustomerListener());
        close.addActionListener(new CloseButtonListener());

       
        display.add(add);
        display.add(edit);
        display.add(delete);
        display.add(close);

        add(display);

    }


    //Accepts the neccessary attributes of a Customer object creates one then appends the list of Customers.
	public void addCustomer(String customerName, String customerAddress, String email, int amountBought, int customerID){
		customers.add(new Customer(customerName, customerAddress, email,amountBought, customerID));
	}

    public void addCust(Customer c){
        customers.add(c);
        addToTable(c);
        addToFile(c);
    }

    public void deleteCust(int cdx){
        try {
            customers.remove(cdx);
            f.delete();
            for(Customer c: customers){
                addToFile(c);
            }
            model.removeRow(cdx);
        }catch(IndexOutOfBoundsException e){}

    }

    public void editCust (int cdx, Customer c) {
        customers.set(cdx, c);
        f.delete();
        for (Customer cu : customers) {
            addToFile(cu);
        }
        model.removeRow(cdx);
        String[] parts = c.toString().split(";");
        String[] item = {String.valueOf(cdx), parts[0], "" + parts[1], "" + parts[2], "" + parts[3]};
        model.insertRow(cdx,item);
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

    private void addToFile(Customer c){
        String[] parts= c.toString().split(";");
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
            writer.append(parts[0]);
            writer.append(' ');
            writer.append(parts[1]);
            writer.append(' ');
            writer.append(parts[2]);
            writer.append(' ');
            writer.append(parts[3]);
            writer.append("\n");
            writer.close();
        }catch(IOException e){

        }

    }

    private void showTable(ArrayList<Customer> customers)
    {
        for(Customer c:customers){
            addToTable(c);
        }


    }

    private void addToTable(Customer c) {
        String[] parts = c.toString().split(";");
        String[] item = {parts[0], parts[1], "" + parts[2], "" + parts[3]};
        model.addRow(item);
    }

    private class AddCustomerListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            CustomerEntry cust = new CustomerEntry(thisForm);
            System.out.println(cust);
        }
    }

    private class DeleteCustomerListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            DeleteCustomer cust = new DeleteCustomer(thisForm,customers);
            System.out.println(cust);
        }
    }

    private class EditCustomerListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            EditCustomer cust = new EditCustomer(thisForm, customers);
            System.out.println(cust);
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
