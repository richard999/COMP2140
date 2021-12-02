import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditDistributor extends JFrame {
    private JTextField  txtAmount; 
    private JTextField  txtName;
    private JTextField  txtItemName;
    private JTextField  txtAddress;
    private JTextField txtID;
    private JTextField  txtCostPrice; 
    private JButton     cmdSave;
    private JButton     cmdClose;
    private DistribTable dtable;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Distributor> distributors;

 
    public EditDistributor(DistribTable dtable, ArrayList<Distributor> distributors){
        this.dtable = dtable;
        this.distributors = distributors;
        setTitle("Editing a Distributor");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter the id of the Distributor:"));
        txtID = new JTextField(4);
        pnlDisplay.add(txtID);
        pnlDisplay.add(new JLabel("Enter new Name of Distributor or leave blank to keep old name:"));
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Enter new Name of item or leave blank to keep old name:"));
        txtItemName = new JTextField(20);
        pnlDisplay.add(txtItemName);
        pnlDisplay.add(new JLabel("Enter new Address or leave blank to keep old Address:"));
        txtAddress = new JTextField(30);
        pnlDisplay.add(txtAddress);
        pnlDisplay.add(new JLabel("Enter new Cost Price or leave blank to keep old cost Price:"));
        txtCostPrice = new JTextField(30);
        pnlDisplay.add(txtCostPrice);
        pnlDisplay.add(new JLabel("Enter new Amount in stock or leave blank to keep old amount:"));
        txtAmount = new JTextField(30);
        pnlDisplay.add(txtAmount);
        
        pnlDisplay.setLayout(new GridLayout(5,5));
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
