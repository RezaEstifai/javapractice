package it.polito.main.Interface;


/**
 * ============================================================================
 * INTERFACE: Animal
 * ============================================================================
 *
 * An interface is a CONTRACT.
 *
 * Any class that implements Animal MUST provide
 * the methods declared inside this interface.
 *
 * We define WHAT an animal can do, not HOW it does it.
 *
 * For example:
 * - A Dog makes a Woof sound.
 * - A Cat makes a Meow sound.
 *
 * Each class provides its own implementation.
 * ============================================================================
 */

public interface Animal {

    // Every Animal must have a makeSound() method.
    void makeSound();

    // Every Animal must have a getName() method.
    String getName();

}