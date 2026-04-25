/* Author: Goutham Mahesh | Base class for money exchanges */
public class Transaction {
    protected double amount;
    protected String date;
    protected String note;

    public Transaction(double amount, String date, String note) {
        this.amount = amount; this.date = date; this.note = note;
    }
    
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    
    public String toFileString() { return "T," + amount + "," + date + "," + note; }
    public String toString() { return "Date: " + date + " | $" + amount + " | Note: " + note; }
}