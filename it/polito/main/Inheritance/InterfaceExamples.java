package it.polito.main.Inheritance;
/*
 TOPICS: interfaces, multiple interfaces, interface references, Comparable,
 Iterable, Iterator, Comparator, behavioral parameterization, lambdas,
 method references, marker/flag interface Cloneable.
*/
import java.util.*;

interface Printable { void print(); }
interface Payable { double calculatePayment(); }

class Consultant extends Employee
        implements Printable, Payable, Comparable<Consultant> {
    private double hourlyRate;
    private int hours;

    Consultant(String name, double rate, int hours) {
        super(name, 0);
        this.hourlyRate = rate;
        this.hours = hours;
    }

    @Override public void print() { System.out.println("Consultant: " + name); }
    @Override public double calculatePayment() { return hourlyRate * hours; }

    // Comparable defines the natural order here: alphabetical by name.
    @Override public int compareTo(Consultant other) {
        return this.name.compareTo(other.name);
    }
}

class Team implements Iterable<Employee> {
    private List<Employee> people = new ArrayList<>();
    void add(Employee e) { people.add(e); }
    @Override public Iterator<Employee> iterator() {
        return people.iterator();
    }
}

class SimpleDocument implements Cloneable {
    String title;
    SimpleDocument(String title) { this.title = title; }
    @Override public String toString() { return "Document: " + title; }
}

class InterfaceExamples {
    static void run() {
        Printable p = new Consultant("Maya", 40, 10);
        p.print(); // interface reference can call methods declared by Printable

        Payable payment = new Consultant("Noah", 50, 8);
        System.out.println("Payment: " + payment.calculatePayment());

        Consultant first = new Consultant("Zoe", 40, 10);
        Consultant second = new Consultant("Adam", 50, 8);
        System.out.println("Natural comparison: " + first.compareTo(second));

        Team team = new Team();
        team.add(new Manager("John", 3000, "IT"));
        team.add(new Developer("David", 2800, "Java"));
        team.add(new Accountant("Sarah", 2700));

        // Explicit Iterator calls: hasNext() checks; next() gets next item.
        Iterator<Employee> it = team.iterator();
        while (it.hasNext()) {
            Employee current = it.next();
            current.print();
        }

        // Enhanced for-loop works because Team implements Iterable.
        for (Employee current : team) {
            System.out.println("Role: " + current.role());
        }

        List<Consultant> consultants = new ArrayList<>();
        consultants.add(new Consultant("Zoe", 40, 10));
        consultants.add(new Consultant("Adam", 50, 8));
        consultants.add(new Consultant("Maya", 45, 9));

        // Comparator supplies an ordering from outside the Consultant class.
        // Lambda: (a, b) -> ... is an implementation of Comparator's method.
        consultants.sort((a, b) ->
            Double.compare(a.calculatePayment(), b.calculatePayment()));

        // Method reference: shorter form of a lambda that calls println.
        consultants.forEach(System.out::println);

        // Cloneable is a marker interface: it has no methods.
        System.out.println(new SimpleDocument("Study notes"));
    }
}
