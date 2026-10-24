import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WeeklyStaffPay {
    private abstract static class Staff {
        final String name;
        Staff(String name) { this.name = name; }
        abstract double calculatePay();
    }
    private static class FullTime extends Staff {
        final double salary;
        FullTime(String name, double salary) { super(name); this.salary = salary; }
        double calculatePay() { return salary; }
    }
    private static class Hourly extends Staff {
        final double hours, rate;
        Hourly(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        double calculatePay() {
            return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
        }
    }
    private static class Intern extends Staff {
        final double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double calculatePay() { return stipend; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();
            switch (type) {
                case "FULLTIME" -> staff.add(new FullTime(name, sc.nextDouble()));
                case "HOURLY" -> staff.add(new Hourly(name, sc.nextDouble(), sc.nextDouble()));
                case "INTERN" -> staff.add(new Intern(name, sc.nextDouble()));
                default -> throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }
        double total = 0;
        for (Staff person : staff) {
            double pay = person.calculatePay();
            total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", person.name, pay);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
