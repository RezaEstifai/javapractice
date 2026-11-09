package it.polito.main.Inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        System.out.println("\n--- INHERITANCE / ADDITION / OVERRIDE / REUSE ---");
        EmployeeExamples.basic();
        System.out.println("\n--- POLYMORPHISM / DYNAMIC BINDING ---");
        EmployeeExamples.polymorphism();
        System.out.println("\n--- CONSTRUCTORS / SUPER / CASTING ---");
        EmployeeExamples.constructorsAndCasting();
        System.out.println("\n--- OBJECT METHODS ---");
        ObjectExamples.run();
        System.out.println("\n--- ABSTRACT CLASS / TEMPLATE METHOD / COMPOSITE ---");
        ShapeExamples.run();
        System.out.println("\n--- INTERFACES / ITERATORS / LAMBDAS ---");
        InterfaceExamples.run();
        System.out.println("\n--- COMPOSITION / STRATEGY / OBSERVER ---");
        DesignExamples.run();
        System.out.println("\n--- VARARGS / SORTING ---");
        UtilityExamples.run();
    }
}
