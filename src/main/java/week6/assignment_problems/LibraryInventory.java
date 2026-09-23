package week6.assignment_problems;

public class LibraryInventory {
    private String bookTitle;
    private String author;
    private int quantity;
    private double price;

    public LibraryInventory(String bookTitle, String author, int quantity, double price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayBookDetails() {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }

    public void addStock(int amount) {
        quantity += amount;
        System.out.println("Stock added successfully.");
    }

    public void sellBook(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            System.out.println("Book sold successfully.");
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }
}
