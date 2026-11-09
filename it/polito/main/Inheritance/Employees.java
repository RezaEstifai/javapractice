package it.polito.main.Inheritance;
/*
 TOPICS IN THIS FILE:
 Inheritance, addition, overriding, reuse, inheritance tree, parent/child terminology,
 polymorphism, static type checking, dynamic binding, LSP, duck-typing comparison,
 override rules, visibility, constructors and their order, this(), super(), final,
 field hiding ("masked" fields), static method hiding, upcasting, downcasting,
 instanceof, pattern matching, primitive casting.
*/
class Employee {
    String name;                 // package-private: accessible in this package
    double wage;
    protected String employeeCode;
    private int internalId = 100; // only Employee can directly access this field

    Employee(String name, double wage) {
        this.name = name;
        this.wage = wage;
        System.out.println("Employee constructor");
    }

    void incrementWage() { wage += 100; }

    public void print() {
        System.out.println("Employee: " + name + ", wage: " + wage);
    }

    public int getInternalId() { return internalId; }

    public String role() { return "Employee"; }

    public final void companyRule() {
        System.out.println("Follow company rules.");
    }

    public static void companyName() {
        System.out.println("Example Ltd.");
    }
}

class Manager extends Employee {
    String managedUnit;
    String name = "Manager's hidden name field"; // hides Employee.name

    Manager(String name, double wage, String unit) {
        super(name, wage); // calls Employee constructor; must be first
        this.managedUnit = unit;
        System.out.println("Manager constructor");
    }

    void changeUnit(String unit) { managedUnit = unit; }

    @Override
    public void print() {
        System.out.println("Manager: " + super.name + ", manages " + managedUnit);
    }

    void printParentVersion() { super.print(); }

    @Override
    public String role() { return "Manager"; }

    // This hides the parent's static method; static methods are not overridden.
    public static void companyName() {
        System.out.println("Manager's static companyName()");
    }
}

class Developer extends Employee {
    String language;
    Developer(String name, double wage, String language) {
        super(name, wage);
        this.language = language;
    }
    @Override public void print() {
        System.out.println("Developer: " + name + ", language: " + language);
    }
    @Override public String role() { return "Developer"; }
    void writeCode() { System.out.println(name + " writes " + language + " code."); }
}

class Accountant extends Employee {
    Accountant(String name, double wage) { super(name, wage); }
    @Override public void print() { System.out.println("Accountant: " + name); }
    @Override public String role() { return "Accountant"; }
    void calculateSalary() { System.out.println(name + " calculates salary."); }
}

class ManagerWithTwoConstructors extends Employee {
    ManagerWithTwoConstructors(String name) {
        this(name, 2500); // this(...) calls another constructor in this class
    }
    ManagerWithTwoConstructors(String name, double wage) {
        super(name, wage);
    }
}

class EmployeeExamples {
    static void basic() {
        // DECLARATION + CREATION: type Employee, variable e, new creates object.
        Employee e = new Employee("David", 2500);
        e.incrementWage(); // CALL inherited/own method through object reference
        e.print();

        Manager m = new Manager("John", 3000, "Finance");
        m.incrementWage();       // inherited from Employee
        m.changeUnit("IT");      // Manager's own method
        m.print();               // Manager's overridden method
        m.printParentVersion();  // explicitly calls Employee.print() using super
        m.companyRule();         // inherited final method
        System.out.println("Private ID through getter: " + m.getInternalId());

        Developer d = new Developer("Alex", 2800, "Java");
        d.incrementWage();
        d.writeCode();
        d.print();

        Accountant a = new Accountant("Sarah", 2700);
        a.incrementWage();
        a.calculateSalary();
        a.print();
        // Reuse: incrementWage() is written once in Employee, reused by children.
    }

    static void polymorphism() {
        // Reference type is Employee; actual objects are Manager/Developer/Accountant.
        Employee e1 = new Manager("John", 3000, "IT");
        Employee e2 = new Developer("David", 2800, "Java");
        Employee e3 = new Accountant("Sarah", 2700);

        e1.print(); // allowed: print() is declared in Employee
        e2.print(); // dynamic binding runs Developer.print()
        e3.print(); // dynamic binding runs Accountant.print()

        // e1.changeUnit("Sales"); // COMPILE ERROR: not declared in Employee.
        // Child-only methods exist in the actual object, but aren't directly
        // accessible through an Employee-typed reference.
        Employee[] team = {e1, e2, e3};
        for (Employee person : team) person.print();

        // LSP idea: child objects can be used where Employee is expected.
        // Java uses declared types/inheritance/interfaces, unlike general duck typing.
    }

    static void constructorsAndCasting() {
        Manager m = new Manager("Nora", 4000, "Operations");
        System.out.println("Manager.name field: " + m.name);
        System.out.println("Employee.name field: " + ((Employee)m).name);
        m.printParentVersion();

        Employee.companyName();
        Manager.companyName();

        ManagerWithTwoConstructors small = new ManagerWithTwoConstructors("Omar");
        small.print();

        // UPCASTING: child object -> parent reference; automatic and safe.
        Employee person = new Manager("Lina", 3500, "IT");
        person.print(); // actual object is Manager, so Manager.print() runs.

        // DOWNCASTING: parent reference -> child reference; check first.
        if (person instanceof Manager) {
            Manager manager = (Manager) person;
            manager.changeUnit("Research");
            manager.print();
        }

        // Pattern matching for instanceof (Java 16+):
        if (person instanceof Manager manager) {
            manager.changeUnit("Technology");
            manager.print();
        }

        Employee ordinary = new Employee("Paul", 2400);
        // Manager wrong = (Manager) ordinary; // compiles, but throws ClassCastException.

        double decimal = 19.95;
        int whole = (int) decimal; // primitive narrowing: drops decimal part
        int smallNumber = 12;
        double wideNumber = smallNumber; // primitive widening: automatic
        System.out.println(whole + " / " + wideNumber);
    }
}
