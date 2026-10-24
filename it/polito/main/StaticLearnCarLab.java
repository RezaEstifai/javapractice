package it.polito.main;

import it.polito.model.StaticLearnCar;

/**
 * Demonstrates how static attributes and methods behave in memory 
 * before and after object creation.
 */
public class StaticLearnCarLab {

    public static void main(String[] args) {

        System.out.println("=== 1. BEFORE CREATING ANY OBJECTS ===");
        // Slide 102 rule: Static attributes exist BEFORE any object is created!
        // We can query the static counter straight from the class name without building a car.
        System.out.println("Cars built so far (via Class): " + StaticLearnCar.getCountBuiltCars());


        System.out.println("\n=== 2. CREATING CAR #1 ===");
        StaticLearnCar car1 = new StaticLearnCar("Fiat 500");
        System.out.println("Created: " + car1);
        // The shared counter updates globally
        System.out.println("Total cars built: " + StaticLearnCar.getCountBuiltCars());


        System.out.println("\n=== 3. CREATING CAR #2 & #3 ===");
        StaticLearnCar car2 = new StaticLearnCar("Alfa Romeo");
        StaticLearnCar car3 = new StaticLearnCar("Ferrari");
        
        System.out.println("Created: " + car2);
        System.out.println("Created: " + car3);

        // Slide 102 rule: A change performed by any object is visible to all instances at once.
        // All three cars share the exact same count variable.
        System.out.println("Total cars built across all instances: " + StaticLearnCar.getCountBuiltCars());
        
        // Verifying individual instance IDs (their personal notebooks are separate):
        System.out.println("Car 1 ID: " + car1.getCarId() + " | Car 3 ID: " + car3.getCarId());
    }
}


    /*
     * =========================================================================
     * ARCHITECTURAL CONCEPT: LIVE TICKER VS. PERMANENT SNAPSHOT
     * =========================================================================
     * 
     * WHY DO WE NEED BOTH 'countBuiltCars' AND 'carId'?
     * -------------------------------------------------------------------------
     * At first glance, both values seem to equal '1' for Car 1 and '2' for Car 2.
     * The critical difference is what happens to PAST objects when FUTURE objects
     * are created:
     * 
     *   1. countBuiltCars (The Live Ticker - 'static')
     *      - Lives in shared memory.
     *      - Never stops changing: advances from 1 -> 2 -> 3 -> 100...
     *      - Answers: "How many total cars exist right now?"
     * 
     *   2. carId (The Permanent Snapshot - 'private final')
     *      - Lives inside each car's private memory.
     *      - Frozen at the moment of creation; NEVER changes.
     *      - Answers: "Which specific car is this?"
     * 
     * -------------------------------------------------------------------------
     * MEMORY TIMELINE:
     * -------------------------------------------------------------------------
     * [T1] Car 1 is created:
     *      StaticLearnCar.countBuiltCars = 1
     *      car1.carId                   = 1
     * 
     * [T2] Car 2 is created:
     *      StaticLearnCar.countBuiltCars = 2  <-- Global counter changes!
     *      car1.carId                   = 1  <-- FROZEN (Does NOT change)
     *      car2.carId                   = 2  <-- Takes current snapshot
     * 
     * [T3] Car 3 is created:
     *      StaticLearnCar.countBuiltCars = 3  <-- Global counter changes!
     *      car1.carId                   = 1  <-- Still 1
     *      car2.carId                   = 2  <-- Still 2
     *      car3.carId                   = 3  <-- Takes current snapshot
     * 
     * -------------------------------------------------------------------------
     * THE TRAP TO AVOID IN EXAMS:
     * -------------------------------------------------------------------------
     * If we deleted 'carId' and let 'getCarId()' just return 'countBuiltCars':
     *   - When Car 1 is created: car1.getCarId() returns 1.
     *   - When Car 100 is created: car1.getCarId() would now return 100!
     * Every existing object would lose its identity and display the total count.
     * 
     * 'private final int carId' guarantees each car keeps its own serial number
     * stamped into memory forever.
     * =========================================================================
     */
