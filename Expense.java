/* Author: Goutham Mahesh | Inherits from Transaction, tracks money spent */
public class Expense extends Transaction {
    private String itemDesc;

    public Expense(double amount, String date, String note, String itemDesc) {
        super(amount, date, note);
        this.itemDesc = itemDesc;
    }

    public String getItemDesc() { return itemDesc; }
    
    @Override
    public String toFileString() { return "E," + amount + "," + date + "," + note + "," + itemDesc; }
    @Override
    public String toString() { return "[EXPENSE] " + super.toString() + " | Item: " + itemDesc; }
}