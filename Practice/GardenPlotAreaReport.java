import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GardenPlotAreaReport {
    private abstract static class Plot {
        final String owner;
        Plot(String owner) { this.owner = owner; }
        abstract String shape();
        abstract double area();
    }
    private static class Circle extends Plot {
        final double radius;
        Circle(String owner, double radius) { super(owner); this.radius = radius; }
        String shape() { return "CIRCLE"; }
        double area() { return Math.PI * radius * radius; }
    }
    private static class Rectangle extends Plot {
        final double length, width;
        Rectangle(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
        String shape() { return "RECTANGLE"; }
        double area() { return length * width; }
    }
    private static class Triangle extends Plot {
        final double base, height;
        Triangle(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
        String shape() { return "TRIANGLE"; }
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0].toUpperCase(Locale.ROOT);
            String owner = parts[1];
            switch (shape) {
                case "CIRCLE" -> plots.add(new Circle(owner, Double.parseDouble(parts[2])));
                case "RECTANGLE" -> plots.add(new Rectangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                case "TRIANGLE" -> plots.add(new Triangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                default -> throw new IllegalArgumentException("Unknown plot shape: " + shape);
            }
        }
        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            total += area;
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.owner, plot.shape(), area);
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
