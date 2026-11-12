package it.polito.main.Extend;

public class Animal { //* Parent */

    // 1. Attribute
    String name;

    // 2. Constructor
    public Animal() {
        this.name = "Unknown Animal";
    }

    public Animal(String name) {
        this.name = name;
    }

    // 3. A normal method belonging to Animal
    public void eat() {
        System.out.println(name + " is eating.");
    }

    // 4. A method that Dog will override
    public void makeSound() {
        System.out.println("Animal makes a generic sound.");
    }

    // 5. A method that only exists in Animal
    public void breathe() {
        System.out.println(name + " is breathing.");
    }
}