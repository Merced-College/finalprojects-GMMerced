public class Expense extends Transaction {
    private String itemDescription;

    public Expense(double amount, String date, String note, String itemDescription) {
        super(amount, date, note);
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}