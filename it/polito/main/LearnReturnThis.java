package it.polito.main;

/* =============================================================================
 * TOPIC: The Mechanics of 'return this;' (Method Chaining Deep Dive)
 * FILE NAME: LearnReturnThis.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: THE BLUEPRINT
// -----------------------------------------------------------------------------
class SmartRobot {
    
    String name;
    int batteryLevel = 100;

    // Constructor
    SmartRobot(String robotName) {
        name = robotName;
    }

    /*
     * THE 'return this' MECHANIC:
     * Notice the return type is 'SmartRobot'. This means this method MUST 
     * spit out a SmartRobot object when it finishes.
     */
    public SmartRobot walk() {
        System.out.println("   [" + name + "]: Walking forward...");
        batteryLevel -= 10; 
        
        /*
         * 'this' literally translates to "myself" (the current object in memory).
         * By returning 'this', the robot hands its own remote control back 
         * to the main program.
         */
        return this; 
    }

    public SmartRobot speak(String words) {
        System.out.println("   [" + name + "]: Says \"" + words + "\"");
        batteryLevel -= 5;
        return this; // Hands the remote control back again
    }

    public SmartRobot printStatus() {
        System.out.println("   [" + name + "]: Battery is at " + batteryLevel + "%");
        return this; // Hands the remote control back again
    }
}

// -----------------------------------------------------------------------------
// PART 2: THE MAIN EXECUTION CLASS
// -----------------------------------------------------------------------------
public class LearnReturnThis {
    
    public static void main(String[] args) {
        
        // We create the object in memory and hold its remote control in 'wallE'
        SmartRobot wallE = new SmartRobot("WALL-E");

        System.out.println("--- STEP-BY-STEP CHAINING EXECUTION ---");
        
        /*
         * HOW JAVA READS THE CHAIN (The "Catch and Pass" mechanic):
         * 
         * Code we write: 
         * wallE.walk().speak("Hello!").printStatus();
         * 
         * Step 1: Java executes 'wallE.walk()'
         *   - The robot walks. Battery drops to 90.
         *   - The method hits 'return this;' and shoots the 'wallE' object back.
         *   - The first dot (.) CATCHES the returned object. 
         *   - Behind the scenes, the code essentially becomes: wallE.speak("Hello!").printStatus();
         * 
         * Step 2: Java executes 'wallE.speak("Hello!")'
         *   - The robot speaks. Battery drops to 85.
         *   - The method hits 'return this;' and shoots the 'wallE' object back again.
         *   - The second dot (.) CATCHES the returned object.
         *   - Behind the scenes, the code essentially becomes: wallE.printStatus();
         * 
         * Step 3: Java executes 'wallE.printStatus()'
         *   - The robot prints its battery (85%).
         *   - It hits 'return this;' one last time.
         *   - There are no more dots. The semicolon (;) catches it and ends the line.
         */
        
        wallE.walk().speak("Hello!").printStatus();


        System.out.println("\n--- PROOF THAT 'THIS' IS THE EXACT SAME OBJECT ---");
        
        /*
         * Because 'return this;' passes the exact same object back, 
         * we can actually catch it in a NEW variable. 
         * This is exactly the "Aliasing" concept we learned earlier!
         */
        
        // 1. We call 'walk' on wallE.
        // 2. 'walk' returns 'this' (the wallE object).
        // 3. We catch that returned object and store it in 'cloneRobot'.
        SmartRobot cloneRobot = wallE.walk();

        // If we command 'cloneRobot', we are actually commanding 'wallE'.
        cloneRobot.speak("I am the same robot!");
        
        // Let's check wallE's battery to prove it was affected by cloneRobot's actions
        wallE.printStatus(); 
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- STEP-BY-STEP CHAINING EXECUTION ---
 *    [WALL-E]: Walking forward...
 *    [WALL-E]: Says "Hello!"
 *    [WALL-E]: Battery is at 85%
 * 
 * --- PROOF THAT 'THIS' IS THE EXACT SAME OBJECT ---
 *    [WALL-E]: Walking forward...
 *    [WALL-E]: Says "I am the same robot!"
 *    [WALL-E]: Battery is at 70%
 * ============================================================================= */