public class Income extends Transaction {
    private String source;

    public Income(double amount, String date, String note, String source) {
        super(amount, date, note);
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}