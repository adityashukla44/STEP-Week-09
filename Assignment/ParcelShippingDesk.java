import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {
    private interface Insurable {
        double insurance(double declaredValue);
    }
    private abstract static class Parcel {
        final double weightKg, declaredValue;
        Parcel(double weightKg, double declaredValue) { this.weightKg = weightKg; this.declaredValue = declaredValue; }
        abstract String type();
        abstract double shippingCharge();
        double insurance() { return this instanceof Insurable insurable ? insurable.insurance(declaredValue) : 0.0; }
        final double total() { return shippingCharge() + insurance(); }
    }
    private static class Standard extends Parcel {
        Standard(double w, double v) { super(w, v); }
        String type() { return "STANDARD"; }
        double shippingCharge() { return 40.0 + 10.0 * weightKg; }
    }
    private static class Express extends Parcel implements Insurable {
        Express(double w, double v) { super(w, v); }
        String type() { return "EXPRESS"; }
        double shippingCharge() { return 80.0 + 15.0 * weightKg; }
        public double insurance(double value) { return value * 0.02; }
    }
    private static class Fragile extends Parcel implements Insurable {
        Fragile(double w, double v) { super(w, v); }
        String type() { return "FRAGILE"; }
        double shippingCharge() { return 40.0 + 10.0 * weightKg + 50.0; }
        public double insurance(double value) { return value * 0.02; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double weight = sc.nextDouble(), value = sc.nextDouble();
            switch (type) {
                case "STANDARD" -> parcels.add(new Standard(weight, value));
                case "EXPRESS" -> parcels.add(new Express(weight, value));
                case "FRAGILE" -> parcels.add(new Fragile(weight, value));
                default -> throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
        }
        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.shippingCharge(), insurance = parcel.insurance(), total = parcel.total();
            grandTotal += total;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
