public class Messages {

    public static void printWelcome() {
        System.out.println("""
                
                --------------------------------------------------
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100.
                You have a few chances to guess the correct number.
                You can have a hint TWICE in every game by entering "-1" as a guess.
                
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)""");
    }

    public static void printLevel(String level) {
        System.out.println("You have selected the " + level + " difficulty level." +
                "\nLet's start the game!");

    }

    public static void printCorrect(int chances) {
        System.out.println("Congratulations! You guessed the correct number in " + chances + " attempts.");
    }

    public static void printWrong(int number, String status) {
        System.out.println("Incorrect! The number is " + status + " than " + number + ".");
    }

    public static void noChances(int number) {
        System.out.println("You are out of chances. The number was : " + number);
    }
}
