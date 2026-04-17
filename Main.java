import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccount account = new UserAccount();
        boolean running = true;

        System.out.println("Welcome to the Money Tracker!");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 4) {
                running = false;
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Feature logic coming soon in Week 2!");
            }
        }
        scanner.close();
    }
}