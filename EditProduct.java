import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditProduct extends JFrame {
    private JTextField  txtAmount; 
    private JTextField  txtName;
    private JTextField txtID;
    private JTextField  txtSellPrice; 
    private JButton     cmdSave;
    private JButton     cmdClose;
    private StockTable sTable;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Product> products;

 
    public EditProduct(StockTable sTable, ArrayList<Product> products){
        this.sTable = sTable;
        this.products = products;
        setTitle("Editing a Product");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter the id of the Product:"));
        txtID = new JTextField(4);
        pnlDisplay.add(txtID);
        pnlDisplay.add(new JLabel("Enter new Name or leave blank to keep old name:"));
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Enter new Sell Price or leave blank to keep old Sell Price:"));
        txtSellPrice = new JTextField(30);
        pnlDisplay.add(txtSellPrice);
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

    

