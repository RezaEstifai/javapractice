package it.polito.main.Interface;


// Import the classes from the model package.
//* If the models were in another folder  */
// import it.polito.main.Interface.Animal;
// import it.polito.main.Interface.Dog;
// import it.polito.main.Interface.Cat;

/**
 * ============================================================================
 * MAIN CLASS
 * ============================================================================
 *
 * This is where we create objects and test our code.
 *
 * Notice that Dog and Cat are in a DIFFERENT package.
 * That's why we need to import them.
 * ============================================================================
 */

public class Main {


    /**
     * METHOD: introduceAnimal()
     *
     * IMPORTANT:
     *
     * The parameter type is Animal, NOT Dog or Cat.
     *
     * This means we can pass ANY object that implements Animal.
     *
     * For example:
     * - introduceAnimal(dog1);
     * - introduceAnimal(cat1);
     *
     * Java allows this because both Dog and Cat implement Animal.
     */
    public static void introduceAnimal(Animal animal) {

        System.out.println("Animal name: " + animal.getName());

        // Java executes the implementation belonging to the actual object.
        // Dog  -> Woof!
        // Cat  -> Meow!
        animal.makeSound();

        System.out.println("--------------------");
    }


    public static void main(String[] args) {

        System.out.println("=== CREATING ANIMALS ===");


        // ============================================================
        // 1. CREATE OBJECTS
        // ============================================================

        Dog dog1 = new Dog("Max");

        Dog dog2 = new Dog("Rocky");

        Cat cat1 = new Cat("Luna");


        // ============================================================
        // 2. CALL METHODS DIRECTLY
        // ============================================================

        System.out.println("\n=== DIRECT METHOD CALLS ===");

        dog1.makeSound();

        cat1.makeSound();


        // ============================================================
        // 3. PASS OBJECTS TO ANOTHER METHOD
        // ============================================================

        System.out.println("\n=== PASSING OBJECTS TO A METHOD ===");

        introduceAnimal(dog1);

        introduceAnimal(dog2);

        introduceAnimal(cat1);

    }

}