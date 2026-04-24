import java.util.ArrayList;

public class UserAccount {
    private double totalBalance;
    private ArrayList<Transaction> transactions;

    public UserAccount() {
        this.totalBalance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);

        double amount = t.getAmount();
        if (t instanceof Expense) {
            totalBalance -= amount;
        } else {
            totalBalance += amount;
        }
        
    }

    public double getTotalBalance() {
        return totalBalance;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}