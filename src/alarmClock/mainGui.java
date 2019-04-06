package alarmClock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class mainGui {

	private JFrame mainGui;

	public mainGui()
	{
		mainGui = new JFrame("Alarm Clock");
	}
	
	public JFrame getGui()
	{
		return mainGui;
	}
	
	public JPanel createGui() 
	{
		//Set up panel
		JPanel mainGui = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 2;
		c.gridy = 0;

		//button for dialog to add new alarm
		JButton addAlarm = new JButton("Add");
		addAlarm.setBounds(100,100,50,20);
		addAlarm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				String name;
				int[] monthHour = {1,2,3,4,5,6,7,8,9,10,11,12};
				
				int[] daySet = new int[31];
				for(int i = 1; i < 32; i++)
				{
					daySet[i-1] = i;
				}
				
				int[] minuteSet  = new int[60];
				for(int i = 1; i < 61; i++)
				{
					minuteSet[i-1] = i;
				}
				
				int month = 0;
				int day = 0;
				int hour = 0;
				int minute = 0;
				
				name = JOptionPane.showInputDialog (null, "What would you like to call your alarm?");
				
				if(JOptionPane.YES_OPTION == 1)
				{
					
					 remove(alarmsDropBox.getSelectedItem());
					 
				}

			}
			
		});
		
		
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
	
	

}
