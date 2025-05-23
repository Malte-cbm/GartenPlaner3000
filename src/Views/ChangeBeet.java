package Views;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import Controller.BeetController;

public class ChangeBeet {

    public int xPos;
    public int yPos;
    public int breite;
    public int tiefe;
    public boolean neu;
        
    public ChangeBeet(BeetController bc){

	int wahl = bc.getSelected();

	ArrayList<Integer> data = bc.getSelectedData(wahl);
	
      JTextField xPos = new JTextField(5);
      JTextField yPos = new JTextField(5);	
      JTextField breite = new JTextField(5);
      JTextField tiefe = new JTextField(5);
      JTextField adresse = new JTextField(20);

      DefaultTableModel tmodel = new DefaultTableModel();
      String col[] = {"X", "Y", "Breite", "Tiefe"};
      tmodel.setColumnIdentifiers(col);

      //tmodel.setRowCount(0);
      tmodel.addRow(new Object[]{((data.get(0)-20)/40), ((data.get(1)-20)/40), (data.get(2)/40), (data.get(3)/40)});

      JTable table = new JTable();
      table.setModel(tmodel);
      JScrollPane scroll = new JScrollPane(table);
      scroll.setBounds(20,20, 100,100);
      
      JPanel myPanel = new JPanel();
      myPanel.add(scroll);
      myPanel.add(new JLabel("Neue x-Position: "));
      myPanel.add(xPos);
      myPanel.add(new JLabel("Neue y-Position: "));
      myPanel.add(yPos);
      myPanel.add(Box.createVerticalStrut(15));
      myPanel.add(new JLabel("Neue Breite: "));
      myPanel.add(breite);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Neue Tiefe: "));
      myPanel.add(tiefe);

      while(true) {
	  
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Aendere dein Beet!", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
	  
	  if(bc.formValidator(xPos.getText(), yPos.getText(), breite.getText(), tiefe.getText())){
	      
	      this.breite = Integer.parseInt(breite.getText());
	      this.tiefe = Integer.parseInt(tiefe.getText());
	      this.xPos = Integer.parseInt(xPos.getText());
	      this.yPos = Integer.parseInt(yPos.getText());
	      this.neu = true;
	      break;
	  }
	  else{
	      JOptionPane.showMessageDialog(null, "Das waren keine Integers du Otto");
	  }
      }
      else {break;}
      }
   }
}
