public class Transaction {
    protected double amount;
    protected String date;
    protected String note;

    public Transaction(double amount, String date, String note) {
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }
}