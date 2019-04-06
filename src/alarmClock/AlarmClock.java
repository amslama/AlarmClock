package alarmClock;

import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlarmClock {

	public static void main(String[] args) {
		//Creates GUI
		mainGui mG = new mainGui();
		JFrame mainGui = mG.getGui();
		mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGui.setSize(600,200);
		mainGui.setLocationRelativeTo(null);

		mainGui.add(mG.createGui());
		mainGui.setVisible(true);
	}
	
	
	public static void remove(Object o)
	{
		
	}

}
