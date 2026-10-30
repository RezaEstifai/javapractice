package it.polito.model;

/**
 * ============================================================================
 * MODEL FILE: NestedInnerDiff.java
 * ============================================================================
 * POLITO EXAM STUDY GUIDE: All 4 Nested Class Types in One Place
 * 
 * REVIEW 2 MONTHS FROM NOW:
 * - Static Nested: Has 'static'. Independent. Cannot touch parent's non-static fields.
 * - Non-Static Inner: NO 'static'. Dependent. Has a secret link to parent object (`this`).
 * - Local Inner: Created INSIDE a method block `{}`. Can use final/effective-final local variables.
 * - Anonymous Inner: Has NO NAME. Built and used in a single line on-the-fly.
 * ============================================================================
 */
public class NestedInnerDiff {

    // Parent data fields
    private String carBrand = "Ferrari";       // Non-static field (belongs to an object instance)
    private static int factoryId = 99;         // Static field (belongs to the class itself)


    // ========================================================================
    // TYPE 1: STATIC NESTED CLASS
    // ========================================================================
    // MENTALITY: The independent wall clock. Doesn't care about a specific car object.
    public static class StaticNestedClass {
        public void testRules() {
            // ❌ COMPILE ERROR TRAP: 
            // System.out.println(carBrand); 
            // REASON: No parent object reference exists! Java doesn't know *which* car's brand you want.

            // ✅ WORKS: Can read and change parent's STATIC fields (even if private!)
            System.out.println("[1. Static Nested] Factory ID (static): " + factoryId);
            factoryId = 100;
        }
    }


    // ========================================================================
    // TYPE 2: NON-STATIC INNER CLASS (Non-Static Nested Class)
    // ========================================================================
    // MENTALITY: The room key / worker. Permanently tethered to a specific car object.
    public class NonStaticInnerClass {
        public void testRules() {
            // ✅ WORKS: Can read parent's NON-STATIC field directly because of the secret link!
            System.out.println("[2. Non-Static Inner] Car Brand (non-static): " + carBrand);

            // ✅ WORKS: Can also change the parent's non-static field directly!
            carBrand = "Lamborghini";
            System.out.println("[2. Non-Static Inner] Changed brand to: " + carBrand);

            // ✅ WORKS: Can also access static fields of the parent!
            System.out.println("[2. Non-Static Inner] Factory ID: " + factoryId);
        }
    }


    // ========================================================================
    // TYPE 3: LOCAL INNER CLASS (Defined inside a method)
    // ========================================================================
    // MENTALITY: A temporary helper class created inside a method's `{}` braces.
    public void runLocalInnerDemo(int taxRate) { // 'taxRate' is a local method variable
        
        // This class ONLY exists inside this method. You cannot use it outside!
        class LocalHelper {
            public void displayTax() {
                // ✅ WORKS: Can use local variables from the method (must be final or effective-final)
                System.out.println("[3. Local Inner Class] Calculating tax rate: " + taxRate + "%");
                // Also has access to outer non-static fields:
                System.out.println("[3. Local Inner Class] For car brand: " + carBrand);
            }
        }

        // You create and use the local inner class right here inside the method:
        LocalHelper helper = new LocalHelper();
        helper.displayTax();
    }


    // ========================================================================
    // TYPE 4: ANONYMOUS INNER CLASS (A nameless quick class)
    // ========================================================================
    // MENTALITY: A quick one-time-use class when you don't even want to bother naming it.
    public void runAnonymousInnerDemo() {
        // We create an object of an interface (Runnable) on the fly without naming the class:
        Runnable anonymousWorker = new Runnable() {
            @Override
            public void run() {
                System.out.println("[4. Anonymous Inner Class] Running anonymously for brand: " + carBrand);
            }
        };

        anonymousWorker.run();
    }
}