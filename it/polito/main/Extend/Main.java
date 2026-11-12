package it.polito.main.Extend;

public class Main {

    public static void main(String[] args) {


        // ==========================================
        // PART 1: NORMAL ANIMAL OBJECT CREATION
        // ==========================================

        System.out.println("\n===== PART 1: NORMAL ANIMAL =====");

        Animal myAnimal = new Animal("Lion");

        myAnimal.eat();
        myAnimal.makeSound();
        myAnimal.breathe();

        // ACCESS:
        // Animal methods: YES
        // Dog methods: NO



        // ==========================================
        // PART 2: UPCASTING
        // ==========================================

        System.out.println("\n===== PART 2: UPCASTING =====");

        Animal myPet = new Dog("Buddy", "Golden Retriever");

        myPet.eat();
        myPet.makeSound();
        myPet.breathe();

        // ACCESS:
        // Animal methods: YES
        // Dog-specific methods: NO
        //
        // IMPORTANT:
        // makeSound() executes Dog's implementation
        // because Dog overrides this method.



        // ==========================================
        // PART 3: DOG-ONLY METHODS
        // ==========================================

        System.out.println("\n===== PART 3: DOG-ONLY METHODS =====");

        // These produce COMPILATION ERRORS:

        // myPet.wagTail();
        // myPet.fetchBall();

        // WHY?
        // Because myPet is declared as Animal.
        // Animal doesn't contain these methods.



        // ==========================================
        // PART 4: DOWNCASTING (BASIC EXAMPLE)
        // ==========================================

        System.out.println("\n===== PART 4: DOWNCASTING =====");

        Dog myDog = (Dog) myPet;

        // Now we can access Animal + Dog methods

        myDog.eat();
        myDog.makeSound();
        myDog.breathe();

        myDog.wagTail();
        myDog.fetchBall();

        // ACCESS:
        // Animal methods: YES
        // Dog methods: YES



        // ==========================================
        // PART 5: REAL PRACTICAL DOWNCASTING
        // ==========================================

        System.out.println("\n===== PART 5: PRACTICAL DOWNCASTING =====");

        //* ANIMAL SHELTER */
        // Step 1: Create an AnimalShelter
        AnimalShelter shelter = new AnimalShelter();

        // Step 2: Ask the shelter to give us an animal
        Animal receivedAnimal = shelter.giveAnimal(); //* shelter.giveAnimal return an Animal object type with name dog */

        // The shelter returned an Animal-type result.
        // But the actual object is a Dog!

        receivedAnimal.eat();
        receivedAnimal.makeSound();

        // This DOES NOT WORK:
        // receivedAnimal.fetchBall();

        // Step 3: Check whether the animal is a Dog

        if (receivedAnimal instanceof Dog) {

            // Step 4: Downcast Animal into Dog

            Dog adoptedDog = (Dog) receivedAnimal;

            // Step 5: Now we can use Dog-specific methods

            adoptedDog.wagTail();
            adoptedDog.fetchBall();

            // We can also use inherited methods

            adoptedDog.eat();
            adoptedDog.breathe();
            adoptedDog.makeSound();
        }



        // ==========================================
        // PART 6: NORMAL DOG OBJECT CREATION
        // ==========================================

        System.out.println("\n===== PART 6: NORMAL DOG =====");

        Dog anotherDog = new Dog("Max", "German Shepherd");

        anotherDog.eat();
        anotherDog.makeSound();
        anotherDog.breathe();

        anotherDog.wagTail();
        anotherDog.fetchBall();

        // No casting is needed!



        // ==========================================
        // PART 7: INSTANCEOF
        // ==========================================

        System.out.println("\n===== PART 7: INSTANCEOF =====");

        System.out.println(myAnimal instanceof Animal);     // true
        System.out.println(myAnimal instanceof Dog);        // false

        System.out.println(myPet instanceof Animal);        // true
        System.out.println(myPet instanceof Dog);           // true

        System.out.println(myDog instanceof Dog);           // true

        System.out.println(receivedAnimal instanceof Dog);  // true
        System.out.println(receivedAnimal instanceof Animal); // true
    }
}