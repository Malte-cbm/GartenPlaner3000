package Views;

import javax.swing.*;
import java.util.Set;

public class LadeBox {

    public String wahl;
    
    public LadeBox(Set<String> fileListe){
	JPanel panel = new JPanel();
    
	panel.add(new JLabel("Such dir was aus: "));
    
	DefaultComboBoxModel model = new DefaultComboBoxModel();

	for (String file: fileListe){
	    model.addElement(file);
	}

	JComboBox comboBox = new JComboBox(model);
	panel.add(comboBox);
	
	int result = JOptionPane.showConfirmDialog(null, panel, "Welchen Garten laden?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	if (result == JOptionPane.OK_OPTION ) {
	    this.wahl = (String) comboBox.getSelectedItem();    
	}
    
	else {
	    JOptionPane.showMessageDialog( null, "Nichts gewaehlt!");
	}
    }
    
}
