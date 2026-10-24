# Week 09 Practice — Quiz and Concept Answers

## Part B — Multiple-choice quiz

1. **C** — Abstraction hides implementation details and exposes what an operation does.
2. **C** — An abstract class cannot be instantiated directly.
3. **B** — A concrete subclass must implement every inherited abstract method, or it must also be abstract.
4. **C** — An abstract method cannot be `private`, because subclasses must be able to implement/override it.
5. **C** — Interface fields are implicitly `public static final` constants.
6. **C** — A class can implement any number of interfaces.
7. **D** — Implementations of interface methods must be `public`.
8. **C** — Interfaces support multiple capabilities without inheriting instance state from multiple classes; this helps avoid class-state diamond ambiguities.
9. **D** — If two inherited default methods conflict, the class must override the method to resolve the conflict.
10. **B** — An abstract-class constructor runs as part of constructing a concrete subclass object.

## Part C — Concept questions

### 1. Explain abstraction with a new real-life example.
A food-delivery app lets a user choose a restaurant, place an order, and track delivery. The user sees these operations and their results, while routing, payment authorization, restaurant dispatch, and driver assignment are hidden behind the app's interface.

### 2. Abstraction vs. encapsulation
Abstraction focuses on showing essential operations while hiding implementation details. Encapsulation bundles data and methods together and restricts direct access to internal state. A `BankAccount` can expose `deposit()` and `withdraw()` as its abstraction while keeping `balance` private and validating changes to preserve encapsulation.

### 3. Why can an abstract class have a constructor?
The constructor initializes shared fields and enforces common setup for subclasses. It executes when a subclass object is created, before the subclass constructor body finishes; the abstract class itself still cannot be instantiated directly.

### 4. Why can't an abstract method be private, static, or final?
A `private` method is not accessible to subclasses for overriding. A `static` method belongs to the class rather than being dynamically dispatched as an instance method. A `final` method cannot be overridden. Each modifier conflicts with the purpose of an abstract method, which requires a concrete implementation in a subclass.

### 5. What is the diamond problem, and how does Java address it?
The diamond problem occurs when a class could inherit the same method or state through two parent classes and the language has no clear rule for which implementation/state should win. Java prevents multiple class inheritance, but allows multiple interfaces. If two interfaces supply conflicting default methods, the implementing class must explicitly override the conflict.
