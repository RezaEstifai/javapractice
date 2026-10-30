package it.polito.main;
import it.polito.model.InnerClasses;
import it.polito.model.InnerClasses.Incrementer;

/**
 * Executable driver matching the main execution trace of Slide 133.
 */
public class InnerClassMain {

    public static void main(String[] args) {

        System.out.println("=== EXECUTING SLIDE 133 INNER CLASS TRACE ===");

        // Step 1: Create an outer Counter instance
        InnerClasses c = new InnerClasses();
        System.out.println("Initial Counter value: " + c.getValue()); // 0

        // Step 2: Build two separate Incrementer instances tethered to Counter 'c'
        Incrementer byOne = c.buildIncrementer(1);
        Incrementer byFour = c.buildIncrementer(4);

        // Step 3: Run doIncrement() on byOne
        // 'byOne' reaches through its tether and adds 1 to c.i
        byOne.doIncrement();
        System.out.println("After byOne.doIncrement()  -> Counter = " + c.getValue()); // 1

        // Step 4: Run doIncrement() on byFour
        // 'byFour' reaches through its tether and adds 4 to c.i
        byFour.doIncrement();
        System.out.println("After byFour.doIncrement() -> Counter = " + c.getValue()); // 5

        System.out.println("\nFinal Counter Value (c.getValue()): " + c.getValue()); // Matches Slide 133: 5!
    }
}