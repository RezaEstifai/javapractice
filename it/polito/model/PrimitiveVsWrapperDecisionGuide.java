package it.polito.model;

public class PrimitiveVsWrapperDecisionGuide {

    // =========================================================================
    // INNER DOMAIN MODEL: ExamResult Blueprint
    // Demonstrates when attributes must be primitive vs. when they must be wrappers.
    // =========================================================================
    public static class ExamResult {
        // ALWAYS PRIMITIVE: Student ID and course CFU credits always exist and cannot be null.
        private final int studentId;
        private final int credits;

        // MUST BE WRAPPER: Grade can be unassigned (null) if the student hasn't taken the exam.
        // A primitive 'int grade' would default to 0, which incorrectly indicates a failing mark!
        private Integer finalGrade; 

        public ExamResult(int studentId, int credits) {
            this.studentId = studentId;
            this.credits = credits;
            this.finalGrade = null; // Explicitly missing / unrecorded
        }

        public void recordGrade(Integer grade) {
            this.finalGrade = grade;
        }

        public boolean isExamTaken() {
            return this.finalGrade != null;
        }

        public int getStudentId() {
            return studentId;
        }

        public int getCredits() {
            return credits;
        }

        public Integer getFinalGrade() {
            return finalGrade;
        }

        public void printStatus() {
            if (finalGrade == null) {
                System.out.println("Student " + studentId + " (Credits: " + credits + ") -> Status: NOT TAKEN YET");
            } else {
                System.out.println("Student " + studentId + " (Credits: " + credits + ") -> Status: RECORDED GRADE = " + finalGrade);
            }
        }
    }
}