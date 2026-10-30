package it.polito.main;

/**
 * ============================================================================
 * STUDY NOTE: SEPARATE CLASSES IN THE SAME FILE (NO INNER LINK)
 * ============================================================================
 * 
 * CORE RULE:
 * When a class is completely separate (not nested inside another), it has 
 * NO secret link to parent objects. 
 * 
 * TRAP / HOW TO FIX:
 * If a separate class needs to read or use private variables of a Car object 
 * (like `private int fuelLevel`), it CANNOT access them directly. 
 * 
 * SOLUTION:
 * 1. The Car class must provide a getter method (e.g., `getFuelLevel()`).
 * 2. You must PASS the Car object into the separate class's method as a parameter!
 *    (Example: WheelCalculator.checkCarFuel(myCar))
 * ============================================================================
 */
public class SeparateClassesSameFileMain {

    public static void main(String[] args) {
        System.out.println("=== TESTING SEPARATE CLASSES (SAME FILE) ===");

        // 1. Create the Car object
        CarSeparate myCar = new CarSeparate();

        // 2. Call the separate class method and PASS the car object into it as an argument
        WheelCalculatorSeparate.checkCarFuel(myCar);
    }
}


/**
 * ----------------------------------------------------------------------------
 * CLASS 1: CarSeparate
 * ----------------------------------------------------------------------------
 * A standalone class holding its own private data.
 */
class CarSeparate {
    private int fuelLevel = 50; // Private! Separate classes cannot touch this directly.

    // GETTER METHOD: The bridge that allows outside/separate classes to read the fuel safely.
    public int getFuelLevel() {
        return this.fuelLevel; 
    }
}


/**
 * ----------------------------------------------------------------------------
 * CLASS 2: WheelCalculatorSeparate
 * ----------------------------------------------------------------------------
 * A completely separate class sitting in the same file.
 */
class WheelCalculatorSeparate {
    
    // NOTICE: We pass the 'CarSeparate carObj' INTO the method as a parameter!
    public static void checkCarFuel(CarSeparate carObj) {
        // We use the getter method to look at that specific car's fuel safely
        int fuel = carObj.getFuelLevel();
        System.out.println("[WheelCalculatorSeparate] Successfully checked car fuel via parameter: " + fuel);
    }
}
 


//*  */

// // --- CLASS 1: Car ---
// class Car {
//     private int fuelLevel = 50; // Private! Separate classes cannot touch this directly.

//     // Getter method: allows outside classes to read the fuel safely
//     public int getFuelLevel() {
//         return this.fuelLevel; 
//     }
// }

// // --- CLASS 2: WheelCalculator (Completely Separate Class) ---
// class WheelCalculator {
    
//     // Notice we pass the Car object INTO the method as a parameter!
//     public static void checkCarFuel(Car carObj) {
//         // We use the getter to look at that specific car's fuel
//         int fuel = carObj.getFuelLevel();
//         System.out.println("WheelCalculator checked this car's fuel: " + fuel);
//     }
// }

// // --- HOW YOU USE IT IN MAIN ---
// public class Main {
//     public static void main(String[] args) {
//         // 1. Create the Car object
//         Car myCar = new Car(); 

//         // 2. Call the separate class method and PASS the car object into it!
//         WheelCalculator.checkCarFuel(myCar); 
//     }
// }