import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LibraryLateFineCounter {
    private abstract static class LibraryItem {
        final String title;
        final int daysLate;
        LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        abstract double fine();
    }
    private static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate * 2.0; }
    }
    private static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) { super(title, daysLate); }
        double fine() { return Math.min(daysLate * 5.0, 50.0); }
    }
    private static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String title = sc.next();
            int daysLate = sc.nextInt();
            switch (type) {
                case "BOOK" -> items.add(new Book(title, daysLate));
                case "DVD" -> items.add(new Dvd(title, daysLate));
                case "MAGAZINE" -> items.add(new Magazine(title, daysLate));
                default -> throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            total += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
