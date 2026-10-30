package it.polito.main;

/**
 * ============================================================================
 * STUDY NOTE: SEPARATE CLASSES IN SEPARATE FILES
 * ============================================================================
 * 
 * DIRECTORY DIRECTIONS IN VS CODE:
 * Place all of these files inside your package folder structure:
 *    javapractice/it/polito/main/
 * 
 * HOW IT WORKS:
 * Even though CarSeparateFile and WheelCalculatorSeparateFile are in completely 
 * different files, the communication rule remains identical: 
 * You must pass the object reference as an argument!
 * ============================================================================
 */

public class SeparateFilesMain {
    public static void main(String[] args) {
        System.out.println("=== TESTING SEPARATE FILES SCENARIO ===");

        // 1. Create the car object from its separate file
        SeparateClassesCar myCar = new SeparateClassesCar();

        // 2. Call the calculator from its separate file and pass the car object
        WheelCalculatorSeparateFile.checkCarFuel(myCar);
    }
}

/**
 * Separate helper class file example simulation.
 * (In your project, you could also save this as WheelCalculatorSeparateFile.java)
 */
class WheelCalculatorSeparateFile {
    public static void checkCarFuel(SeparateClassesCar carObj) {
        System.out.println("[SeparateFile Calculator] Checked fuel from another file: " + carObj.getFuelLevel());
    }
}
