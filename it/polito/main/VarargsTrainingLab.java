package it.polito.main;

// We import Arrays so we can print array contents nicely using Arrays.toString()
import java.util.Arrays;

/**
 * TRAINING LAB: Variable Arguments (Varargs) from Absolute Zero.
 * Designed so that reviewing this file after 1 month takes zero effort.
 */
public class VarargsTrainingLab {

    // =========================================================================
    // EXERCISE 1: The Anatomy of a Varargs Method Signature
    // =========================================================================
    /**
     * Look at the parameter: 'int... values'.
     * The three dots (...) mean: "Java, please pack any loose integers passed here 
     * into a standard int[] array for me."
     */
    static void printEverything(int... values) {
        
        // TRAINING NOTE: Even though the signature uses 'int...', 
        // inside this method 'values' is 100% a normal 1D array (int[])!
        System.out.println("1. What type is 'values' really? -> " + values.getClass().getSimpleName());
        System.out.println("2. How many items were passed?   -> " + values.length);
        System.out.println("3. The actual contents           -> " + Arrays.toString(values));
        System.out.println("--------------------------------------------------");
    }

    // =========================================================================
    // EXERCISE 2: Combining Fixed Parameters with Varargs
    // =========================================================================
    /**
     * RULE: If a method has a normal parameter AND varargs, 
     * the varargs parameter MUST be the very last thing in the parentheses.
     * 
     * @param prefix A mandatory text label (must be provided).
     * @param scores Variable number of integer scores (0, 1, or many allowed).
     */
    static void printScores(String prefix, int... scores) {
        System.out.println("Label: " + prefix);
        System.out.println("Scores array: " + Arrays.toString(scores));
        System.out.println("==================================================");
    }

    public static void main(String[] args) {

        System.out.println("=== SCENARIO A: PASSING LOOSE NUMBERS ===");
        // We pass 3 loose numbers. 
        // Under the hood, the compiler instantly rewrites this to: printEverything(new int[]{5, 10, 15});
        printEverything(5, 10, 15);


        System.out.println("=== SCENARIO B: PASSING ZERO ARGUMENTS ===");
        // We pass NO numbers at all. 
        // Under the hood, the compiler rewrites this to: printEverything(new int[0]);
        // Notice it does NOT crash! It passes an empty array of length 0.
        printEverything();


        System.out.println("=== SCENARIO C: PASSING AN EXISTING ARRAY ===");
        // If you already have a pre-made array box, you can hand it directly to varargs[cite: 8].
        int[] myExistingBox = {99, 88, 77};
        // The compiler sees you already have a box, so it uses your exact array without making a new one[cite: 8].
        printEverything(myExistingBox);


        System.out.println("=== SCENARIO D: MIXING FIXED PARAMETERS AND VARARGS ===");
        // Parameter 1 ("Student A") goes to 'prefix'.
        // The remaining parameters (90, 85, 95) are packed into the 'scores' array.
        printScores("Student A", 90, 85, 95);

        // What if the student has 0 scores? That is also legal!
        printScores("Student B"); // scores becomes an empty array of length 0.
    }
}