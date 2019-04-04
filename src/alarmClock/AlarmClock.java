package alarmClock;

import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlarmClock {

	public static void main(String[] args) {
		//Creates GUI
		JFrame mainGUI = new JFrame("Alarm Clock");
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setSize(600,200);
		mainGUI.setLocationRelativeTo(null);

		mainGUI.add(createGui());
		mainGUI.setVisible(true);
	}
	
	public static JPanel createGui() 
	{
		
		JPanel mainGui = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 2;
		c.gridy = 0;

		JButton addAlarm = new JButton("Add");
		addAlarm.setBounds(100,100,50,20);
		
		mainGui.add(addAlarm);
		
		return mainGui;
	}

}
