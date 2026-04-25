import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* Author: Goutham Mahesh | Interactive Main Menu */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserAccount acc = new UserAccount();
        FileManager.load(acc); // Auto-load

        while (true) {
            System.out.print("\n1.Add Income 2.Add Expense 3.Summary 4.Sort 5.Search 6.Remove 7.Exit\nChoice: ");
            int choice = sc.nextInt(); sc.nextLine();
            
            if (choice == 7) break;

            switch (choice) {
                case 1: case 2:
                    System.out.print("Enter Format -> Amount,Date(MM/DD),Note,Desc (comma separated): ");
                    String[] in = sc.nextLine().split(",");
                    double amt = Double.parseDouble(in[0].trim());
                    if (choice == 1) acc.add(new Income(amt, in[1].trim(), in[2].trim(), in[3].trim()));
                    else acc.add(new Expense(amt, in[1].trim(), in[2].trim(), in[3].trim()));
                    break;
                case 3:
                    HashMap<String, Double> cats = new HashMap<>();
                    double[] stats = acc.calcSummary(cats);
                    System.out.println("Earned: $" + stats[0] + " | Spent: $" + stats[1] + " | Balance: $" + stats[2]);
                    System.out.println("Expenses by Category: " + cats);
                    printList(acc.getList());
                    break;
                case 4:
                    acc.sort(); printList(acc.getList()); 
                    break;
                case 5:
                    System.out.print("Enter Date: ");
                    printList(acc.search(sc.nextLine().trim())); 
                    break;
                case 6:
                    printList(acc.getList()); 
                    System.out.print("Enter index to remove: ");
                    acc.remove(sc.nextInt()); 
                    break;
            }
        }
        FileManager.save(acc); // Auto-save
        System.out.println("Data saved. Goodbye!");
        sc.close();
    }

    private static void printList(ArrayList<Transaction> list) {
        for (int i = 0; i < list.size(); i++) System.out.println(i + ": " + list.get(i));
    }
}