import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.io.*;

public class DistribTable extends JFrame{
    private JButton     add;
    private JButton     edit;
    private JButton     delete;
    private JButton     close;
    private JPanel      display;
    private ArrayList<Distributor> distributors = new ArrayList<Distributor>();
    private DistribTable thisForm;
    private JScrollPane scrollPane;
    private JTable      dtable;
    private DefaultTableModel   model;
    File g= new File("distributor.txt");
    
    public DistribTable(){
      new GridLayout(2,1);
      
        distributors =new ArrayList<Distributor>();
        display= new JPanel();
        String[] columnNames= {"ID", "Name","Item Name", "Address", "Price of Item Bought", "Amount Bought"};
        model=new DefaultTableModel(columnNames,0);
        dtable = new JTable(model);
        dtable.setEnabled(false);
        showTable(distributors);
        dtable.setPreferredScrollableViewportSize(new Dimension(500, distributors.size()*15 +50));
        dtable.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(dtable);

        add(scrollPane);
        add= new JButton("Add");
        edit= new JButton("Edit");
        delete= new JButton("Delete");
        close= new JButton("Close");

        
        add.addActionListener(new AddDistributorListener());
        delete.addActionListener(new DeleteDistributorListener());
        edit.addActionListener(new EditDistributorListener());
        close.addActionListener(new CloseButtonListener());

       
        display.add(add);
        display.add(edit);
        display.add(delete);
        display.add(close);

        add(display);

    }

    private void addToFile(Distributor d){
        String[] parts= d.toString().split(";");
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(g, true));
            writer.append(parts[0]);
            writer.append(' ');
            writer.append(parts[1]);
            writer.append(' ');
            writer.append(parts[2]);
            writer.append(' ');
            writer.append(parts[3]);
            writer.append(' ');
            writer.append(parts[4]);
            writer.append(' ');
            writer.append(parts[5]);
            writer.append("\n");
            writer.close();
        }catch(IOException e){

        }

    }

    public void addDist(Distributor d){
        distributors.add(d);
        addToTable(d);
        addToFile(d);
    }

    public void deleteDist(int ddx){
        try {
            distributors.remove(ddx);
            g.delete();
            for(Distributor d: distributors){
                addToFile(d);
            }
            model.removeRow(ddx);
        }catch(IndexOutOfBoundsException e){}

    }

    public void editDist (int ddx, Distributor d) {
        distributors.set(ddx, d);
        g.delete();
        for (Distributor di : distributors) {
            addToFile(di);
        }
        model.removeRow(ddx);
        String[] parts = d.toString().split(";");
        String[] item = {String.valueOf(ddx), parts[0], "" + parts[1], "" + parts[2], "" + parts[3]};
        model.insertRow(ddx,item);
    }

    private void showTable(ArrayList<Distributor> distributors)
    {
        for(Distributor d:distributors){
            addToTable(d);
        }


    }

    private void addToTable(Distributor d) {
        String[] parts = d.toString().split(";");
        String[] item = {parts[0], parts[1], "" + parts[2], "" + parts[3], "" + parts[4], "" + parts[5]};
        model.addRow(item);
    }


    public void addDistributor(String distributorName, int distributorID, String distributorAddress, double dprice, String itemName){
		distributors.add(new Distributor(distributorName, distributorID, distributorAddress, dprice, itemName));
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

    private class AddDistributorListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            DistributorEntry dist = new DistributorEntry(thisForm);
            System.out.println(dist);
        }
    }

    private class DeleteDistributorListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            DeleteDistributor dist = new DeleteDistributor(thisForm, distributors);
            System.out.println(dist);
        }
    }

    private class EditDistributorListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            EditDistributor dist = new EditDistributor(thisForm, distributors);
            System.out.println(dist);
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
