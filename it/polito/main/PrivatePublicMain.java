package it.polito.main;

// Import the public class from the model folder
import it.polito.model.PrivatePublic;

/**
 * Topic: Calling Private, Package, and Public Members across Packages (Slide 76)
 * Target Path: easyProject/src/it/polito/main/EncapsulationRunner.java
 */
public class PrivatePublicMain {

    public static void main(String[] args) {
        System.out.println("=== VISIBILITY AND GETTERS/SETTERS IN ACTION ===\n");

        PrivatePublic oop = new PrivatePublic(120, 8, 101);

        // ---------------------------------------------------------------------
        // TEST 1: The 'private int studentCount' Attribute
        // ---------------------------------------------------------------------
        System.out.println("--- Test 1: Private Attribute ---");

        // DIRECT ACCESS ATTEMPT:
        // oop.studentCount = 200; 
        // -> COMPILE ERROR: studentCount has private access in it.polito.model.Course!
        System.out.println("Direct read/write: oop.studentCount -> BLOCKED by compiler");

        // ACCESS VIA PUBLIC GETTER & SETTER:
        System.out.println("Read via getter: " + oop.getStudentCount() + " students -> ALLOWED");

        // The setter protects our data from invalid input:
        oop.setStudentCount(-50); // Setter rejects invalid data!
        oop.setStudentCount(150); // Setter accepts valid data
        System.out.println("Updated via setter: " + oop.getStudentCount() + " students -> ALLOWED\n");

        // ---------------------------------------------------------------------
        // TEST 2: The 'int credits' (Package-Private) Attribute
        // ---------------------------------------------------------------------
        System.out.println("--- Test 2: Package-Private Attribute ---");

        // DIRECT ACCESS ATTEMPT FROM ANOTHER FOLDER:
        // oop.credits = 10;
        // -> COMPILE ERROR: credits is not public in it.polito.model.Course;
        //                   cannot be accessed from outside package!
        System.out.println("Direct read/write: oop.credits -> BLOCKED by compiler across packages");

        // ACCESS VIA PUBLIC GETTER & SETTER:
        // Even though 'credits' itself is hidden, its public methods are reachable:
        System.out.println("Read via getter: " + oop.getCredits() + " CFU -> ALLOWED");
        oop.setCredits(10);
        System.out.println("Updated via setter: " + oop.getCredits() + " CFU -> ALLOWED\n");

        // ---------------------------------------------------------------------
        // TEST 3: The 'public int courseId' Attribute
        // ---------------------------------------------------------------------
        System.out.println("--- Test 3: Public Attribute (Why it is dangerous) ---");

        // DIRECT ACCESS FROM OUTSIDE:
        System.out.println("Direct read: oop.courseId = " + oop.courseId + " -> ALLOWED");

        // The danger: Anyone can overwrite it with nonsensical values with no checks!
        oop.courseId = -9999;
        System.out.println("Direct write: oop.courseId changed to " + oop.courseId + " -> NO PROTECTION!");
    }
}

/*
======================================================================
EXPECTED TERMINAL OUTPUT:
======================================================================
=== VISIBILITY AND GETTERS/SETTERS IN ACTION ===

--- Test 1: Private Attribute ---
Direct read/write: oop.studentCount -> BLOCKED by compiler
Read via getter: 120 students -> ALLOWED
[REJECTED] Student count cannot be negative: -50
Updated via setter: 150 students -> ALLOWED

--- Test 2: Package-Private Attribute ---
Direct read/write: oop.credits -> BLOCKED by compiler across packages
Read via getter: 8 CFU -> ALLOWED
Updated via setter: 10 CFU -> ALLOWED

--- Test 3: Public Attribute (Why it is dangerous) ---
Direct read: oop.courseId = 101 -> ALLOWED
Direct write: oop.courseId changed to -9999 -> NO PROTECTION!
======================================================================
*/