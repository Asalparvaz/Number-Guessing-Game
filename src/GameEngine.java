import java.util.Random;

public class GameEngine {

    private Stats stats = new Stats();
    private String mode;
    private int usedHint = 0;

    public void startGame() {
        do{
            runGame();
        }while(playAgain());
    }

    private int getChances() {
        System.out.print("\nEnter Here: ");
        while(true) {
            int choice = ScannerWrapper.getInt();
            switch(choice) {
                case 1:
                    Messages.printLevel("Easy");
                    mode = "easy";
                    return 10;
                case 2:
                    Messages.printLevel("Medium");
                    mode = "medium";
                    return 5;
                case 3:
                    Messages.printLevel("Hard");
                    mode = "hard";
                    return 3;
                default:
                    System.out.print("Invalid choice. Try again: ");
            }
        }
    }

    private int generateNum() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    private void runTurns(int chances, int number) {
        Timer timer = new Timer();
        for(int i = 0; i < chances; i++) {
            System.out.print("\nEnter your guess: ");
            int guess = ScannerWrapper.getInt();
            if (guess == -1){
                hint(number);
                i--;
                continue;
            }
            if (handleGuess(guess, number, i+1)) {
                timer.getTime(stats);
                return;
            }
        }
        Messages.noChances(number);
    }

    private Boolean handleGuess(int guess, int number, int chance) {
        if (guess == number) {
            Messages.printCorrect(chance);
            stats.win(mode, chance);
            return true;
        } else {
            if (guess > number) {
                Messages.printWrong(guess, "less");
            } else {
                Messages.printWrong(guess, "greater");
            }
            return false;
        }
    }

    private void runGame() {
        Messages.printWelcome();
        int chances = getChances();
        int number = generateNum();
        stats.startGame();
        usedHint = 0;
        runTurns(chances, number);
        stats.printStats();
    }

    private boolean playAgain(){
        System.out.print("\nDo you want to play again?(yes/no) ");
        while(true){
            String choice = ScannerWrapper.getString();
            if ("yes".equalsIgnoreCase(choice)) {
                return true;
            } else if ("no".equalsIgnoreCase(choice)) {
                return false;
            } else {
                System.out.print("Invalid choice. Try again : ");
            }
        }
    }

    private void hint(int number) {
        if (usedHint == 0){
            String type = "even";
            if (number % 2 != 0) {
                type = "odd";
            }
            usedHint++;
            System.out.println("HINT : the number is " + type);
        } else if (usedHint == 1) {
            int num = (number / 10)*10;
            System.out.println("HINT : the number is between " + num + " and " + (num+10));
            usedHint++;
        } else {
            System.out.println("You're out of hints.");
        }
    }
}
