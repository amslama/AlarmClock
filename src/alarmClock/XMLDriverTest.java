package alarmClock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLDriverTest {
    public static void main(String[] args){
       // XML.generateNextAlarmTab();
        //XML.writeXML("Test Label", 12, 13);
        CSV.createNewCSV( 1231, 15, "Dentist Appointment");
        CSV.readCSV();

       // String datePattern = "MM-dd-yyyy";
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
       // String date = simpleDateFormat.format(new Date());
      //  System.out.println(date);
    }
}
