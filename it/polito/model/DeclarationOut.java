package it.polito.model;
import it.polito.main.Declaration;
public class DeclarationOut extends Declaration {

    public void testMethodsInsideChild() {
        // Inside a non-static method of a Child class, you ALREADY are a Student!
        // So you can call inherited methods directly without even writing "new":
            
        pubNormal();   // ✅ WORKS! (Public is open to everyone)
        protNormal();  // ✅ WORKS! (Because we used "extends Student", protected unlocks!)
            /* 
            defNormal();   // ❌ ERROR! Even for a child class, "no-keyword" is trapped in the "university" folder!
            privNormal();  // ❌ ERROR! Private is NEVER inherited by children!
            */

    }
    public static void main(String[] args) {

        // -----------------------------------------------------
        // ATTEMPT 1: Calling by Class Name alone ("Student.")
        // -----------------------------------------------------
        Declaration.pubStatic();   // ✅ WORKS! (It is public AND static!)
        /* 
        Declaration.protStatic();  // ❌ ERROR! Protected blocks strangers in other folders!
        Declaration.defStatic();   // ❌ ERROR! No-keyword blocks other folders!
        Declaration.privStatic();  // ❌ ERROR! Private blocks everyone!
        Declaration.pubNormal();   // ❌ ERROR! Not static! (Needs "new Declaration()")
        */

        // -----------------------------------------------------
        // ATTEMPT 2: Calling by creating an Object ("new Student()")
        // -----------------------------------------------------
        Declaration s = new Declaration();

        s.pubNormal();   // ✅ WORKS! (It is public AND we created an object!)
        /* 
        s.protNormal();  // ❌ ERROR! Protected blocks strangers in other folders!
        s.defNormal();   // ❌ ERROR! No-keyword blocks other folders!
        s.privNormal();  // ❌ ERROR! Private blocks everyone!
        */

        //* CHILD */
        // Calling static methods of parent from child in another folder:
        Declaration.pubStatic();   // ✅ WORKS!
        Declaration.protStatic();  // ✅ WORKS! (Unlocked because GradStudent extends Declaration!) //* BUT INSIDE THE EXTEND CLASS */

        /*
        Declaration.defStatic();   // ❌ ERROR! Trapped in "university" folder!
        Declaration.privStatic();  // ❌ ERROR! Trapped in Declaration.java!
        */
    }
}
