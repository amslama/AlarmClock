package alarmClock;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;




public class AlarmClock {

	public static void main(String[] args) {
		//Creates GUI
		mainGui mG = new mainGui();
		JFrame mainGui = mG.getGui();
		mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGui.setSize(300,200);
		mainGui.setLocationRelativeTo(null);

		mainGui.add(mG.createGui());
		mainGui.setVisible(true);
		Timer t = new Timer(60000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < CSV.alarmInfoList.size(); i++) {
					//check each alarm in the arraylist
					if(CSV.alarmInfoList.get(i).expired()) {
						Alarm.snooze(CSV.alarmInfoList.get(i));
					}
				}
				
			}
		});
	}

}
