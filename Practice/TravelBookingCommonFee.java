import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TravelBookingCommonFee {
    private abstract static class Booking {
        private static final double BOOKING_FEE = 50.0;
        final double distanceKm;
        Booking(double distanceKm) { this.distanceKm = distanceKm; }
        abstract String mode();
        abstract double baseFare();
        final double total() { return baseFare() + BOOKING_FEE; }
    }
    private static class Bus extends Booking {
        Bus(double distance) { super(distance); }
        String mode() { return "BUS"; }
        double baseFare() { return distanceKm * 2.0; }
    }
    private static class Train extends Booking {
        Train(double distance) { super(distance); }
        String mode() { return "TRAIN"; }
        double baseFare() { return distanceKm * 1.5; }
    }
    private static class Flight extends Booking {
        Flight(double distance) { super(distance); }
        String mode() { return "FLIGHT"; }
        double baseFare() { return 2500.0 + distanceKm * 4.0; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase(Locale.ROOT);
            double distance = sc.nextDouble();
            switch (mode) {
                case "BUS" -> bookings.add(new Bus(distance));
                case "TRAIN" -> bookings.add(new Train(distance));
                case "FLIGHT" -> bookings.add(new Flight(distance));
                default -> throw new IllegalArgumentException("Unknown mode: " + mode);
            }
        }
        for (Booking booking : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", booking.mode(), booking.total());
        }
    }
}
