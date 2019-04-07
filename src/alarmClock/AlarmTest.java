package alarmClock;

import java.time.Clock;

public class AlarmTest {

	public static void main(String[] args) {
		// create a 10 second alarm
		Alarm target = new Alarm(10);
		System.out.println("Alarm created, target time is " + target.toString());
		while(true) {
			//simple test loop
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(target.expired()) {
				System.out.print("The Alarm has gone off, beep... The time is " + Clock.systemDefaultZone().instant().toString());
				return;
			}
		}

	}

}
