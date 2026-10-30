package it.polito.main;
/**
 * ============================================================================
 * BEGINNER'S GUIDE: NESTED CLASSES IN JAVA (Static vs. Non-Static Inner)
 * ============================================================================
 * 
 * CORE RULE TO REMEMBER:
 * 1. Static Nested Class   -> Independent helper. No secret link to parent.
 * 2. Non-Static Inner Class -> Dependent helper. Has a secret link to parent object.
 * ============================================================================
 */
public class NestedClassesBeginner {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("PART 1: BASIC SYNTAX & CREATION RULES");
        System.out.println("========================================");
        
        // --- SECTION A: STATIC NESTED CLASS CREATION ---
        // TRAP NOTE: Notice you do NOT need to create an Outer object first!
        // Syntax: OuterClass.StaticNestedClass objName = new OuterClass.StaticNestedClass();
        Outer.Nested myHelper = new Outer.Nested();
        myHelper.sayHello();


        // --- SECTION B: NON-STATIC INNER CLASS CREATION ---
        // TRAP NOTE: You MUST create the Parent/Outer object first!
        // Syntax: OuterClass outerObj = new OuterClass();
        //         OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        BuildingWithAccessRules parentBuilding = new BuildingWithAccessRules();
        BuildingWithAccessRules.Keycard myKey = parentBuilding.new Keycard();
        myKey.testAccessToParentFields();


        System.out.println("\n========================================");
        System.out.println("PART 2: ACCESS RULES (WHAT WORKS & FAILS)");
        System.out.println("========================================");
        
        // Testing Static Nested Access Rules
        BuildingWithAccessRules.Clock.testStaticNestedAccess();


        System.out.println("\n========================================");
        System.out.println("PART 3: PRACTICAL REAL-WORLD EXAMPLES");
        System.out.println("========================================");

        // --- EXAMPLE 1: Non-Static Inner Class (Car & Engine) ---
        // The Engine needs to read the specific Car's fuel level ("this.something").
        Car myCar = new Car();
        Car.Engine myEngine = myCar.new Engine();
        myEngine.start(); // Will check myCar's fuel level (50)


        // --- EXAMPLE 2: Static Nested Class (Car & WheelCalculator) ---
        // The calculator is a pure math utility tool. It doesn't care about a car's fuel.
        // Because both the class AND the method are static, NO "new" is needed at all!
        double pressure = Car.WheelCalculator.calculatePressure(1200.0, 25.0);
        System.out.println("[WheelCalculator] Calculated tire pressure: " + pressure);
    }
}


/**
 * ============================================================================
 * SECTION 1: Basic Structure of a Static Nested Class
 * ============================================================================
 */
class Outer {
    // Namespace clean-up: 'Nested' lives safely inside 'Outer' (Fully qualified: Outer.Nested)
    static class Nested {
        public void sayHello() {
            System.out.println("[Outer.Nested] Hello from a basic static nested class!");
        }
    }
}


/**
 * ============================================================================
 * SECTION 2: Data Structure Example (Classic Stack & Element Pattern)
 * ============================================================================
 */
class StackOfInt {

    // PRIVATE STATIC NESTED CLASS:
    // Perfect use case: 'Element' is a pure node helper used only inside StackOfInt.
    // It is private so outside classes can't see it (Encapsulation).
    private static class Element {
        int value;
        Element next;
    }

    private Element head; // Points to the top of the stack

    public void push(int v) {
        // Implementation logic for pushing to stack
    }
    
    // EXAM NOTE: Ensure methods have valid return types (e.g., 'public int pop()' or 'public void pop()').
    public int pop() {
        return 0; // Implementation logic for popping from stack
    }
}


/**
 * ============================================================================
 * SECTION 3: The Access Rules Master Test (Building Example)
 * ============================================================================
 */
class BuildingWithAccessRules {

    // Parent variables
    private String buildingName = "Torre Milano"; // NON-STATIC field (belongs to an object instance)
    private static int totalBuildings = 5;      // STATIC field (belongs to the class itself)

    // ------------------------------------------------------------------------
    // TYPE 1: STATIC NESTED CLASS ACCESS RULES
    // ------------------------------------------------------------------------
    public static class Clock {

        public static void testStaticNestedAccess() {
            // ❌ COMPILE ERROR TRAP:
            // System.out.println(buildingName); 
            // REASON: Java blocks this because a static class has NO link to a parent object instance.
            // It doesn't know *which* building's name you want!

            // ✅ WORKS: Can read parent's STATIC field (even if private!)
            System.out.println("[Static Nested Clock] Total buildings count: " + totalBuildings); 

            // ✅ WORKS: Can change parent's STATIC field!
            totalBuildings = 6; 
            System.out.println("[Static Nested Clock] Updated static total: " + totalBuildings);
        }
    }

    // ------------------------------------------------------------------------
    // TYPE 2: NON-STATIC INNER CLASS ACCESS RULES
    // ------------------------------------------------------------------------
    public class Keycard {

        public void testAccessToParentFields() {
            // ✅ WORKS: Can READ parent's NON-STATIC field (even if private!) because it has a secret link.
            System.out.println("[Non-Static Keycard] Unlocking building: " + buildingName); 

            // ✅ WORKS: Can CHANGE parent's NON-STATIC field directly!
            buildingName = "Palazzo Reale"; 
            System.out.println("[Non-Static Keycard] Successfully renamed parent building to: " + buildingName);

            // ✅ WORKS: Can also read and change static fields of the parent!
            System.out.println("[Non-Static Keycard] Parent static total: " + totalBuildings);
            totalBuildings = 10;
        }
    }
}


/**
 * ============================================================================
 * SECTION 4: Practical Scenario A — Non-Static Inner Class (`Car` & `Engine`)
 * ============================================================================
 */
class Car {
    private int fuelLevel = 50; // Belongs to a specific Car object

    // NON-STATIC INNER CLASS:
    // Why non-static? Because the Engine must reach inside the specific Car object 
    // to check its personal 'fuelLevel' ("this.fuelLevel" or "Car.this.fuelLevel").
    public class Engine {
        public void start() {
            if (fuelLevel > 0) {  
                System.out.println("[Car.Engine] Vroom! Engine started successfully. Current Fuel: " + fuelLevel);
            } else {
                System.out.println("[Car.Engine] Out of fuel! Cannot start.");
            }
        }
    }
    public static class WheelCalculator {
        
        // Notice this method is ALSO static! 
        // Because the class and method are both static, you never need "new Car()" or "new WheelCalculator()".
        public static double calculatePressure(double weight, double temperature) {
            return (weight * 0.05) + (temperature * 0.2);
        }
    }
}


/**
 * ============================================================================
 * SECTION 5: Practical Scenario B — Static Nested Class (`Car` & `WheelCalculator`)
 * ============================================================================
 */

//* MAKING A DIFFERENT CLASS OUTSIDE THE OUTER CLASS MAKES UNREADABLE FOR OTHERS */
// class CarStaticsTest {
//     private int fuelLevel = 50; 

//     // STATIC NESTED CLASS:
//     // Why static? Because it is a utility math tool. It does NOT touch any personal 
//     // instance variables (`fuelLevel`) of the Car object. It only uses parameters passed into it.
//     public static class WheelCalculator {
        
//         // Notice this method is ALSO static! 
//         // Because the class and method are both static, you never need "new Car()" or "new WheelCalculator()".
//         public static double calculatePressure(double weight, double temperature) {
//             return (weight * 0.05) + (temperature * 0.2);
//         }
//     }
