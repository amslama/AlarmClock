package alarmClock;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.sun.xml.internal.bind.v2.TODO;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

/* Useful resources:
https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilderFactory.html
https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html
https://docs.oracle.com/javase/tutorial/jaxp/dom/readingXML.html
https://docs.oracle.com/javase/tutorial/jaxp/dom/when.html
 */

public class XML {

    public static void generateNextAlarmTab(){
        int alarmNumber = 1;

        try {
            //Build a document factory
            DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = docFac.newDocumentBuilder();

            //Required root elements
            Document doc = docBuild.newDocument();
            Element rootEle = doc.createElement("TestAlarms");
            doc.appendChild(rootEle);

            //NextAlarm elements
            Element nextAlarm = doc.createElement("NextAlarm");
            rootEle.appendChild(nextAlarm);

            //set attribute to alarm element
            nextAlarm.setAttribute("ID",  Integer.toString(alarmNumber));

            //Save to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            //TODO: Set up relative path file
            StreamResult result = new StreamResult(new File("E:\\testfile.xml"));
            transformer.transform(source, result);
            System.out.println("Saved to XML");

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (TransformerException e){
            e.printStackTrace();
        }
    }

    //TODO Could use 24hr time for the time variable so it's simple?
    public static void writeXML(String alarmLabel, int alarmDate, int alarmTime) {
       int currentAlarm =1, alarmNumber = 1;


        try{
            //Build a document factory
            DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = docFac.newDocumentBuilder();

            //Required root elements
            Document doc = docBuild.newDocument();
            Element rootEle = doc.createElement("Alarms");
            doc.appendChild(rootEle);

            //FIXME Stop Label, Date, and Time by overwriting eachother by setting up a new NextAlarm tag

            //NextAlarm elements
            Element nextAlarm = doc.createElement("NextAlarm");
            rootEle.appendChild(nextAlarm);

            //set attribute to alarm element
            nextAlarm.setAttribute("ID",  Integer.toString(alarmNumber));
            
                //Label elements
                Element label = doc.createElement("Label");
                label.appendChild(doc.createTextNode(alarmLabel));
                nextAlarm.appendChild(label);

                //Date elements
                Element date = doc.createElement("Date");
                date.appendChild(doc.createTextNode(Integer.toString(alarmDate)));
                nextAlarm.appendChild(date);

                //Time elements
                Element time = doc.createElement("Time");
                time.appendChild(doc.createTextNode(Integer.toString(alarmTime)));
                nextAlarm.appendChild(time);

                //Save the contents
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("E:\\testfile.xml"));

                // Output to console for testing
                //StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);
                System.out.println("Saved to XML");
                alarmNumber++;
                currentAlarm++;



        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch(TransformerException e){
            e.printStackTrace();

        }
    }

}
