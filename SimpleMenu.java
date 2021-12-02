import javax.swing.*; // JFrame, JMenuBar, JMenu, JMenuItem
import java.awt.event.*; // ActionListener, ActionEvent

class SimpleMenu extends JFrame implements ActionListener {
   public SimpleMenu() {
      setBounds(40,40,600,480);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu myMenu = new JMenu("Menu");
      JMenuItem stock = new JMenuItem("Stock");
      stock.addActionListener(this);
      myMenu.add(stock);
      menuBar.add(myMenu);
      JMenuItem customers = new JMenuItem("Customers");
      customers.addActionListener(this);
      myMenu.add(customers);
      JMenuItem distributors = new JMenuItem("Distributors");
      distributors.addActionListener(this);
      myMenu.add(distributors);
      JMenuItem schedule = new JMenuItem("Schedule");
      schedule.addActionListener(this);
      myMenu.add(schedule);
      JMenuItem profits = new JMenuItem("Profits");
      profits.addActionListener(this);
      myMenu.add(profits);
      JMenuItem salary = new JMenuItem("Delivery Men Salary");
      salary.addActionListener(this);
      myMenu.add(salary);
      JMenuItem quit = new JMenuItem("Quit");
      quit.addActionListener(this);
      myMenu.add(quit);
}     
    
      public void actionPerformed(ActionEvent ae) {
      String choice = ae.getActionCommand();
      if (choice.equals("Quit")) {
         System.exit(0);
      }
      else if (choice.equals("Stock")) {
         StockTable sTable = new StockTable();
         sTable.setVisible(true); 
      }
      else if (choice.equals("Distributors")){
         DistribTable dTable = new DistribTable();
         dTable.setVisible(true); 
      }
      else if (choice.equals("Customers"))
      { 
         CusTable cTable = new CusTable();
         cTable.setVisible(true); 
      }
      else if (choice.equals("Schedule")){}
      else if (choice.equals("Profits")){}
      else if (choice.equals("Delivery Men Salary")){}
      
   }
}
  
  
