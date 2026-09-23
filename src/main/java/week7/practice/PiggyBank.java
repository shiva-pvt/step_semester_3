package week7.practice;

public class PiggyBank {
    private int savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount >= 0) {
            savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount < 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}
