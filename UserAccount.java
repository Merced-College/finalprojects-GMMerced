import java.util.ArrayList;
import java.util.HashMap;

/* 
Author: Goutham Mahesh | Manages transactions and balance.
Data Structures: ArrayList (transactions list), HashMap (categories), double[] (stats). 
*/
public class UserAccount {
    private double balance = 0.0;
    private ArrayList<Transaction> list = new ArrayList<>();

    public void add(Transaction t) {
        list.add(t);
        balance += (t instanceof Expense) ? -t.getAmount() : t.getAmount();
    }

    public void remove(int index) {
        if (index >= 0 && index < list.size()) {
            Transaction t = list.remove(index);
            balance += (t instanceof Expense) ? t.getAmount() : -t.getAmount();
        }
    }

    public ArrayList<Transaction> getList() { return list; }

    /* Alg 1: Summary Calculation (O(n)) - Loops to aggregate totals and categorize expenses */
    public double[] calcSummary(HashMap<String, Double> map) {
        double earned = 0, spent = 0;
        for (Transaction t : list) {
            if (t instanceof Income) earned += t.getAmount();
            else {
                spent += t.getAmount();
                String cat = ((Expense) t).getItemDesc();
                map.put(cat, map.getOrDefault(cat, 0.0) + t.getAmount()); // HashMap Usage
            }
        }
        return new double[]{earned, spent, balance}; // Array Usage
    }

    /* Alg 2: Selection Sort (O(n^2)) - Sorts transactions highest to lowest amount */
    public void sort() {
        for (int i = 0; i < list.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getAmount() > list.get(max).getAmount()) max = j;
            }
            Transaction temp = list.get(max);
            list.set(max, list.get(i));
            list.set(i, temp);
        }
    }

    /* Alg 3: Linear Search (O(n)) - Finds and returns transactions matching a specific date */
    public ArrayList<Transaction> search(String date) {
        ArrayList<Transaction> res = new ArrayList<>();
        for (Transaction t : list) {
            if (t.getDate().equals(date)) res.add(t);
        }
        return res;
    }
}