package it.polito.main;

/* =============================================================================
 * TOPIC: Object-Oriented Programming (OOP) - Attributes and Constructors
 * FILE NAME: LearnConstructor.java
 *
 * RULE 1 (Java File Naming):
 *   The name of the file MUST match the name of the `public class` exactly.
 *   File: LearnConstructor.java  <--->  public class LearnConstructor
 *
 * RULE 2 (Single Public Class):
 *   A single .java file can contain multiple classes, but ONLY ONE can be marked
 *   'public'. Any helper class (like StudentCard below) must NOT have 'public'.
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: THE BLUEPRINT CLASS (Helper Class)
// -----------------------------------------------------------------------------
class StudentCard {

    /*
     * SPECIALIZED VOCABULARY:
     * - Attribute (Field / State): A variable declared inside a class that
     *   stores data belonging to an object.
     * - String: Java data type used to store text.
     * - int: Java data type used to store whole numbers (integers).
     */
    String studentName;
    int studentId;

    /*
     * SPECIALIZED VOCABULARY:
     * - Constructor: A special block of code used to initialize (set up) an
     *   object when it is created.
     *
     * CONSTRUCTOR RULES:
     *   1. The constructor MUST have the exact same name as the class (StudentCard).
     *   2. It has NO return type (not even 'void').
     *   3. It runs automatically when the keyword 'new' is used.
     *
     * WHY USE A CONSTRUCTOR INSTEAD OF SETTING ATTRIBUTES MANUALLY?
     *   - Safety: It prevents "half-baked" objects (objects created with missing data).
     *   - Mandatory Checklist: It forces anyone creating an object to supply
     *     the required values upfront. If they don't, the code will NOT compile.
     */
    StudentCard(String givenName, int givenId) {
        // Step-by-step logic inside the constructor:
        // 1. Take the incoming parameter 'givenName' and store it in our attribute 'studentName'.
        studentName = givenName;

        // 2. Take the incoming parameter 'givenId' and store it in our attribute 'studentId'.
        studentId = givenId;
    }

    /*
     * SPECIALIZED VOCABULARY:
     * - Method: A function inside a class that represents an action or behavior.
     * - void: Means this method performs an action but does NOT return any value.
     */
    void printCardDetails() {
        System.out.println("----- STUDENT ID CARD -----");
        System.out.println("Owner : " + studentName);
        System.out.println("ID    : " + studentId);
        System.out.println("---------------------------");
    }
}

// -----------------------------------------------------------------------------
// PART 2: THE MAIN EXECUTION CLASS
// -----------------------------------------------------------------------------
public class LearnConstructor {

    /*
     * SPECIALIZED VOCABULARY:
     * - main method: The official starting point (entry gate) of any Java program.
     */
    public static void main(String[] args) {

        /*
         * STEP 1: Object Instantiation (Creation)
         * - 'StudentCard' -> The type of object we are creating.
         * - 'cardOne'     -> The variable name referring to our specific object.
         * - 'new'         -> Tells Java to allocate new memory for this object.
         * - 'StudentCard("Reza", 1001)' -> Calls the constructor and supplies
         *   the mandatory arguments.
         */
        StudentCard cardOne = new StudentCard("Reza", 1001);

        /*
         * STEP 2: Creating a second independent object.
         * Each object has its own separate memory space for its attributes.
         */
        StudentCard cardTwo = new StudentCard("Marco", 1002);

        /*
         * STEP 3: Calling Methods
         * We use the dot operator (.) to send commands to each object.
         */
        cardOne.printCardDetails();
        cardTwo.printCardDetails();

        /*
         * COMPILATION SAFETY TEST (Uncomment to test):
         * If you try to run the line below, Java will reject it with a red compile error
         * because the constructor demands 2 arguments (String, int):
         *
         * StudentCard brokenCard = new StudentCard(); // ERROR!
         */
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * ----- STUDENT ID CARD -----
 * Owner : Reza
 * ID    : 1001
 * ---------------------------
 * ----- STUDENT ID CARD -----
 * Owner : Marco
 * ID    : 1002
 * ---------------------------
 * ============================================================================= */