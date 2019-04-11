package alarmClock;

import javax.swing.JFrame;



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