import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {
    private abstract static class Seat {
        private static final double CONVENIENCE_FEE = 20.0;
        abstract String type();
        abstract double price();
        final double bookingAmount(int count) { return count * (price() + CONVENIENCE_FEE); }
    }
    private static class Regular extends Seat {
        String type() { return "REGULAR"; }
        double price() { return 150.0; }
    }
    private static class Premium extends Seat {
        String type() { return "PREMIUM"; }
        double price() { return 250.0; }
    }
    private static class Recliner extends Seat {
        String type() { return "RECLINER"; }
        double price() { return 400.0; }
    }
    private static class Booking {
        final Seat seat; final int count;
        Booking(Seat seat, int count) { this.seat = seat; this.count = count; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int count = sc.nextInt();
            Seat seat = switch (type) {
                case "REGULAR" -> new Regular();
                case "PREMIUM" -> new Premium();
                case "RECLINER" -> new Recliner();
                default -> throw new IllegalArgumentException("Unknown seat type: " + type);
            };
            bookings.add(new Booking(seat, count));
        }
        double total = 0;
        for (Booking booking : bookings) {
            double amount = booking.seat.bookingAmount(booking.count);
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", booking.seat.type(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
