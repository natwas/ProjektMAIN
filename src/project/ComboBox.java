package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox<String>  {
	
	private static final long serialVersionUID = 1L;
	String choosenMaterial = "choosenMaterial"; 

	public ComboBox() {
		
		this.addItem("magnes");
		this.addItem("gold");
		this.addItem("silver");
		this.addItem("ces");
		this.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ComboBox.this.getSelectedItem().equals("magnes")) {
					choosenMaterial = "magnes"; 
				}
				else if (ComboBox.this.getSelectedItem().equals("gold")) {
					choosenMaterial = "gold"; 
				}
				else if (ComboBox.this.getSelectedItem().equals("silver")) {
					choosenMaterial = "silver"; 
				}
				else if (ComboBox.this.getSelectedItem().equals("ces")) {
		        	 
		    		choosenMaterial = "ces";   
				}
				
			}
		}); 
	}
}



