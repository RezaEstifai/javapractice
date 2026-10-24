package it.polito.main;

/* =============================================================================
 * TOPIC: Mutable vs. Immutable Objects (image_75dc05.png)
 * FILE NAME: LearnMutability.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: MUTABLE CLASS (Has Modifiers)
// -----------------------------------------------------------------------------
class MutableStudent {
    private String name;
    private int score;

    // Constructor initializes the object
    public MutableStudent(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // QUERY METHODS (Read-only)
    public String getName() { return name; }
    public int getScore() { return score; }

    /*
     * MODIFIER METHODS (Make the class MUTABLE)
     * These methods modify the internal status of the object after creation.
     */
    public void setScore(int newScore) {
        this.score = newScore;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}

// -----------------------------------------------------------------------------
// PART 2: IMMUTABLE CLASS (Only Queries, No Modifiers)
// -----------------------------------------------------------------------------
class ImmutableStudent {
    /*
     * 'final' keyword ensures that once the constructor assigns these variables,
     * Java physically locks them. They can never be reassigned.
     */
    private final String name;
    private final int studentId;

    // The Constructor: The ONLY moment the object's data is set
    public ImmutableStudent(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    /*
     * ONLY QUERY METHODS:
     * There are NO setters, NO modifiers, and NO methods returning void.
     * Anyone holding this object can only inspect it, never modify it.
     */
    public String getName() {
        return this.name;
    }

    public int getStudentId() {
        return this.studentId;
    }
}

// -----------------------------------------------------------------------------
// PART 3: MAIN EXECUTION DEMONSTRATING THE DIFFERENCE
// -----------------------------------------------------------------------------
public class LearnMutability {

    public static void main(String[] args) {

        /* =====================================================================
         * 1. TESTING THE MUTABLE OBJECT
         * ===================================================================== */
        System.out.println("--- 1. MUTABLE OBJECT IN ACTION ---");
        MutableStudent studentA = new MutableStudent("Marco", 22);
        System.out.println("Initial State -> Name: " + studentA.getName() + ", Score: " + studentA.getScore());

        // Modifiers change the object's internal state
        studentA.setScore(28);
        studentA.setName("Marco Rossi");
        System.out.println("Altered State -> Name: " + studentA.getName() + ", Score: " + studentA.getScore());
        System.out.println("Status changed successfully because the class is mutable.\n");


        /* =====================================================================
         * 2. TESTING THE IMMUTABLE OBJECT
         * ===================================================================== */
        System.out.println("--- 2. IMMUTABLE OBJECT IN ACTION ---");
        ImmutableStudent studentB = new ImmutableStudent("Reza", 5001);
        System.out.println("Frozen State  -> Name: " + studentB.getName() + ", ID: " + studentB.getStudentId());

        /*
         * WHY IT IS IMMUTABLE:
         * 1. There are NO setter methods available:
         *    studentB.setName("Reza E."); // COMPILE ERROR! No such method exists.
         *
         * 2. Direct attribute modification is blocked by private/final:
         *    studentB.studentId = 9999;   // COMPILE ERROR! Cannot access private final field.
         */
        System.out.println("No modifier methods exist. This object's data is permanently locked.");
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- 1. MUTABLE OBJECT IN ACTION ---
 * Initial State -> Name: Marco, Score: 22
 * Altered State -> Name: Marco Rossi, Score: 28
 * Status changed successfully because the class is mutable.
 * 
 * --- 2. IMMUTABLE OBJECT IN ACTION ---
 * Frozen State  -> Name: Reza, ID: 5001
 * No modifier methods exist. This object's data is permanently locked.
 * ============================================================================= */