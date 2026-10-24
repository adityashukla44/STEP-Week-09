import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {
    private interface NightService { }
    private abstract static class Cab {
        private static final double MINIMUM_FARE = 100.0;
        final double km;
        Cab(double km) { this.km = km; }
        abstract String type();
        abstract double ratePerKm();
        final boolean supportsNightService() { return this instanceof NightService; }
        final double dayFare() { return Math.max(MINIMUM_FARE, km * ratePerKm()); }
        final double fare(String time) { return dayFare() * (time.equals("NIGHT") ? 1.2 : 1.0); }
    }
    private static class Mini extends Cab {
        Mini(double km) { super(km); }
        String type() { return "MINI"; }
        double ratePerKm() { return 10.0; }
    }
    private static class Sedan extends Cab implements NightService {
        Sedan(double km) { super(km); }
        String type() { return "SEDAN"; }
        double ratePerKm() { return 14.0; }
    }
    private static class Suv extends Cab implements NightService {
        Suv(double km) { super(km); }
        String type() { return "SUV"; }
        double ratePerKm() { return 18.0; }
    }
    private static class Trip {
        final Cab cab; final String time;
        Trip(Cab cab, String time) { this.cab = cab; this.time = time; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase(Locale.ROOT);
            Cab cab = switch (type) {
                case "MINI" -> new Mini(km);
                case "SEDAN" -> new Sedan(km);
                case "SUV" -> new Suv(km);
                default -> throw new IllegalArgumentException("Unknown cab type: " + type);
            };
            trips.add(new Trip(cab, time));
        }
        double total = 0;
        for (Trip trip : trips) {
            Cab cab = trip.cab;
            if (trip.time.equals("NIGHT") && !cab.supportsNightService()) {
                System.out.println(cab.type() + ": night service not available");
                continue;
            }
            double fare = cab.fare(trip.time);
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", cab.type(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
