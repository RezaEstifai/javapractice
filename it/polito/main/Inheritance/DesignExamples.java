package it.polito.main.Inheritance;
/*
 TOPICS: inheritance versus composition, composition, Strategy, Observer,
 behavioral parameterization, practical notification example.
*/
import java.util.ArrayList;
import java.util.List;

// Composition: a Computer HAS a Processor. Computer is not a Processor.
class Processor {
    void start() { System.out.println("Processor starts."); }
}
class Computer {
    private Processor processor;
    Computer(Processor processor) { this.processor = processor; }
    void turnOn() {
        processor.start();
        System.out.println("Computer is on.");
    }
}

// Strategy: alternative algorithms share one interface.
interface BonusStrategy { double calculate(double wage); }
class FixedBonus implements BonusStrategy {
    @Override public double calculate(double wage) { return 200; }
}
class PercentageBonus implements BonusStrategy {
    private double rate;
    PercentageBonus(double rate) { this.rate = rate; }
    @Override public double calculate(double wage) { return wage * rate; }
}
class Payroll {
    private BonusStrategy strategy;
    Payroll(BonusStrategy strategy) { this.strategy = strategy; }
    void setStrategy(BonusStrategy strategy) { this.strategy = strategy; }
    double total(double wage) { return wage + strategy.calculate(wage); }
}

// Observer: subject keeps observers and notifies them when an event happens.
interface Observer { void update(String message); }
class EmailObserver implements Observer {
    private String address;
    EmailObserver(String address) { this.address = address; }
    @Override public void update(String message) {
        System.out.println("Email to " + address + ": " + message);
    }
}
class DashboardObserver implements Observer {
    @Override public void update(String message) {
        System.out.println("Dashboard: " + message);
    }
}
class Announcement {
    private List<Observer> observers = new ArrayList<>();
    void addObserver(Observer o) { observers.add(o); }
    void removeObserver(Observer o) { observers.remove(o); }
    void publish(String message) {
        System.out.println("Announcement: " + message);
        for (Observer o : observers) o.update(message);
    }
}

class DesignExamples {
    static void run() {
        Computer computer = new Computer(new Processor());
        computer.turnOn();

        Payroll payroll = new Payroll(new FixedBonus());
        System.out.println("Fixed bonus total: " + payroll.total(3000));
        payroll.setStrategy(new PercentageBonus(0.10));
        System.out.println("10% bonus total: " + payroll.total(3000));

        Announcement news = new Announcement();
        Observer email = new EmailObserver("team@example.com");
        Observer dashboard = new DashboardObserver();
        news.addObserver(email);
        news.addObserver(dashboard);
        news.publish("The office closes at 17:00.");
        news.removeObserver(email);
        news.publish("The meeting starts at 10:00.");
    }
}
