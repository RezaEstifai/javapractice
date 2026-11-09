package it.polito.main.Interface;


/**
 * ============================================================================
 * CLASS: Dog
 * ============================================================================
 *
 * Dog implements Animal.
 *
 * This means Dog promises to provide all methods
 * declared inside the Animal interface.
 *
 * Dog must implement:
 * 1. makeSound()
 * 2. getName()
 * ============================================================================
 */

public class Dog implements Animal {

    // Private variable: each Dog object has its own name.
    private String name;


    // CONSTRUCTOR
    // Called when we create a Dog object using:
    // Dog dog1 = new Dog("Max");
    public Dog(String name) {
        this.name = name;
    }


    // IMPLEMENTATION OF makeSound()
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }


    // IMPLEMENTATION OF getName()
    @Override
    public String getName() {
        return this.name;
    }

}