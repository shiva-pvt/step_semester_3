package week6.class_problems;

public class MessWallet {
    double balance;

    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Funds added. Current balance: " + balance);
        }
    }

    public void deductFunds(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Funds deducted. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet();
        wallet.addFunds(1000);
        wallet.deductFunds(250);
        wallet.deductFunds(800);
    }
}
