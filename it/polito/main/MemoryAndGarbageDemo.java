package it.polito.main;

/**
 * ============================================================================
 * STUDY GUIDE: MEMORY ROOMS, VARIABLES, AND GARBAGE COLLECTION
 * ============================================================================
 * 
 * REVIEW 2 MONTHS FROM NOW:
 * - Stack (Orange Room): Stores local variables and parameters (temporary, dies when method ends).
 * - Heap (Purple Room): Stores objects created with 'new' (dynamic memory).
 * - Static (Green Room): Stores static variables and class definitions (lives forever)[cite: 9, 10, 11, 12].
 * - Garbage Collector: Automatically cleans up heap objects that have no references pointing to them[cite: 13, 14].
 * ============================================================================
 */
public class MemoryAndGarbageDemo {

    // ========================================================================
    // 1. STATIC VARIABLE (Stored in the Green Static Memory Room)
    // ========================================================================
    private static int totalItemsCreated = 0; 

    public static void main(String[] args) {
        System.out.println("=== STEP 1: CREATING AN OBJECT ===");
        
        // 'itemRef' is a local variable stored on the temporary STACK scratchpad[cite: 9, 10, 11, 12].
        // 'new ItemBox("Magic Box")' creates the actual object out in the purple HEAP warehouse[cite: 9, 10, 11, 12].
        // The '=' sign draws an arrow from 'itemRef' pointing to the object in the Heap.
        ItemBox itemRef = new ItemBox("Magic Box");

        // Using the object
        itemRef.displayInfo();


        System.out.println("\n=== STEP 2: DROPPING THE LEASH (NULLIFYING REFERENCE) ===");
        
        // By setting 'itemRef = null;', we cut the arrow/leash pointing to the Heap object.
        // Now, the "Magic Box" object in the Heap has NO active references pointing to it[cite: 13].
        // It becomes a "dead object" stranded in the warehouse, waiting for the Garbage Collector!
        itemRef = null;


        System.out.println("\n=== STEP 3: TRIGGERING THE GARBAGE COLLECTOR ===");
        
        // We suggest to the JVM: "Hey, can you run the Garbage Collector right now?"[cite: 13]
        // Note: Java is lazy and might ignore this, but it forces the GC to check for dead objects[cite: 13, 14].
        System.gc();

        // Giving the background garbage collector a brief moment to print out its finalizer message
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program finished!");
    }
}


/**
 * ============================================================================
 * HELPER CLASS: ItemBox
 * ============================================================================
 */
class ItemBox {

    // ========================================================================
    // 2. INSTANCE VARIABLE / FIELD (Stored inside the object in the Heap)[cite: 12]
    // ========================================================================
    private String boxName;

    // Constructor (Receives a local parameter 'name' from the Stack)[cite: 9, 12]
    public ItemBox(String name) {
        this.boxName = name;
        System.out.println("[Heap] ItemBox object created with name: " + this.boxName);
    }

    public void displayInfo() {
        System.out.println("Displaying box name: " + this.boxName);
    }

    // ========================================================================
    // 3. OBJECT DESTRUCTION & FINALIZE (Garbage Collector Hook)
    // ========================================================================
    // This special method runs automatically right before the Garbage Collector 
    // destroys and deletes the object from the Heap warehouse.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("[Garbage Collector] finalize() called! Object '" + this.boxName + "' is being wiped from memory.");
        
        // Always call super.finalize() as good practice
        super.finalize();
    }
}