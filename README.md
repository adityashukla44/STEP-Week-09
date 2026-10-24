# STEP Week 09: Abstraction and Interfaces

My solutions to the Week 9 practice problems and coding assignment of the **STEP Java Programming** track.

## Topics covered

- Abstract classes and abstract methods
- Shared behaviour in a base class
- Polymorphic processing of mixed objects
- Interfaces as capabilities

## Practice

| Program | What it does | Input |
|---------|--------------|-------|
| [`ElectricityConnectionBilling`](Practice/ElectricityConnectionBilling.java) | Bills home, shop and factory electricity connections | Interactive |
| [`GardenPlotAreaReport`](Practice/GardenPlotAreaReport.java) | Reports the areas of circular, rectangular and triangular plots | Interactive |
| [`LibraryLateFineCounter`](Practice/LibraryLateFineCounter.java) | Calculates late fines for books, DVDs and magazines | Interactive |
| [`TravelBookingCommonFee`](Practice/TravelBookingCommonFee.java) | Prices bus, train and flight bookings with a shared booking fee | Interactive |
| [`WeeklyStaffPay`](Practice/WeeklyStaffPay.java) | Calculates weekly pay for full-time, hourly and intern staff | Interactive |

Also included: [`QuizAndConceptAnswers.md`](Practice/QuizAndConceptAnswers.md) (answers to the quiz and concept questions).

## Assignment

| Program | What it does | Input |
|---------|--------------|-------|
| [`CityCabFareMeter`](Assignment/CityCabFareMeter.java) | Calculates mini, sedan and SUV fares, with night service as an interface | Interactive |
| [`CollegeFeeCounter`](Assignment/CollegeFeeCounter.java) | Calculates fees for day scholars, hostellers and scholarship students | Interactive |
| [`HomeApplianceEnergyReport`](Assignment/HomeApplianceEnergyReport.java) | Reports energy use per appliance, with saver mode as an interface | Interactive |
| [`MovieTicketCounter`](Assignment/MovieTicketCounter.java) | Prices regular, premium and recliner seats | Interactive |
| [`ParcelShippingDesk`](Assignment/ParcelShippingDesk.java) | Prices standard, express and fragile parcels, with insurance as an interface | Interactive |

## Project structure

```
.
├── Practice/
│   ├── ElectricityConnectionBilling.java
│   ├── GardenPlotAreaReport.java
│   ├── LibraryLateFineCounter.java
│   ├── TravelBookingCommonFee.java
│   ├── WeeklyStaffPay.java
│   ├── QuizAndConceptAnswers.md
│   └── README.md
├── Assignment/
│   ├── CityCabFareMeter.java
│   ├── CollegeFeeCounter.java
│   ├── HomeApplianceEnergyReport.java
│   ├── MovieTicketCounter.java
│   ├── ParcelShippingDesk.java
│   └── README.md
└── README.md
```

## How to run

You need JDK 17 or later.

```bash
cd Practice      # or: cd Assignment
javac FileName.java
java FileName
```

Replace `FileName` with the program name. Programs marked **Interactive** read input from the terminal; the rest run a built-in example straight away. Each file is self-contained, so you can also open it in VS Code or IntelliJ and press **Run**.

## All STEP weeks

| Week | Topic |
|------|-------|
| [Week 1](https://github.com/adityashukla44/STEP-Week-01) | Java Basics: Strings, Loops and Arrays |
| [Week 2](https://github.com/adityashukla44/STEP-Week-02) | String Processing and Validation |
| [Week 3](https://github.com/adityashukla44/STEP-Week-03) | Classes, Objects and Constructors |
| [Week 4](https://github.com/adityashukla44/STEP-Week-04) | Array Algorithms |
| [Week 5](https://github.com/adityashukla44/STEP-Week-05) | Arrays and Methods |
| [Week 6](https://github.com/adityashukla44/STEP-Week-06) | Object-Oriented Programming Revision |
| [Week 7](https://github.com/adityashukla44/STEP-Week-07) | Encapsulation |
| [Week 8](https://github.com/adityashukla44/STEP-Week-08) | Inheritance and Polymorphism |
| **Week 9** | **Abstraction and Interfaces** (this repo) |
| [Week 10](https://github.com/adityashukla44/STEP-Week-10) | Coding Practice Set |

## Author

**Aditya Shukla** · [@adityashukla44](https://github.com/adityashukla44)
