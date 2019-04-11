package alarmClock;

import java.io.*;

import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;



public class CSV {

	static List<Alarm> alarmInfoList = new ArrayList<>();
	static int listCounter = 0;



	//TODO Alarm Time is 24 hr time for simplicity, date format is  MM-DD
	public static void writeCSV(Alarm a) {

		String fileName = "AlarmInfo.csv";
		String fileLine = "";
		PrintWriter writer = null;
		// String name = null, message = null;
		//int month = 0, day = 0, hour = 0, minute = 0, seconds = 0, listCounter = 0;

		try{
			FileWriter fw = new FileWriter(fileName, true);

			alarmInfoList.add(a);

			//Writing the argument inputs
			fw.write(alarmInfoList.get(listCounter).getName() + "," +  alarmInfoList.get(listCounter).getMessage() + "," + alarmInfoList.get(listCounter)+"\n");
			fw.close();
			listCounter++;

		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void writeAfterRemoveCSV()
	{
		String fileName = "AlarmInfo.csv";
		String fileLine = "";
		PrintWriter writer = null;
		// String name = null, message = null;
		//int month = 0, day = 0, hour = 0, minute = 0, seconds = 0, listCounter = 0;

		try{
			FileWriter fw = new FileWriter(fileName, true);

			//Writing the argument inputs
			fw.write(alarmInfoList.get(listCounter).getName() + "," +  alarmInfoList.get(listCounter).getMessage() + "," + alarmInfoList.get(listCounter)+"\n");
			fw.close();
			listCounter++;

		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void readCSV() 
	{
		String fileName = "AlarmInfo.csv";


		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) 
			{
				String[] values = line.split(",\\s*");
				Alarm al = new Alarm(values[0], values[1], Long.valueOf(values[2]), Long.valueOf(values[3]), Long.valueOf(values[4]));
				alarmInfoList.add(al); 

				// If you want to fetch a certain group of information, use alarmInfoList.get() to fetch the whole group
				// From the 2d array

				//output array to console for quick testing
				// System.out.println(alarmInfoList);

			}


		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JComboBox<Alarm> getList()
	{
		JComboBox<Alarm> jcbA = new JComboBox<Alarm>();
		for(int i = 0; i < alarmInfoList.size(); i++)
		{
			jcbA.addItem(alarmInfoList.get(i));
		}
		return jcbA;
	}
	
	public void remove(Alarm al)
	{
		for(int i = 0; i < alarmInfoList.size(); i++)
		{
			
			if (alarmInfoList.get(i).equals(al))
			{
				String name = alarmInfoList.get(i).getName();
				alarmInfoList.remove(i);
				JOptionPane.showMessageDialog(null, "Alarm " + name + " removed.");
				
				break;
				
			}
		}
	}

}
