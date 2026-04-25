/* Author: Goutham Mahesh | Inherits from Transaction, tracks money earned */
public class Income extends Transaction {
    private String source;

    public Income(double amount, String date, String note, String source) {
        super(amount, date, note);
        this.source = source;
    }

    @Override
    public String toFileString() { return "I," + amount + "," + date + "," + note + "," + source; }
    @Override
    public String toString() { return "[INCOME] " + super.toString() + " | Src: " + source; }
}