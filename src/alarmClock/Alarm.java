package alarmClock;
import java.time.*;

public class Alarm {
	Instant targetTime;
	LocalDateTime target;
	
	// constructor for an alarm object with a number of hours, minutes and seconds until it goes off.
	public Alarm(long hours, long minutes, long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds((hours * 60 * 60) + (minutes * 60) + (seconds));
		target = LocalDateTime.ofInstant(targetTime, Clock.systemDefaultZone().getZone());
		
		
	}
	// constructor for an alarm object with a number of minutes and seconds until it goes off.
	public Alarm(long minutes, long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds((minutes * 60) + (seconds));
		target = LocalDateTime.ofInstant(targetTime, Clock.systemDefaultZone().getZone());
	}
	// constructor for an alarm object with a number of seconds until it goes off.
	public Alarm(long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds(seconds);
		target = LocalDateTime.ofInstant(targetTime, Clock.systemDefaultZone().getZone());
	}
	// constructor for a LocalDateTime object
	public Alarm(LocalDateTime time) {
		target = time;
	}
	
	public boolean expired() {
		//temp
		return false;
	}
}
