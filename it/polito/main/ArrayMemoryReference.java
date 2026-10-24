package it.polito.main;

import java.util.Arrays;

// A simple model class representing a Person entity (Slide 89 & 91)
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person(\"" + name + "\")";
    }
}

public class ArrayMemoryReference {

    public static void main(String[] args) {

        // =========================================================================
        // SLIDE 88 & 90: PRIMITIVE ARRAYS IN MEMORY
        // =========================================================================
        System.out.println("=== PART 1: PRIMITIVE ARRAYS (SLIDE 88 & 90) ===");

        // Step 1: Declaration (Slide 88)
        // - 'a' is a reference variable on the stack.
        // - Currently points to nothing (null). No heap allocation yet.
        int[] a = null;
        System.out.println("Declared 'a': " + a);

        // Step 2: Instantiation with 'new' (Slide 90, middle diagram)
        // - 'new int[6]' allocates 6 contiguous primitive int cells on the HEAP.
        // - Java automatically defaults primitive integers to 0.
        // - Variable 'a' now holds the memory reference (address) of this heap block.
        a = new int[6];
        System.out.println("Allocated 'a' with default 0s: " + Arrays.toString(a));

        // Step 3: Modifying primitive slot values directly
        a[0] = 42;
        a[5] = 99;
        System.out.println("Updated 'a': " + Arrays.toString(a));

        // Step 4: Static Initialization (Slide 89 & 90, bottom diagram)
        // - Compiles into immediate allocation and value population on the heap.
        int[] primes = {2, 3, 5, 7, 11, 13};
        System.out.println("Primes array: " + Arrays.toString(primes));
        System.out.println();


        // =========================================================================
        // SLIDE 89 & 91: OBJECT REFERENCE ARRAYS (THE "NULL" TRAP)
        // =========================================================================
        System.out.println("=== PART 2: ARRAYS OF OBJECT REFERENCES (SLIDE 91) ===");

        // Step 5: Allocating an array of References (Slide 91, top diagram)
        // - Allocates an array of 6 slots on the heap.
        // - BUT notice: It does NOT create 6 String objects!
        // - All 6 slots are initialized to 'null' (empty sticky notes).
        String[] s = new String[6];
        System.out.println("s after 'new String[6]': " + Arrays.toString(s));

        // Step 6: Populating slot index 1 (Slide 91, middle diagram)
        // - 'new String("abcd")' creates the actual String object on the heap.
        // - s[1] stores the REFERENCE (memory pointer) to that object.
        s[1] = new String("abcd");
        s[2] = "djaisnd";
        System.out.println("s after assigning s[1]:  " + Arrays.toString(s));
        // CRITICAL EXAM TRAP: Calling methods on an uninitialized slot!
        try {
            // s[0] is null! Trying to call .length() will crash the program.
            int len = s[0].length(); 
            IO.println("Length of s[0]: " + len);
        } catch (NullPointerException e) {
            System.out.println("-> CAUGHT NULLPOINTEREXCEPTION: s[0] is null! No object exists there. SO WE CANNOT CALL .length() ON IT!");
        }
        System.out.println();

        // =========================================================================
        // CUSTOM OBJECTS & SHARED REFERENCES (Slide 89 & 91, bottom diagram)
        // =========================================================================
        System.out.println("=== PART 3: PERSON[] AND ALIASING / SHARED REFERENCES ===");

        // Step 7: Static initialization of custom objects
        // - Creates an array of 2 reference slots on the heap.
        // - slot 0 points to Person("John")
        // - slot 1 points to Person("Susan")
        Person[] p = { new Person("John"), new Person("Susan") };
        System.out.println("Initial Person array: " + Arrays.toString(p)); // * even though getName is not called but it still prints the name of the person because of the toString method */

        // Step 8: Aliasing / Shared Reference Demonstration
        // - We create a new reference variable 'friend' and point it to the SAME house as p[0].
        Person friend = p[0]; // Both 'friend' and 'p[0]' hold the address of "John"

        System.out.println("friend's name: " + friend.getName()); // *‌ friend itself is a reference to "john" so for getting name we must. use getName method
             
        // Step 9: Mutating the object through the 'friend' reference
        friend.setName("Jonathan"); // Renaming the person inside the house

        // Notice: What happened to p[0]?
        // Because p[0] points to the SAME object in memory, p[0] sees the change!
        System.out.println("p[0] after modifying 'friend': " + p[0].getName());
        System.out.println("Final Person array: " + Arrays.toString(p));
    }
}