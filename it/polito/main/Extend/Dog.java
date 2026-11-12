package it.polito.main.Extend;

public class Dog extends Animal {

    // 1. Attribute belonging only to Dog
    String breed;

    // 2. Constructor
    public Dog(String name, String breed) {

        // Call the parent constructor
        super(name);

        this.breed = breed;
    }

    // 3. Override the parent's method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    // 4. A method belonging only to Dog
    public void wagTail() {
        System.out.println(name + " is wagging its tail.");
    }

    // 5. Another method belonging only to Dog
    public void fetchBall() {
        System.out.println(name + " is fetching the ball.");
    }
}