package it.polito.model;

/* =============================================================================
 * TOPIC: The Mechanics of 'return this;' (Method Chaining Deep Dive)
 * FILE NAME: LearnReturnThis.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: THE BLUEPRINT
// -----------------------------------------------------------------------------
class SmartBot {
    
    String name;
    int batteryLevel = 100;

    // Constructor
    SmartBot(String robotName) {
        name = robotName;
    }

    /*
     * THE 'return this' MECHANIC:
     * Notice the return type is 'SmartBot'. This means this method MUST 
     * spit out a SmartBot object when it finishes.
     */
    public SmartBot walk() {
        System.out.println("   [" + name + "]: Walking forward...");
        batteryLevel -= 10; 
        
        /*
         * 'this' literally translates to "myself" (the current object in memory).
         * By returning 'this', the robot hands its own remote control back 
         * to the main program.
         */
        return this; 
    }

    public SmartBot speak(String words) {
        System.out.println("   [" + name + "]: Says \"" + words + "\"");
        batteryLevel -= 5;
        return this; // Hands the remote control back again
    }

    public SmartBot printStatus() {
        System.out.println("   [" + name + "]: Battery is at " + batteryLevel + "%");
        return this; // Hands the remote control back again
    }
}
