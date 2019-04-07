package alarmClock;
import java.time.*;
public class Alarm {
	Instant targetTime;
	Clock now;
	public Alarm(long hours, long minutes, long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds(hours * 60 * 60);
		targetTime.plusSeconds(minutes * 60);
		targetTime.plusSeconds(seconds);
	}
	public Alarm(long minutes, long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds(minutes * 60);
		targetTime.plusSeconds(seconds);
	}
	public Alarm(long seconds) {
		targetTime = Clock.systemDefaultZone().instant();
		targetTime.plusSeconds(seconds);
	}
}
