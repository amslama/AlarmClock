package alarmClock;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.*;


public class CSV {

    static List<List<String>> alarmInfoList = new ArrayList<>();


    //TODO Alarm Time is 24 hr time for simplicity, date format is  MM-DD
    public static void writeCSV( String alarmDate, String alarmTime, String alarmMessage) {
        String fileName = "AlarmInfo.csv";
        PrintWriter writer = null;

        try{
            writer = new PrintWriter(fileName);

            //Writing the argument inputs
            writer.print(alarmDate + "," + alarmTime + "," + alarmMessage);
            writer.println();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            writer.close();
        }

    }


    public static void readCSV() {
        String fileName = "AlarmInfo.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            //Skips header line
            //reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",\\s*");
                // Adds the currently parsed line to 2d arraylist
                alarmInfoList.add(Arrays.asList(values));

                // If you want to fetch a certain group of information, use alarmInfoList.get() to fetch the whole group
                // From the 2d array

            }

            //output array to console for quick testing
            System.out.println(alarmInfoList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
