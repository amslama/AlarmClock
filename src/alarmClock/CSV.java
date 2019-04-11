package alarmClock;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.time.*;


public class CSV {
  
    static List<Alarm> alarmInfoList = new ArrayList<>();
    static int listCounter = 0;

    //Accepts an alarm object
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


    public static void readCSV() {
        String fileName = "AlarmInfo.csv";
        String line = "";
        List<String> lines = new ArrayList<>();
        try{
        	BufferedReader br = new BufferedReader(new FileReader(fileName));
        	
        	
        	/*
        	//creates the scanner
        	Scanner scan = new Scanner(new File(fileName));
        	
        	//Set delimiter
        	scan.useDelimiter(",\\s*");
        	
        	while(scan.hasNextLine()){
        		//List<String> lines = new ArrayList<>();
        		lines.add();
        		
        	}
        	scan.close();
        	System.out.print(lines.get(2));*/
        	

           
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",\\s*");
                // Adds the currently parsed line to 2d arraylist
                alarmInfoList.add(Arrays.asList(values)); 
        	

                // If you want to fetch a certain group of information, use alarmInfoList.get() to fetch the whole group
                // From the 2d array

            

            //output array to console for quick testing
           // System.out.println(alarmInfoList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public static List<Alarm> getList()
    {
    	return alarmInfoList;
    }
    
}
