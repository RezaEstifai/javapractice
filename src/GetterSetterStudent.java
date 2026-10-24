/* =============================================================================
 * TOPIC: Getters, Setters, and Object Association (image_d3c1e1.png)
 * FILE NAME: StudentExample.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// CLASS 1: THE STUDENT BLUEPRINT
// -----------------------------------------------------------------------------
class Student {
    // 1. ENCAPSULATION: All data is locked away (private)
    private String firstName;
    private String lastName;
    private int idNumber;

    // Constructor (Matches the slide's creation)
    public Student(String fName, String lName, int id) {
        this.firstName = fName;
        this.lastName = lName;
        this.idNumber = id;
    }

    /*
     * 2. GETTERS (Read Access)
     * Naming convention: get + VariableName (capitalized)
     * These allow outside files to read the private data securely.
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    /*
     * 3. READ-ONLY ATTRIBUTES (The Missing Setter Trick)
     * Notice we do NOT write a 'setIdNumber()' method. 
     * By omitting the setter, we guarantee that a student's ID can never 
     * be changed after the object is created. It is permanently read-only.
     */

    // Method to print the student's own data
    public void printData() {
        System.out.println("   [Student Data]: " + firstName + " " + lastName + " (ID: " + idNumber + ")");
    }
}

// -----------------------------------------------------------------------------
// CLASS 2: THE EXAM BLUEPRINT
// -----------------------------------------------------------------------------
class Exam {
    private int grade;
    
    // 4. OBJECT ASSOCIATION: An attribute can be another custom object!
    // This variable does not hold a number or text; it holds a whole Student.
    private Student enrolledStudent;

    // Constructor (Matches the slide's creation)
    public Exam(int startingGrade) {
        // We use our setter right inside the constructor to ensure even the 
        // starting data goes through our validation rules.
        setGrade(startingGrade);
    }

    /*
     * 5. SETTERS WITH VALIDATION
     * Setters are not just for assigning values. They are security guards.
     * Since university exams max out at 30, we block invalid numbers.
     */
    public void setGrade(int newGrade) {
        if (newGrade < 0 || newGrade > 30) {
            System.out.println("   [Error]: Grade must be between 0 and 30. Rejected.");
        } else {
            this.grade = newGrade;
        }
    }

    public int getGrade() {
        return grade;
    }

    /*
     * 6. PASSING OBJECTS VIA SETTERS
     * This is the exact method called in the slide: e.setStudent(s);
     * We receive the 's' remote control and store it in our 'enrolledStudent' variable.
     */
    public void setStudent(Student s) {
        this.enrolledStudent = s;
    }

    public Student getStudent() {
        return enrolledStudent;
    }

    // This method prints the exam's values, and then asks the student object 
    // to print its own data, exactly as the slide's comments describe.
    public void print() {
        System.out.println("\n--- EXAM REPORT ---");
        System.out.println("   [Exam Data]: Grade recorded is " + grade + "/30");
        
        // We must check if a student was actually assigned before asking them to print
        if (enrolledStudent != null) {
            enrolledStudent.printData(); // Calling a method on the linked object
        } else {
            System.out.println("   [Exam Data]: No student assigned to this exam yet.");
        }
        System.out.println("-------------------\n");
    }
}

// -----------------------------------------------------------------------------
// CLASS 3: MAIN EXECUTION (Matches slide image_d3c1e1.png exactly)
// -----------------------------------------------------------------------------
public class GetterSetterStudent {
    
    public static void main(String[] args) {
        
        // 1. Create the student
        Student s = new Student("Alice", "Green", 1234);
        
        // 2. Create the exam with a grade of 30
        Exam e = new Exam(30);

        // 3. Link the two objects together (Association)
        e.setStudent(s);

        // 4. Prints its values and asks students to print their data
        e.print();
        
        /* 
         * EXTRA TESTING (Not in the slide):
         * Let's test our validation and read-only rules!
         */
        System.out.println("--- TESTING GETTER/SETTER SECURITY ---");
        
        // Attempting to assign an impossible grade:
        e.setGrade(45); 
        
        // Verifying the invalid grade was blocked:
        System.out.println("   Current Grade remains: " + e.getGrade());
        
        // If we type s.setIdNumber(9999); -> Java throws an error because 
        // we intentionally didn't create a setter for it.
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- EXAM REPORT ---
 *    [Exam Data]: Grade recorded is 30/30
 *    [Student Data]: Alice Green (ID: 1234)
 * -------------------
 * 
 * --- TESTING GETTER/SETTER SECURITY ---
 *    [Error]: Grade must be between 0 and 30. Rejected.
 *    Current Grade remains: 30
 * ============================================================================= */