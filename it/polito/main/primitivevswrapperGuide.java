package it.polito.main;
import it.polito.model.PrimitiveVsWrapperDecisionGuide.*;
/**
 * Topic: Decision Framework - Primitive Types vs. Wrapper Classes (Slides 78-81)
 * Target Path: easyProject/src/it/polito/main/PrimitiveVsWrapperDecisionGuide.java
 * 
 * Course: Object-Oriented Programming - Politecnico di Torino
 */
// public class PrimitiveVsWrapperDecisionGuide {

//     // =========================================================================
//     // INNER DOMAIN MODEL: ExamResult Blueprint
//     // Demonstrates when attributes must be primitive vs. when they must be wrappers.
//     // =========================================================================
//     public static class ExamResult {
//         // ALWAYS PRIMITIVE: Student ID and course CFU credits always exist and cannot be null.
//         private final int studentId;
//         private final int credits;

//         // MUST BE WRAPPER: Grade can be unassigned (null) if the student hasn't taken the exam.
//         // A primitive 'int grade' would default to 0, which incorrectly indicates a failing mark!
//         private Integer finalGrade; 

//         public ExamResult(int studentId, int credits) {
//             this.studentId = studentId;
//             this.credits = credits;
//             this.finalGrade = null; // Explicitly missing / unrecorded
//         }

//         public void recordGrade(Integer grade) {
//             this.finalGrade = grade;
//         }

//         public boolean isExamTaken() {
//             return this.finalGrade != null;
//         }

//         public int getStudentId() {
//             return studentId;
//         }

//         public int getCredits() {
//             return credits;
//         }

//         public Integer getFinalGrade() {
//             return finalGrade;
//         }

//         public void printStatus() {
//             if (finalGrade == null) {
//                 System.out.println("Student " + studentId + " (Credits: " + credits + ") -> Status: NOT TAKEN YET");
//             } else {
//                 System.out.println("Student " + studentId + " (Credits: " + credits + ") -> Status: RECORDED GRADE = " + finalGrade);
//             }
//         }
//     }

    // =========================================================================
    // DRIVER HARNESS (main)
    // =========================================================================
public class primitivevswrapperGuide {
    public static void main(String[] args) {
        System.out.println("=== POLITO OOP: PRIMITIVE VS WRAPPER DECISION LAB ===\n");

        // ---------------------------------------------------------------------
        // CASE 1: The 'Missing Value' (Nullability) Problem
        // ---------------------------------------------------------------------
        System.out.println("--- Case 1: Why Wrappers Are Needed for Optional State ---");
        
        ExamResult examAlice = new ExamResult(320101, 6);
        ExamResult examBob = new ExamResult(320102, 6);

        // Bob took the exam and scored 0 (fail)
        examBob.recordGrade(Integer.valueOf(0));

        // Alice hasn't taken the exam yet (finalGrade remains null)
        examAlice.printStatus();
        examBob.printStatus();
        System.out.println();

        // ---------------------------------------------------------------------
        // CASE 2: Parsing User Input (String -> int vs. String -> Integer)
        // ---------------------------------------------------------------------
        System.out.println("--- Case 2: Parsing Scenarios (parseInt vs valueOf) ---");
        
        String inputGradeText = "28";
        String inputCfuText = "8";

        // SCENARIO 2A: We need raw math or calculation -> use Integer.parseInt()
        // Integer.parseInt produces a Stack-allocated primitive 'int' without Heap overhead.
        int parsedCfu = Integer.parseInt(inputCfuText);
        int totalHoursEstimate = parsedCfu * 25; // 1 CFU = 25 hours workload
        System.out.println("Workload for " + parsedCfu + " CFU: " + totalHoursEstimate + " hours (computed with primitive int)");

        // SCENARIO 2B: We need to pass an object or assign it to a wrapper field -> use Integer.valueOf()
        // Integer.valueOf parses text AND boxes it into an Integer reference.
        Integer parsedGradeObj = Integer.valueOf(inputGradeText);
        examAlice.recordGrade(parsedGradeObj);
        System.out.println("Alice's grade updated from parsed text: " + examAlice.getFinalGrade());
        System.out.println();

        // ---------------------------------------------------------------------
        // CASE 3: Performance & Loop Variables (Why Primitives Rule Computations)
        // ---------------------------------------------------------------------
        System.out.println("--- Case 3: Loop and Computation Rules ---");
        
        // RULE: NEVER use wrapper classes for loop indices or accumulators.
        // Primitives stay entirely in CPU registers/Stack memory.
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i; // Fast, direct primitive addition
        }
        System.out.println("Primitive calculation sum (1..5): " + sum);
        System.out.println();

        // ---------------------------------------------------------------------
        // CASE 4: The Fatal Unboxing Trap (NullPointerException)
        // ---------------------------------------------------------------------
        System.out.println("--- Case 4: The Unboxing Pitfall ---");
        
        ExamResult examCharlie = new ExamResult(320103, 10);
        // examCharlie.finalGrade is currently null.

        try {
            // DANGER: Calling intValue() on null (or letting Java auto-unbox it)
            // compiles cleanly, but crashes at runtime!
            Integer wrapperRef = examCharlie.getFinalGrade();
            
            // The line below attempts: int rawScore = wrapperRef.intValue();
            int rawScore = wrapperRef; // Automatic unboxing attempt on null!
            System.out.println("Score: " + rawScore);
        } catch (NullPointerException e) {
            System.out.println("CAUGHT EXCEPTION: Cannot unbox null into a primitive 'int'!");
            System.out.println("Lesson: Always check for null before converting a Wrapper to a primitive.");
        }
    }
}
/*
======================================================================
EXPECTED TERMINAL OUTPUT:
======================================================================
=== POLITO OOP: PRIMITIVE VS WRAPPER DECISION LAB ===

--- Case 1: Why Wrappers Are Needed for Optional State ---
Student 320101 (Credits: 6) -> Status: NOT TAKEN YET
Student 320102 (Credits: 6) -> Status: RECORDED GRADE = 0

--- Case 2: Parsing Scenarios (parseInt vs valueOf) ---
Workload for 8 CFU: 200 hours (computed with primitive int)
Alice's grade updated from parsed text: 28

--- Case 3: Loop and Computation Rules ---
Primitive calculation sum (1..5): 15

--- Case 4: The Unboxing Pitfall ---
CAUGHT EXCEPTION: Cannot unbox null into a primitive 'int'!
Lesson: Always check for null before converting a Wrapper to a primitive.
======================================================================
*/