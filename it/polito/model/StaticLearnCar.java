package it.polito.model;

/**
 * EXAM PATTERN: AUTO-INCREMENTING UNIQUE IDS USING STATIC COUNTERS
 * 
 * CORE CONCEPT TO REMEMBER AFTER 6 MONTHS:
 * -------------------------------------------------------------------------
 * 1. "static" variable:
 *    - Lives on the CLASS itself, in one single shared spot in memory.
 *    - There is ONLY ONE copy of it for the whole program.
 *    - Accessed via: ClassName.variableName (e.g., StaticLearnCar.countBuiltCars).
 * 
 * 2. Non-static (instance) variable:
 *    - Lives inside EACH SPECIFIC OBJECT created with 'new'.
 *    - If you create 100 objects, there are 100 separate copies in memory.
 *    - Accessed via: this.variableName (e.g., this.carId).
 * 
 * 3. The 2-Step Auto-ID Mechanism:
 *    - Step A: Increment the shared global counter (+1).
 *    - Step B: Snapshot that new number into the current object's permanent field.
 * -------------------------------------------------------------------------
 */
public class StaticLearnCar {

    // =========================================================================
    // 1. THE SHARED GLOBAL COUNTER (CLASS LEVEL)
    // =========================================================================
    //* */ WHY 'static'?
    // Because we need a single shared memory cell that remembers how many cars
    // have been created so far across the ENTIRE application.
    // If this were NOT static, every 'new StaticLearnCar()' would reset its own count to 0!
    //
    //*  */ WHY 'private'?
    // To prevent outside classes from directly doing 'StaticLearnCar.countBuiltCars = -999;'.
    private static int countBuiltCars = 0;


    // =========================================================================
    // 2. THE PER-OBJECT INSTANCE ATTRIBUTES (OBJECT LEVEL)
    // =========================================================================
    // WHY NOT 'static'?
    // Because each individual car must hold its OWN name and its OWN unique ID.
    //
    // WHY 'final'?
    // 1. Immutability: Once a car is manufactured and gets an ID, that ID must never change.
    // 2. Safety: The compiler guarantees these fields are initialized exactly once in the constructor.
    private final String modelName;
    private final int carId;


    // =========================================================================
    // 3. CONSTRUCTOR: THE FACTORY ASSEMBLY LINE
    // =========================================================================
    /**
     * Runs every time someone calls: new StaticLearnCar("ModelName");
     * 
     * @param modelName The specific model name for THIS instance.
     */
    public StaticLearnCar(String modelName) {
        
        // REASON: Save the incoming parameter into THIS specific object's field.
        // 'this.modelName' refers to the object's instance variable.
        // 'modelName' refers to the parameter passed into the constructor.
        this.modelName = modelName;
        
        // ---------------------------------------------------------------------
        // STEP A: ADVANCE THE GLOBAL COUNTER
        // ---------------------------------------------------------------------
        // REASON: A new car was just born! The total count of all cars must increase by 1.
        //
        // WHY 'StaticLearnCar.countBuiltCars++' AND NOT 'this.countBuiltCars++'?
        // Because 'countBuiltCars' belongs to the CLASS, not to 'this' single car.
        // Writing 'StaticLearnCar.' explicitly shows we are touching shared class memory.
        StaticLearnCar.countBuiltCars++;
        
        // ---------------------------------------------------------------------
        // STEP B: FREEZE THAT NUMBER INTO THIS CAR'S PERSONAL ID
        // ---------------------------------------------------------------------
        // REASON: Give THIS car its permanent badge number using the updated counter value.
        //
        // WHY 'this.carId'?
        // Because 'carId' belongs to THIS specific car instance.
        //
        // TRACE EXAMPLE:
        // Car 1 created -> StaticLearnCar.countBuiltCars becomes 1 -> this.carId = 1
        // Car 2 created -> StaticLearnCar.countBuiltCars becomes 2 -> this.carId = 2
        // Notice: Car 1's carId REMAINS 1 forever because its 'this.carId' was already locked!
        this.carId = StaticLearnCar.countBuiltCars;

        // NOTE FOR EXAMS:
        // You can combine Step A and Step B into one line:
        // this.carId = ++StaticLearnCar.countBuiltCars;
    }


    // =========================================================================
    // 4. STATIC METHOD: GLOBAL QUERY
    // =========================================================================
    // REASON: Lets external code ask "How many total cars exist right now?"
    //
    // WHY 'static'?
    // You should be able to call this even if ZERO cars have been instantiated yet:
    // int total = StaticLearnCar.getCountBuiltCars(); // returns 0, no object needed!
    // Since it does not belong to a specific car, 'this' DOES NOT EXIST inside this method.
    public static int getCountBuiltCars() {
        return StaticLearnCar.countBuiltCars;
    }


    // =========================================================================
    // 5. INSTANCE METHODS: QUERIES ON A SPECIFIC CAR
    // =========================================================================
    // REASON: Read THIS car's private fields safely from outside the class.
    //
    // WHY NOT 'static'?
    // Because you cannot ask "What is the model name?" without specifying WHICH car!
    // Example: car1.getModelName() vs car2.getModelName()
    public String getModelName() {
        return this.modelName;
    }

    public int getCarId() {
        return this.carId;
    }


    // =========================================================================
    // 6. TEXT REPRESENTATION
    // =========================================================================
    // REASON: When you do System.out.println(myCar), Java automatically runs this
    // instead of printing the memory address (like StaticLearnCar@6acbcfc0).
    @Override
    public String toString() {
        return "StaticLearnCar{model='" + this.modelName + "', carId=" + this.carId + "}";
    }
}
