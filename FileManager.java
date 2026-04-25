import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/* Author: Goutham Mahesh | Compactly handles saving/loading data */
public class FileManager {
    private static final String FILE = "userdata.txt";

    public static void save(UserAccount acc) {
        try (PrintWriter w = new PrintWriter(new FileWriter(FILE))) {
            for (Transaction t : acc.getList()) w.println(t.toFileString());
        } catch (Exception e) { System.out.println("Save error."); }
    }

    public static void load(UserAccount acc) {
        try (Scanner s = new Scanner(new File(FILE))) {
            while (s.hasNextLine()) {
                String[] p = s.nextLine().split(",");
                if (p.length < 5) continue;
                double amt = Double.parseDouble(p[1]);
                if (p[0].equals("I")) acc.add(new Income(amt, p[2], p[3], p[4]));
                else if (p[0].equals("E")) acc.add(new Expense(amt, p[2], p[3], p[4]));
            }
        } catch (Exception e) { /* Fails silently if no save file exists yet */ }
    }
}