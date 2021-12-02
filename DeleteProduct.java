import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DeleteProduct extends JFrame {
    private JTextField  txtID;       
    private JButton     cmdDelete;
    private JButton     cmdClose;
    private StockTable sTable;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private ArrayList<Product> products;

    public DeleteProduct(StockTable sTable, ArrayList<Product> products){
        this.sTable = sTable;
        this.products= products;
        setTitle("Deleting a Product");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Enter Id of Product to be deleted:"));
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

    

