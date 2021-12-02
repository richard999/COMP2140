import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductEntry extends JFrame {
    private JTextField  txtItemName;    
    private JTextField  txtAmount; 
    private JTextField  txtSellPrice; 
    private JTextField txtID;
    private JButton     cmdSave;
    private JButton     cmdClose;
    private StockTable sTable;
    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;

    public ProductEntry (StockTable sTable){
        this.sTable = sTable;
        setTitle("Entering a new Product");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Item Name:"));
        txtItemName = new JTextField(30);
        pnlDisplay.add(txtItemName);
        pnlDisplay.add(new JLabel("Amount:"));
        txtAmount = new JTextField(30);
        pnlDisplay.add(txtAmount);
        pnlDisplay.add(new JLabel("Sell Price:"));
        txtSellPrice = new JTextField(30);
        pnlDisplay.add(txtSellPrice);
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
            
            

        }
    }

}

