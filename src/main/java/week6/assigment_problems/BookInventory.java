package week6.assigment_problems;

public class BookInventory {
    int stockCount;

    public void addStock(int count) {
        if (count > 0) {
            stockCount += count;
            System.out.println("Stock added. Current count: " + stockCount);
        }
    }

    public void sellBook(int count) {
        if (count > 0 && stockCount >= count) {
            stockCount -= count;
            System.out.println("Books sold. Current count: " + stockCount);
        } else {
            System.out.println("Insufficient stock to sell.");
        }
    }

    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();
        inventory.addStock(50);
        inventory.sellBook(20);
        inventory.sellBook(40);
    }
}
