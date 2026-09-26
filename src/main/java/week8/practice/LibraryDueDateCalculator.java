package week8.practice;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingPeriod();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() { return 14; }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() { return 7; }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() { return 3; }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        LibraryItem[] items = new LibraryItem[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title);
            }
        }

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (LibraryItem item : items) {
            LocalDate dueDate = currentDate.plusDays(item.getBorrowingPeriod());
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
        sc.close();
    }
}
