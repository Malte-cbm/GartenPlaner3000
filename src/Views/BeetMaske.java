package Views;
import javax.swing.*;
import Controller.BeetController;

public class BeetMaske {

    public int xPos;
    public int yPos;
    public int breite;
    public int tiefe;
        
    public BeetMaske(BeetController bc){
	
      JTextField xPos = new JTextField(5);
      JTextField yPos = new JTextField(5);	
      JTextField breite = new JTextField(5);
      JTextField tiefe = new JTextField(5);
      JTextField adresse = new JTextField(20);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("x-Position: "));
      myPanel.add(xPos);
      myPanel.add(new JLabel("y-Position: "));
      myPanel.add(yPos);
      myPanel.add(Box.createVerticalStrut(15));
      myPanel.add(new JLabel("Breite: "));
      myPanel.add(breite);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Tiefe: "));
      myPanel.add(tiefe);

      while(true) {
	  
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Lege dein Beet an!", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
	  
	  if(bc.formValidator(xPos.getText(), yPos.getText(), breite.getText(), tiefe.getText())){
	      
	      this.breite = Integer.parseInt(breite.getText());
	      this.tiefe = Integer.parseInt(tiefe.getText());
	      this.xPos = Integer.parseInt(xPos.getText());
	      this.yPos = Integer.parseInt(yPos.getText());
	      break;
	  }
	  else{
	      JOptionPane.showMessageDialog(null, "Das waren keine Integers du Otto");
	  }
      }
      else {break;}
      }

      //
   }
}
