package it.polito.main;

/* =============================================================================
 * TOPIC: Control Statements (Decision Making & Loops)
 * FILE NAME: LearnControlFlow.java
 * ============================================================================= */

public class LearnControlFlow {

    public static void main(String[] args) {

        /* ---------------------------------------------------------------------
         * 1. IF-ELSE
         * THE LOGIC: "If this exact condition is true, do A. Otherwise, do B."
         * THE TRICK (When to use): Use this for ranges (e.g., score > 18) or 
         * complex boolean logic (e.g., condition1 AND condition2).
         * DATA TYPES: Strictly requires a 'boolean' (true/false) inside the ().
         * --------------------------------------------------------------------- */
        System.out.println("--- 1. IF-ELSE ---");
        int examScore = 24; 
        
        // The expression (examScore >= 18) results in a boolean 'true'
        if (examScore >= 18) {
            System.out.println("Result: You passed the exam.");
        } else {
            System.out.println("Result: You failed. Try again.");
        }


        /* ---------------------------------------------------------------------
         * 2. SWITCH
         * THE LOGIC: "Look at this specific variable. Does it match case A? 
         * Case B? Case C?"
         * THE TRICK (When to use): Use when checking a single variable against
         * a list of exact, discrete values (like a menu selection or a category).
         * DATA TYPES: Does NOT use booleans! Works with int, char, and String.
         * --------------------------------------------------------------------- */
        System.out.println("\n--- 2. SWITCH ---");
        int universityYear = 2; // We are checking an integer

        switch (universityYear) {
            case 1:
                System.out.println("You are a Freshman.");
                break; // 'break' stops it from spilling into case 2
            case 2:
                System.out.println("You are a Sophomore studying Computer Engineering.");
                break;
            case 3:
                System.out.println("You are a Junior. Almost done with your Bachelor's!");
                break;
            default: // Runs if none of the above match
                System.out.println("Invalid year or you are in a Master's program.");
        }


        /* ---------------------------------------------------------------------
         * 3. WHILE
         * THE LOGIC: "Keep repeating this block AS LONG AS the condition is true."
         * THE TRICK (When to use): Use when you DO NOT KNOW how many times the 
         * loop needs to run. (e.g., "Keep reading a file until it is empty").
         * Note: If the condition is false immediately, it runs ZERO times.
         * --------------------------------------------------------------------- */
        System.out.println("\n--- 3. WHILE ---");
        int retries = 0;
        boolean connected = false;

        // Condition is checked BEFORE the loop starts
        while (!connected && retries < 2) {
            System.out.println("Attempting to connect to the database... (Try " + (retries + 1) + ")");
            retries++;
            // Simulating a successful connection on the second try
            if (retries == 2) {
                connected = true; 
                System.out.println("Connection successful!");
            }
        }


        /* ---------------------------------------------------------------------
         * 4. DO-WHILE
         * THE LOGIC: "Do this block of code first, THEN check if we should repeat."
         * THE TRICK (When to use): Use when the code MUST run AT LEAST ONCE, 
         * regardless of the condition. (e.g., "Show the main menu to the user 
         * at least once before asking if they want to exit").
         * --------------------------------------------------------------------- */
        System.out.println("\n--- 4. DO-WHILE ---");
        boolean wantToQuit = true; 

        do {
            System.out.println("Printing this once, even though wantToQuit is already true.");
        } while (!wantToQuit); // Checked at the END of the loop


        /* ---------------------------------------------------------------------
         * 5. FOR 
         * THE LOGIC: "Start here; end here; step by this amount."
         * THE TRICK (When to use): Use when you know EXACTLY how many times 
         * the loop should run (e.g., counting from 1 to 5).
         * STRUCTURE: for(initialization; boolean condition; update)
         * --------------------------------------------------------------------- */
        System.out.println("\n--- 5. FOR ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Processing student file #" + i);
        }


        /* ---------------------------------------------------------------------
         * 6. BREAK & CONTINUE
         * THE LOGIC: 'break' aborts the entire loop. 'continue' skips the current 
         * cycle and jumps straight to the next one.
         * THE TRICK (When to use): Use 'break' for emergency stops (e.g., "I found
         * the error, stop searching"). Use 'continue' for skipping invalid data 
         * (e.g., "This student dropped the class, skip to the next student").
         * --------------------------------------------------------------------- */
        System.out.println("\n--- 6. BREAK AND CONTINUE ---");
        
        for (int id = 1; id <= 5; id++) {
            
            if (id == 3) {
                System.out.println("  -> Skipping ID 3 (Student inactive) [CONTINUE]");
                continue; // Skips the rest of this cycle, jumps back to the top (id 4)
            }
            
            if (id == 5) {
                System.out.println("  -> System error at ID 5. Aborting! [BREAK]");
                break; // Completely destroys the loop. ID 5 is not processed.
            }
            
            System.out.println("Successfully processed ID: " + id);
        }
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- 1. IF-ELSE ---
 * Result: You passed the exam.
 * 
 * --- 2. SWITCH ---
 * You are a Sophomore studying Computer Engineering.
 * 
 * --- 3. WHILE ---
 * Attempting to connect to the database... (Try 1)
 * Attempting to connect to the database... (Try 2)
 * Connection successful!
 * 
 * --- 4. DO-WHILE ---
 * Printing this once, even though wantToQuit is already true.
 * 
 * --- 5. FOR ---
 * Processing student file #1
 * Processing student file #2
 * Processing student file #3
 * 
 * --- 6. BREAK AND CONTINUE ---
 * Successfully processed ID: 1
 * Successfully processed ID: 2
 *   -> Skipping ID 3 (Student inactive) [CONTINUE]
 * Successfully processed ID: 4
 *   -> System error at ID 5. Aborting! [BREAK]
 * ============================================================================= */