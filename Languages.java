package pl.edu.pw.fizyka.pojava.Wasilewska.Ignaciuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//jêzyki, Adam Ignaciuk

public class Languages extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;
	Menu menu;
	Drawpanel drawPanel;
	String ang="en";
	String country="US";
	Locale l1 = new Locale(ang,country);
	ResourceBundle r1 = ResourceBundle.getBundle("languages/language_en_ENG",l1);
	String pol="pl";
	String kraj1="PL";
	Locale l2 = new Locale(pol,kraj1);
	ResourceBundle r2 = ResourceBundle.getBundle("languages/language_pl_PL",l2);
	
	JMenuBar menuBar;
	JMenu menuFiles, language;
	JMenuItem menuSave, menuNewFile, polish, english;
	
	
	public Languages(Menu m) {
		
		menuBar=new JMenuBar();		 
		language = new JMenu("Select language");
		 
		english = new JMenuItem("ENG");
		english.setActionCommand("eng");
		english.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				language.setText(r1.getString("language"));
				menuSave.setText(r1.getString("menuZapisz"));
				menuNewFile.setText(r1.getString("menuNowyplik"));
				menuFiles.setText(r1.getString("file"));
				m.chooseFrequency.setText(r1.getString("frequency"));
				m.label.setText(r1.getString("photon"));
				m.selectMaterial.setText(r1.getString("selectMaterial"));
			}			 
		 });
		 
		polish = new JMenuItem("PL");
		polish.setActionCommand("pl");
		polish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				language.setText(r2.getString("language"));
				menuSave.setText(r2.getString("menuZapisz"));
				menuNewFile.setText(r2.getString("menuNowyplik"));
			    menuFiles.setText(r2.getString("file"));
			    m.chooseFrequency.setText(r2.getString("frequency"));
			    m.label.setText(r2.getString("photon"));
			    m.selectMaterial.setText(r2.getString("selectMaterial"));
			} 
		 });

		language.add(english);
		language.add(polish);
		menuBar.add(language);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}