import java.time.LocalDateTime;
import java.time.Duration;

public class Timer {
    private LocalDateTime start;

    public Timer() {
       start = LocalDateTime.now();
    }

    public void getTime(Stats stats) {
        LocalDateTime stop = LocalDateTime.now();
        Duration dur = Duration.between(start, stop);
        long totalSeconds = dur.getSeconds();
        stats.addSeconds(totalSeconds);
        System.out.println("You guessed in " + timeString(totalSeconds));
    }

    public static String timeString(long totalSeconds) {
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        return minutes + " mins " + seconds + " secs";
    }
}
