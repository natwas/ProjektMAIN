package project;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Countings {
	
	PhotoelectricEffect effect; 
	Menu menu; 	
	JTextField text; 
	
	static final double exitWorkCes = 3.42;  //[J], 2.14 eV
	static final double exitWorkSilver = 6.81; //[J], 4.26 eV
	static final double exitWorkGold = 8.16; //[J], 5.1eV
	static final double exitWorkMagnes = 5.85; //[J],3.66 eV
	static final double planck = 0.00000000000000662; 	
	static final double electronMass = 0.00000000000910;
	double photonEnergy, x, y, electronSpeed, freq; //energia fotonu wyrazona w J
	
	public Countings (PhotoelectricEffect pe) {
		
		effect = pe; 
	}
	
	void countEnergy() {
		freq = Menu.frequencyValue; 
		photonEnergy = planck*freq; 
		DecimalFormat df=new DecimalFormat("######.##"); 
		y= photonEnergy*1000000000*1000;
		text = Menu.text1; 
		text.setText(df.format(y) + "x10^-31 J");		
	}
	void countElectronSpeed() { //liczenie prêdkoœci wybitego elektronu w zale¿noœci od pracy wyjscia wybranego materia³u
		
		 if (Menu.comboBox.getSelectedItem().equals("magnes")) {	 
			 x = (2*(photonEnergy - exitWorkCes))/electronMass;//tutaj wszystkie liczby sa rzêdu 10^-19,wiec wynik bedzie po prostu x
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 	 		 		
		 }		 
		 else if (Menu.comboBox.getSelectedItem().equals("gold")){
			 x = (2*(photonEnergy - exitWorkGold))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 
		 }		 
		 else if (Menu.comboBox.getSelectedItem().equals("silver")){	 
			 x = (2*(photonEnergy - exitWorkSilver))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 		 
		 } 		 
		 else if (Menu.comboBox.getSelectedItem().equals("ces")){		 
			 x = (2*(photonEnergy - exitWorkMagnes))/electronMass; 
			 electronSpeed = Math.sqrt(x); 
			 JOptionPane.showMessageDialog(null,x + " " + "m/s", "Prêdkoœæ wybitego elektronu" , JOptionPane.INFORMATION_MESSAGE); 		 
		 }
	}
}
