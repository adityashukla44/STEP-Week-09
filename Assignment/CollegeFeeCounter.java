import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {
    private abstract static class Student {
        private static final double BUS_FEE = 12000.0;
        final String name;
        Student(String name) { this.name = name; }
        abstract double tuition();
        abstract boolean usesBus();
        double totalFee() { return tuition() + (usesBus() ? BUS_FEE : 0.0); }
    }
    private static class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000.0; }
        boolean usesBus() { return true; }
    }
    private static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 100000.0; }
        boolean usesBus() { return false; }
    }
    private static class Scholar extends Student {
        Scholar(String name) { super(name); }
        double tuition() { return 20000.0; }
        boolean usesBus() { return true; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();
            switch (type) {
                case "DAY_SCHOLAR" -> students.add(new DayScholar(name));
                case "HOSTELLER" -> students.add(new Hosteller(name));
                case "SCHOLAR" -> students.add(new Scholar(name));
                default -> throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }
        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
