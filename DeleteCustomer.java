import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DeleteCustomer extends JFrame {
    private JTextField  txtID;      
    private JButton     cmdDelete;
    private JButton     cmdClose;
    private CusTable cTable;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Customer> customers;

    public DeleteCustomer(CusTable cTable, ArrayList<Customer> customers){
        this.cTable = cTable;
        this.customers= customers;
        setTitle("Deleting a Customer");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter Id of Customer to be deleted:"));
        txtID = new JTextField(5);
        pnlDisplay.add(txtID);
        pnlDisplay.setLayout(new GridLayout(4,4));
        cmdDelete      = new JButton("Delete");
        cmdClose   = new JButton("Close");

        cmdDelete.addActionListener(new DeleteFromListener());
        cmdClose.addActionListener(new VisibleListener());

        pnlCommand.add(cmdDelete);
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

    private class DeleteFromListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
          
        }
    }
}

    
