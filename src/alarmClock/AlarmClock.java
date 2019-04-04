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
		JFrame mainGUI = new JFrame("Alarm Clock");
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setSize(600,200);
		mainGUI.setLocationRelativeTo(null);

		mainGUI.add(createGui());
		mainGUI.setVisible(true);
	}
	
	public static JPanel createGui() 
	{
		//Set up panel
		JPanel mainGui = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 2;
		c.gridy = 0;

		//button for dialog to add new alarm
		JButton addAlarm = new JButton("Add");
		addAlarm.setBounds(100,100,50,20);
		mainGui.add(addAlarm);
		
		
		//combobox for list of alarms
		JComboBox alarmsDropBox = new JComboBox(/*here we will call a method to populate the list from the xml*/);
		alarmsDropBox.setBounds(0, 125, 500, 20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		mainGui.add(alarmsDropBox, c);
		
		//button to remove alarm
		JButton removeAlarm = new JButton("Dismiss");
		addAlarm.setBounds(500,125,20,20);
		removeAlarm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this alarm?");
				if(JOptionPane.YES_OPTION == 1)
				{
					
					 remove(alarmsDropBox.getSelectedItem());
					 
				}

			}
			
		});
		c.gridx = 2;
		c.gridy = 1;
		mainGui.add(removeAlarm);
		
		return mainGui;
	}
	
	public static void remove(Object o)
	{
		
	}

}
