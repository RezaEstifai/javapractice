package it.polito.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Model class used in For-Each Case D
class ClassroomStudent {
    private String name;
    private boolean enrolled;

    public ClassroomStudent(String name, boolean enrolled) {
        this.name = name;
        this.enrolled = enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    @Override
    public String toString() {
        return name + " (Enrolled: " + enrolled + ")";
    }
}

public class AllCasesLoop {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("PART 1: THE 4 FOR-EACH CASES: for (Type x : arr)");
        System.out.println("==================================================");

        // -----------------------------------------------------------------
        // CASE A: Aggregation and Math (Sum & Average)
        // Reason: We only read values to produce a single aggregated scalar.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case A: Math Aggregation (Sum & Average) ---");
        int[] scoresA = {18, 24, 30, 28, 20};
        int sum = 0;
        for (int score : scoresA) {
            sum += score; // Read-only accumulation
        }
        double average = (double) sum / scoresA.length; //* (double) converts sum from int to double before division */
        System.out.println("Sum: " + sum + " | Average: " + average);


        // -----------------------------------------------------------------
        // CASE B: Searching / Existence Check (Early Exit)
        // Reason: Answering a boolean question; no need to track index.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case B: Existence / Validation Check ---");
        int[] sensorReadings = {12, 19, -5, 23, 14};
        boolean hasNegative = false;
        for (int reading : sensorReadings) {
            if (reading < 0) {
                hasNegative = true;
                break; // Stop immediately once condition is satisfied
            }
        }
        System.out.println("Contains invalid negative reading: " + hasNegative);


        // -----------------------------------------------------------------
        // CASE C: Printing / Inspecting Elements
        // Reason: Displaying values safely without bounds-checking risks.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case C: Inspecting & Formatting ---");
        String[] cities = {"Turin", "Milan", "Rome", "Venice"};
        System.out.print("Cities list: ");
        for (String city : cities) {
            System.out.print("[" + city.toUpperCase() + "] ");
        }
        System.out.println();


        // -----------------------------------------------------------------
        // CASE D: Mutating Object State (Calling Setters)
        // Reason: Even though array slots cannot be replaced, the heap
        //         objects referenced by them CAN be mutated via setters.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case D: Mutating Internal Object State ---");
        ClassroomStudent[] classroom = {
            new ClassroomStudent("Reza", false),
            new ClassroomStudent("Marco", false),
            new ClassroomStudent("Elena", false)
        };

        System.out.println("Before update: " + Arrays.toString(classroom));
        for (ClassroomStudent s : classroom) {
            s.setEnrolled(true); // * even though we taught that this kind of loop doesn't change the value, but here it changes setEnrolled to true because we are changing the value of the object that is referenced by the array slot, not the reference itself */
        }
        System.out.println("After update:  " + Arrays.toString(classroom));



        System.out.println("\n==================================================");
        System.out.println("PART 2: THE 4 INDEXED CASES: for (int i = 0; ...)");
        System.out.println("==================================================");

        // -----------------------------------------------------------------
        // CASE A: Modifying Primitive Slots In-Place
        // Reason: Overwrites memory cells on the heap; For-each fails here.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case A: In-Place Modification ---");
        int[] marks = {18, 22, 27, 25};
        System.out.println("Before curve: " + Arrays.toString(marks));
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 3; // Direct write to heap slot i
        }
        System.out.println("After +3 curve: " + Arrays.toString(marks));


        // -----------------------------------------------------------------
        // CASE B: Retrieving the Exact Index Position
        // Reason: The required output is the position number, not just the value.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case B: Finding Target Index Position ---");
        String[] courseCodes = {"01TXYOV", "02GHOOV", "01NYHOV", "04ABCDE"};
        String targetCourse = "01NYHOV";
        int foundIndex = -1;

        for (int i = 0; i < courseCodes.length; i++) {
            if (courseCodes[i].equals(targetCourse)) {
                foundIndex = i; // Save the exact slot coordinate
                break;
            }
        }
        System.out.println("Course " + targetCourse + " found at index: " + foundIndex);


        // -----------------------------------------------------------------
        // CASE C: Reverse Traversal or Non-Standard Steps
        // Reason: For-each only walks 0 -> (n-1). Custom steps need counter control.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case C: Stepping Backwards ---");
        char[] letters = {'P', 'O', 'L', 'I', 'T', 'O'};
        System.out.print("Reversed letters: ");
        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i] + " ");
        }
        System.out.println();


        // -----------------------------------------------------------------
        // CASE D: Parallel Arrays (Synchronized Multi-Array Traversal)
        // Reason: One loop counter coordinates multiple independent arrays.
        // -----------------------------------------------------------------
        System.out.println("\n--- Case D: Parallel Synchronized Arrays ---");
        String[] studentNames = {"Reza", "Marco", "Elena"};
        int[] studentMarks    = {30, 28, 27};

        for (int i = 0; i < studentNames.length; i++) {
            // Index 'i' binds the two arrays together row-by-row
            System.out.printf("Row %d: Student %-6s received grade %d%n", i, studentNames[i], studentMarks[i]);
        }
    }
}