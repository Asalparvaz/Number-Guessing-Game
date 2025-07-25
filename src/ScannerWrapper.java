import java.util.Scanner;

public class ScannerWrapper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.nextLine();
    }

    public static int getInt() {
        while(!scanner.hasNextInt()) {
            System.out.print("Must be of type: int\n");
            scanner.next();
        }
        int output = scanner.nextInt();
        scanner.nextLine();
        return output;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
