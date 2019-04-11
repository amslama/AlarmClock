package alarmClock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class mainGui {

	private JFrame mainGui;

	//creates base JFrame
	public mainGui()
	{
		mainGui = new JFrame("Alarm Clock");
	}

	//gets gui
	public JFrame getGui()
	{
		return mainGui;
	}

	//creates the panel for the gui
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

				try {
					
				String name;
				String message;

				int month = 0;
				int day = 0;
				int hour = 0;
				int minute = 0;

				name = JOptionPane.showInputDialog (null, "What would you like to call your alarm?");

				JLabel monthQuery = new JLabel("What month would you like to set your alarm for?");
				JLabel dayQuery = new JLabel("What day would you like to set your alarm for?");
				JLabel timeQuery = new JLabel("What time would you like to set your alarm for?");
				c.gridx = 0;
				
				JPanel addMonth = new JPanel();
				addMonth.add(monthQuery, c);	
				
				JComboBox<Integer> monthSet = DateAndTime.monthTime();
				c.gridx = 1;
				

				addMonth.add(monthSet, c);
				
				int choice = JOptionPane.showConfirmDialog(null, addMonth, "Month Selection", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice == 0)
				{

					month = (int) monthSet.getSelectedItem();
					JOptionPane.showMessageDialog(null, "Month has been selected");

				}
				
				
				JComboBox<Integer> daySet = DateAndTime.day(month);
				JPanel addDay = new JPanel();
				c.gridx = 0;
				addDay.add(dayQuery, c);
				c.gridx = 1;
				addDay.add(daySet, c);
				
				choice = JOptionPane.showConfirmDialog(null, addDay, "Day Selection", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice == JOptionPane.OK_CANCEL_OPTION)
				{
					day = (int) daySet.getSelectedItem();
				}
				
				JComboBox<Integer> hourSet = DateAndTime.time();
				JComboBox<Integer> minuteSet = DateAndTime.minute();
				JPanel addTime = new JPanel();
				c.gridx = 0;
				addTime.add(timeQuery, c);
				c.gridy = 1;
				addTime.add(hourSet, c);
				c.gridx = 1;
				addTime.add(minuteSet, c);
				
				choice = JOptionPane.showConfirmDialog(null, addDay, "Day Selection", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice == JOptionPane.OK_CANCEL_OPTION)
				{
					hour = (int) hourSet.getSelectedItem();
					minute = (int) minuteSet.getSelectedItem();
				}
				
				if(month != 0 && day != 0 && hour != 0 && minute != 0)
				{
					
					message = JOptionPane.showInputDialog (null, "What message would you like your alarm to display?");
					Alarm al = new Alarm(name, message, month, day, hour, minute);
					CSV.writeCSV(al); 	
				}
				
				
				
				}
				catch(NullPointerException enull)
				{
					JOptionPane.showMessageDialog(null, enull.getStackTrace());
				}
				
			}

		});


		mainGui.add(addAlarm);


		//combobox for list of alarms
		//JComboBox alarmsDropBox = new JComboBox(/*here we will call a method to populate the list from the xml*/);
		//alarmsDropBox.setBounds(0, 125, 500, 20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		//mainGui.add(alarmsDropBox, c);

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

					//remove(alarmsDropBox.getSelectedItem());

				}

			}

		});
		c.gridx = 2;
		c.gridy = 1;
		mainGui.add(removeAlarm);

		return mainGui;
	}



}
