package it.polito.model;

/**
 * Topic: Private vs. Package Attributes with Getters/Setters (Slides 53, 54, 76)
 * Target Path: easyProject/src/it/polito/model/Course.java
 */
public class PrivatePublic {

    // -------------------------------------------------------------------------
    // 1. PRIVATE ATTRIBUTE (Used for 99% of fields)
    // Only code inside this Course class can touch this variable directly.
    // -------------------------------------------------------------------------
    private int studentCount;

    // -------------------------------------------------------------------------
    // 2. PACKAGE ATTRIBUTE (No modifier)
    // Only code inside files in 'package it.polito.model' can touch this directly.
    // -------------------------------------------------------------------------
    int credits;

    // -------------------------------------------------------------------------
    // 3. PUBLIC ATTRIBUTE (Discouraged for mutable state)
    // Anyone in any package can touch and alter this directly.
    // -------------------------------------------------------------------------
    public int courseId;

    public PrivatePublic(int initialStudents, int initialCredits, int initialCourseId) {
        this.studentCount = initialStudents;
        this.credits = initialCredits;
        this.courseId = initialCourseId;
    }

    // =========================================================================
    // PUBLIC GETTERS & SETTERS FOR THE PRIVATE ATTRIBUTE (studentCount)
    // =========================================================================

    // Public Getter: Lets any outside folder READ the private studentCount safely.
    public int getStudentCount() {
        return this.studentCount;
    }

    // Public Setter: Lets outside folders CHANGE studentCount, BUT with validation rules!
    public void setStudentCount(int count) {
        if (count < 0) {
            System.out.println("[REJECTED] Student count cannot be negative: " + count);
        } else {
            this.studentCount = count;
        }
    }

    // =========================================================================
    // PUBLIC GETTERS & SETTERS FOR THE PACKAGE ATTRIBUTE (credits)
    // Even though 'credits' cannot be accessed directly outside it.polito.model,
    // these public methods allow outside folders to read and write to it.
    // =========================================================================

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            System.out.println("[REJECTED] Credits must be positive: " + credits);
        } else {
            this.credits = credits;
        }
    }
}