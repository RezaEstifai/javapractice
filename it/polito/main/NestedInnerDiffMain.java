package it.polito.main;
import it.polito.model.NestedInnerDiff;
/**
 * ============================================================================
 * MAIN RUNNER FILE: NestedInnerDiffMain.java
 * ============================================================================
 * Demonstrates the declaration, creation, and usage of all 4 nested class types.
 * 
 * REVIEW 2 MONTHS FROM NOW (CREATION TRAPS):
 * - Static Nested:     Outer.StaticNested obj = new Outer.StaticNested(); (No parent 'new' needed!)
 * - Non-Static Inner:  Outer outerObj = new Outer();
 *                      Outer.NonStaticInner obj = outerObj.new NonStaticInner(); (Parent 'new' REQUIRED!)
 * - Local Inner:       Instantiated inside the outer method itself.
 * - Anonymous Inner:   Instantiated on-the-fly using `new InterfaceName() { ... }`.
 * ============================================================================
 */
public class NestedInnerDiffMain {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("TESTING TYPE 1: STATIC NESTED CLASS");
        System.out.println("==================================================");
        // CREATION TRAP: Notice NO parent object is created on the right side!
        NestedInnerDiff.StaticNestedClass staticObj = new NestedInnerDiff.StaticNestedClass();
        staticObj.testRules();


        System.out.println("\n==================================================");
        System.out.println("TESTING TYPE 2: NON-STATIC INNER CLASS");
        System.out.println("==================================================");
        // STEP A: You MUST create the parent object first!
        NestedInnerDiff parentCar = new NestedInnerDiff();

        // STEP B: Create the inner class object using the parent variable (weird syntax!)
        NestedInnerDiff.NonStaticInnerClass nonStaticObj = parentCar.new NonStaticInnerClass();
        nonStaticObj.testRules();


        System.out.println("\n==================================================");
        System.out.println("TESTING TYPE 3: LOCAL INNER CLASS");
        System.out.println("==================================================");
        // Local classes are triggered by calling the outer method that contains them:
        parentCar.runLocalInnerDemo(22); // Passes 22 as taxRate


        System.out.println("\n==================================================");
        System.out.println("TESTING TYPE 4: ANONYMOUS INNER CLASS");
        System.out.println("==================================================");
        // Anonymous classes are triggered by calling the outer method that builds them:
        parentCar.runAnonymousInnerDemo();
    }
}