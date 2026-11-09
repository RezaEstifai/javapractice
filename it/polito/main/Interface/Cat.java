package it.polito.main.Interface;


/**
 * ============================================================================
 * CLASS: Cat
 * ============================================================================
 *
 * Cat implements Animal.
 *
 * This means Cat must provide all methods
 * declared inside the Animal interface.
 *
 * Cat has its own implementation of makeSound().
 * ============================================================================
 */

public class Cat implements Animal {

    // Private variable: each Cat object has its own name.
    private String name;


    // CONSTRUCTOR
    // Called when we create a Cat object using:
    // Cat cat1 = new Cat("Luna");
    public Cat(String name) {
        this.name = name;
    }


    // IMPLEMENTATION OF makeSound()
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }


    // IMPLEMENTATION OF getName()
    @Override
    public String getName() {
        return this.name;
    }

}