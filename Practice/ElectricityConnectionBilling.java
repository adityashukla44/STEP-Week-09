import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ElectricityConnectionBilling {
    private abstract static class Connection {
        final int units;
        Connection(int units) { this.units = units; }
        abstract String type();
        abstract double bill();
    }
    private static class Home extends Connection {
        Home(int units) { super(units); }
        String type() { return "HOME"; }
        double bill() { return Math.min(units, 100) * 5.0 + Math.max(0, units - 100) * 7.0; }
    }
    private static class Shop extends Connection {
        Shop(int units) { super(units); }
        String type() { return "SHOP"; }
        double bill() { return units * 8.0 + 100.0; }
    }
    private static class Factory extends Connection {
        Factory(int units) { super(units); }
        String type() { return "FACTORY"; }
        double bill() { return Math.max(units * 6.0, 1000.0); }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int units = sc.nextInt();
            switch (type) {
                case "HOME" -> connections.add(new Home(units));
                case "SHOP" -> connections.add(new Shop(units));
                case "FACTORY" -> connections.add(new Factory(units));
                default -> throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }
        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.bill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", connection.type(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
