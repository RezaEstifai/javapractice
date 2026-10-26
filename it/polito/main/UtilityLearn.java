package it.polito.main;

// 1. IMPORT STATEMENTS:
// Math and System live in java.lang (imported automatically).
// Arrays lives in java.util, so we must explicitly import it.
import java.util.Arrays;

/**
 * MASTER LAB: Java Utility Classes (Slides 108 to 112)
 * Demonstrates Math, Arrays, IO, and System static helper methods.
 */
public class UtilityLearn {

    public static void main(String[] args) {

        // =====================================================================
        // 1. CLASS MATH (Slide 109) - Mathematical Functions
        // =====================================================================
        System.out.println("=== 1. CLASS MATH (Slide 109) ===");
        
        // Min / Max
        double higher = Math.max(10.5, 20.8);
        int lower = Math.min(5, 12);
        System.out.println("Math.max(10.5, 20.8) = " + higher);
        System.out.println("Math.min(5, 12)       = " + lower);

        // Powers and Square Root
        double squared = Math.pow(3.0, 4.0); // 3^4 = 81.0
        double root = Math.sqrt(81.0);       // Square root = 9.0
        System.out.println("Math.pow(3.0, 4.0)   = " + squared);
        System.out.println("Math.sqrt(81.0)      = " + root);

        // Truncations: round(), ceil(), floor()
        double val = 4.7;
        System.out.println("Math.round(4.7)      = " + Math.round(val)); // 5
        System.out.println("Math.ceil(4.1)       = " + Math.ceil(4.1));  // 5.0 (rounds up)
        System.out.println("Math.floor(4.9)      = " + Math.floor(4.9)); // 4.0 (rounds down)

        // Random number generation [0.0 to 1.0)
        double rand = Math.random();
        System.out.println("Math.random()        = " + rand);


        // =====================================================================
        // 2. CLASS ARRAYS (Slide 110) - Array Utilities
        // =====================================================================
        System.out.println("\n=== 2. CLASS ARRAYS (Slide 110) ===");

        int[] numbers = {45, 12, 89, 3, 23};

        // Sorting (sort())
        Arrays.sort(numbers);
        System.out.println("Arrays.sort() result : " + Arrays.toString(numbers)); // toString() representation

        // Binary Search (binarySearch() - array MUST be sorted first!)
        int index = Arrays.binarySearch(numbers, 23);
        System.out.println("Binary search for 23 : found at index " + index);

        // Copying arrays (copyOf())
        int[] copiedArray = Arrays.copyOf(numbers, 3); // Copies first 3 elements
        System.out.println("Arrays.copyOf(3)     : " + Arrays.toString(copiedArray));

        // Filling arrays (fill())
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        System.out.println("Arrays.fill(7)       : " + Arrays.toString(filled));


        // =====================================================================
        // 3. CLASS SYSTEM (Slide 112) - Operating System & Time Utilities
        // =====================================================================
        System.out.println("\n=== 3. CLASS SYSTEM (Slide 112) ===");

        // Current time in milliseconds since January 1, 1970 (Epoch time)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis() = " + currentTimeMillis);

        // Standard Output Stream (System.out) and print/println
        // (System.out is a static final PrintStream attribute inside class System)
        System.out.println("System.out.println prints with a newline.");
        System.out.print("System.out.print stays on the same line. ");
        System.out.println("Back on line.");


        // =====================================================================
        // 4. CLASS IO (Slide 111) - Politecnico Console Input/Output Library
        // =====================================================================
        System.out.println("\n=== 4. CLASS IO (Slide 111) ===");
        System.out.println("Note: IO is a custom helper class provided in Polito OOP labs.");
        System.out.println("Typical declarations & usage from Slide 111:");
        System.out.println("  IO.println(\"Hello Polito!\");");
        System.out.println("  String input = IO.readln(\"Enter your name: \");");
    }
}

// =====================================================================
// QUICK NOTES: COMMON UTILITY CLASS TRAPS
// =====================================================================
//
// * Trying to Instantiate a Utility Class:
//   Writing `Math m = new Math();` is a compile error. The Math class has
//   a private constructor, so it cannot be instantiated.
//
// * Binary Search Trap (`Arrays.binarySearch`):
//   Rule: Call `Arrays.sort(arr)` before `Arrays.binarySearch(arr, key)`.
//   The array must be sorted; otherwise, the search result is unspecified.
//
// * `System.out` vs `System.err`:
//   `System.out` is the standard output stream, while `System.err` is the
//   standard error stream, commonly used for error messages. Both are
//   `static final PrintStream` fields in `System`.
//
// * `IO` Class Scope:
//   `IO` (`IO.print`, `IO.println`, `IO.readln`) is a helper library
//   specifically bundled into Politecnico di Torino academic lab exercises.