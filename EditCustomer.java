import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class EditCustomer extends JFrame {
    
        private JTextField  txtEmail; 
        private JTextField  txtName;
        private JTextField  txtAddress;
        private JTextField txtID;
        private JButton     cmdSave;
        private JButton     cmdClose;
        private CusTable ctable;
        private JPanel      pnlCommand;
        private JPanel      pnlDisplay;
        private ArrayList<Customer> customers;
   
        public EditCustomer(CusTable ctable, ArrayList<Customer> customers){
            this.ctable = ctable;
            this.customers = customers;
            setTitle("Editing a Customer");
            pnlCommand = new JPanel();
            pnlDisplay = new JPanel();
            pnlDisplay.add(new JLabel("Enter the id of the Customer:"));
            txtID = new JTextField(4);
            pnlDisplay.add(txtID);
            pnlDisplay.add(new JLabel("Enter new Name or leave blank to keep old name:"));
            txtName = new JTextField(20);
            pnlDisplay.add(txtName);
            pnlDisplay.add(new JLabel("Enter new Address or leave blank to keep old Address:"));
            txtAddress = new JTextField(30);
            pnlDisplay.add(txtAddress);
            pnlDisplay.add(new JLabel("Enter new Email or leave blank to keep old Email:"));
            txtEmail = new JTextField(30);
            pnlDisplay.add(txtEmail);
            pnlDisplay.setLayout(new GridLayout(4,4));
            cmdSave      = new JButton("Save");
            cmdClose   = new JButton("Close");
    
            cmdSave.addActionListener(new EditListener());
            cmdClose.addActionListener(new VisibleListener());
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
    
        private class EditListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                
    
                
    
            }
    
        }
}
  