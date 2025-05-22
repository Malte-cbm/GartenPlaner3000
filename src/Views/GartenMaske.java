package Views;
import javax.swing.*;
import Controller.GartenController;

public class GartenMaske {

    public String adresse;
    public int breite;
    public int tiefe;
        
    public GartenMaske(GartenController gc){
	
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);
      JTextField adresse = new JTextField(20);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Adresse oder Name des Gartens: "));
      myPanel.add(adresse);
      myPanel.add(Box.createVerticalStrut(15));
      myPanel.add(new JLabel("Breite: "));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Tiefe: "));
      myPanel.add(yField);

      while(true) {
	  
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
	  
	  if(gc.formValidator(adresse.getText(), xField.getText(), yField.getText())){
	      this.adresse = adresse.getText();
	      this.breite = Integer.parseInt(xField.getText());
	      this.tiefe = Integer.parseInt(yField.getText());
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
