import java.util.List;
import java.util.ArrayList;

public class Stats {
    private int totalGames = 0;
    private long seconds = 0;
    private List<Integer> wins = new ArrayList<>();
    private List<Integer> attempts = new ArrayList<>();

    public Stats() {
        for (int i = 0; i < 3; i++) {
            wins.add(0);
            attempts.add(0);
        }
    }

    public void win(String mode, int chance){
        switch(mode) {
            case "easy":
                handleUpdate(0, chance);
                break;
            case "medium":
                handleUpdate(1, chance);
                break;
            case "hard":
                handleUpdate(3, chance);
                break;
            default:
                System.out.println("Unexpected mode.");
        }
    }

    private void handleUpdate(int index, int chance) {
        wins.set(index, wins.get(index) + 1);
        if (attempts.get(index)==0 || attempts.get(index) > chance) {
            attempts.set(index, chance);
        }
    }

    public void printStats(){
        double percent = ((wins.get(0)+wins.get(1)+wins.get(2)) * 100.0) / totalGames;
        System.out.print("\n--------------------------------------------------" +
                "\nTotal time played : " + Timer.timeString(seconds) +
                "\nTotal Games Played : " + totalGames +
                "\nTotal Wins : " + (wins.get(0)+wins.get(1)+wins.get(2)));
        System.out.printf("\nWin Rate: %.2f%%", percent);
        System.out.print("\nEasy Mode Wins : " + wins.get(0) + fastAttempt(0) +
                "\nMedium Mode Wins : " + wins.get(1) + fastAttempt(1) +
                "\nHard Mode Wins : " + wins.get(2) + fastAttempt(2) +
                "\n--------------------------------------------------\n");

    }

    private String fastAttempt(int index) {
        if(attempts.get(index) == 0) {
            return "";
        }
        return " Fastest Attempt " + attempts.get(index) + " tries.";
    }

    public void addSeconds(long seconds) {
        this.seconds += seconds;
    }

    public void startGame() {
        totalGames++;
    }
}
