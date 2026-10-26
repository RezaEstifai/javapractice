package it.polito.main;

class StudentManager {
    // 1. INSTANCE VARIABLES (Belong to a specific created object)
    public String name;           // Visible everywhere
    private int secretId;         // Locked strictly inside StudentManager
    protected double gpa;         // Visible to any classes in the same folder like main + any subclasses
    int age;                      // Default (package-private): Visible only in this package

    // 2. STATIC VARIABLES (Belong to the Class itself, shared by ALL objects)
    public static String universityName = "Global Tech"; 
    private static String adminPassword = "SuperSecret!";
    public static int totalStudentsCreated = 0;

    // 3. FINAL VARIABLES (Constants: once set, cannot be changed)
    public final int maxCredits = 21; 
    public static final double PASSING_GRADE = 50.0; 

    // 4. CONSTRUCTOR (How we create the object)
    public StudentManager(String name, int secretId) {
        this.name = name;
        this.secretId = secretId;
        this.age = 18; // default age
        this.gpa = 3.5;
        // STATIC VARIABLE UPDATE: We use "ClassName."
        // We do NOT use "this.totalStudentsCreated" because this variable doesn't 
        // belong to a single student; it belongs to the whole class.
        StudentManager.totalStudentsCreated = StudentManager.totalStudentsCreated + 1;
    }

    // 5. INSTANCE METHODS (Require an object to be called, can access both static & instance data)
    public void study() {
        System.out.println(name + " is studying at " + universityName); // Works!
    }

    private void changeGrades() {
        System.out.println("This is private, no one outside can trigger this.");
    }

    // 6. STATIC METHODS (Called on the Class directly, cannot use "this" or instance variables)
    public static void announceEvent() {
        System.out.println("Hackathon tomorrow at " + universityName); // Works!
        
        // System.out.println(name); // ERROR! Static methods cannot see instance variables.
        // study();                  // ERROR! Static methods cannot call instance methods directly.
    }
}

public class StaticAll {
    public static void main(String[] args) {
        // ==========================================
        // 1. WORKING WITH STATIC (Class-Level)
        // ==========================================
        // You call static fields/methods using the Class Name. No "new" object needed.
        
        System.out.println(StudentManager.universityName); // Works!
        StudentManager.announceEvent();                    // Works!
        
        // System.out.println(StudentManager.adminPassword); // ERROR! It is private.
        // StudentManager.study();                           // ERROR! study() needs a created object.


        // ==========================================
        // 2. WORKING WITH INSTANCE (Object-Level)
        // ==========================================
        // You must build the object first using "new".
        
        StudentManager alice = new StudentManager("Alice", 90210);
        StudentManager bob = new StudentManager("Bob", 80101);

        alice.study(); // Works!
        bob.study();   // Works!

        // Checking Access Modifiers on instance variables:
        System.out.println(alice.name); // Works! (public)
        System.out.println(alice.age);  // Works! (default/package-private: MainApp is in the same package)
        System.out.println(alice.gpa);  // Works! (protected: MainApp is in the same package)
        
        // System.out.println(alice.secretId); // ERROR! secretId is private to StudentManager.
        // alice.changeGrades();               // ERROR! changeGrades() is a private method.


        // ==========================================
        // 3. WORKING WITH FINAL (Constants)
        // ==========================================
        // You can read final variables, but you cannot overwrite them.
        
        System.out.println(alice.maxCredits);            // Works! Reading is fine.
        System.out.println(StudentManager.PASSING_GRADE);// Works! Reading static final is fine.
        
        // alice.maxCredits = 25;                   // ERROR! maxCredits is final.
        // StudentManager.PASSING_GRADE = 40.0;     // ERROR! PASSING_GRADE is final.


        // ==========================================
        // 4. STATIC VS INSTANCE SHARING BEHAVIOR
        // ==========================================
        // If you change a static variable, it changes for EVERY object instantly.
        
        StudentManager.universityName = "New Tech University";
        
        // Even though we use the objects below (which is valid but considered bad practice), 
        // they both output the newly changed static variable.
        System.out.println(alice.universityName); // Works! Prints "New Tech University"
        System.out.println(bob.universityName);   // Works! Prints "New Tech University"



        // 1. DEMONSTRATING "ClassName." vs "this."
        System.out.println("Students before: " + StudentManager.totalStudentsCreated); // Works! Prints 0
        // We check the shared static variable using the ClassName
        System.out.println("Students after: " + StudentManager.totalStudentsCreated); // Works! Prints 2
    }
}
// * Look at something() inside ClassA. Is it private?

// - Yes: Stop! You cannot call it directly from outside ClassA. Look for a public getter/helper method instead.

// * Are you in a different folder (package)?

//  - Yes: Did you write import folder.ClassA; at the top? And is something() marked public (or protected if you used extends)? If it has no keyword, you cannot call it.

// * Does something() have the word static in its declaration?

// - Yes (static): Do NOT create an object. Just write:ClassA.something();

// - No (No static): You MUST create an object first, then call it on the object:ClassA obj = new ClassA();obj.something(); 


// * Does the method use `this.variableName` or any non-static field of the class?**

// - Yes: It **must be non-static

// - No: Go to step 2.

// * Is it a model class representing an entity in your system (e.g., `User`, `Booking`, `Order`, `Flight`)

// - Almost all methods in model classes (getters, setters, state transitions) are **non-static** because they describe what that entity has or does.

// * Is it a helper, a mathematical formula, a parser, or a global counter?

// - Examples: `Math.max(a, b)`, `Integer.parseInt(str)`, `FileHelper.readFile(path)`, `DatabaseConnection.getConnection()`.

// - These are tools that don't need persistent personal memory $\rightarrow$ **make them `static`.
