import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DistributorEntry extends JFrame {
        private JTextField  txtName;      
        private JTextField  txtItemName;    
        private JTextField  txtAmount; 
        private JTextField  txtCostPrice; 
        private JTextField txtAddress;
        private JTextField txtID;
        private JButton     cmdSave;
        private JButton     cmdClose;
        private DistribTable dTable;
        private JPanel      pnlCommand;
        private JPanel      pnlDisplay;
    
        public DistributorEntry (DistribTable dTable){
            this.dTable = dTable;
            setTitle("Entering a new Distributor");
            pnlCommand = new JPanel();
            pnlDisplay = new JPanel();
            pnlDisplay.add(new JLabel("Name:"));
            txtName = new JTextField(20);
            pnlDisplay.add(txtName);
            pnlDisplay.add(new JLabel("Address:"));
            txtAddress = new JTextField(30);
            pnlDisplay.add(txtAddress);
            pnlDisplay.add(new JLabel("Item Name:"));
            txtItemName = new JTextField(30);
            pnlDisplay.add(txtItemName);
            pnlDisplay.add(new JLabel("Amount:"));
            txtAmount = new JTextField(30);
            pnlDisplay.add(txtAmount);
            pnlDisplay.add(new JLabel("Cost Price:"));
            txtCostPrice = new JTextField(30);
            pnlDisplay.add(txtCostPrice);
            pnlDisplay.add(new JLabel("ID:"));
            txtID = new JTextField(30);
            pnlDisplay.add(txtID);

    
            pnlDisplay.setLayout(new GridLayout(6,6));
            cmdSave      = new JButton("Save");
            cmdClose   = new JButton("Close");
    
            cmdClose.addActionListener(new VisibleListener());
            cmdSave.addActionListener(new AddToListListener());
    
            pnlCommand.add(cmdSave);
            pnlCommand.add(cmdClose);
            add(pnlDisplay, BorderLayout.CENTER);
            add(pnlCommand, BorderLayout.SOUTH);
            pack();
            setVisible(true);
    
        }
    
        private class VisibleListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                dispose();
            }
        }
    
        private class AddToListListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                try
            {
                
                String name = txtName.getText();
                String addy = txtAddress.getText();
                String msg = txtEmail.getText();
                String amnt = txtAmnt.getText();
                String id = txtID.getText();
                int id1 = Integer.parseInt(id);
                int amnt1 = Integer.parseInt(amnt);
                cTable.addCust(new Customer(name, addy, msg, amnt1, id1));
                setVisible(false);


            } catch (NumberFormatException e){
            }
    
            }
        }
    
    }
    
