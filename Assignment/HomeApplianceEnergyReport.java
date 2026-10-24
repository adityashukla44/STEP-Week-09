import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private interface SaverMode { }
    private abstract static class Appliance {
        final double hours;
        Appliance(double hours) { this.hours = hours; }
        abstract String type();
        abstract double powerWatts();
        final boolean supportsSaver() { return this instanceof SaverMode; }
        final double units(boolean saver) {
            double kwh = powerWatts() * hours / 1000.0;
            return saver ? kwh * 0.75 : kwh;
        }
    }
    private static class Fridge extends Appliance {
        Fridge(double hours) { super(hours); }
        String type() { return "FRIDGE"; }
        double powerWatts() { return 150.0; }
    }
    private static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) { super(hours); }
        String type() { return "AC"; }
        double powerWatts() { return 1500.0; }
    }
    private static class Tv extends Appliance {
        Tv(double hours) { super(hours); }
        String type() { return "TV"; }
        double powerWatts() { return 100.0; }
    }
    private static class Washer extends Appliance implements SaverMode {
        Washer(double hours) { super(hours); }
        String type() { return "WASHER"; }
        double powerWatts() { return 500.0; }
    }
    private static class Usage {
        final Appliance appliance; final boolean saver;
        Usage(Appliance appliance, boolean saver) { this.appliance = appliance; this.saver = saver; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Usage> usages = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext() && sc.hasNext("(?i)SAVER");
            if (saver) sc.next();
            Appliance appliance = switch (type) {
                case "FRIDGE" -> new Fridge(hours);
                case "AC" -> new AirConditioner(hours);
                case "TV" -> new Tv(hours);
                case "WASHER" -> new Washer(hours);
                default -> throw new IllegalArgumentException("Unknown appliance: " + type);
            };
            usages.add(new Usage(appliance, saver));
        }
        double totalCost = 0;
        for (Usage usage : usages) {
            Appliance appliance = usage.appliance;
            if (usage.saver && !appliance.supportsSaver()) {
                System.out.println(appliance.type() + ": saver mode not supported");
                continue;
            }
            double units = appliance.units(usage.saver);
            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.type(), units, cost);
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
