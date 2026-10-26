package it.polito.main;

public class Declaration {

        // ==========================================
        // GROUP A: NON-STATIC (Needs "new Student()")
        // ==========================================

        // 1. public + non-static
        public void pubNormal() { }

        // 2. protected + non-static (For family/children + same folder)
        protected void protNormal() { }
        // 3. No-keyword (default) + non-static (Same folder ONLY)
        void defNormal() { }

        // 4. private + non-static (Trapped inside Student.java ONLY)
        private void privNormal() { }


        // ==========================================
        // GROUP B: STATIC (Call directly with "Student.")
        // ==========================================

        // 5. public + static
        public static void pubStatic() { }

        // 6. protected + static
        protected static void protStatic() { }

        // 7. No-keyword (default) + static
        static void defStatic() { }

        // 8. private + static
        private static void privStatic() { }


// No import needed because we are in the exact same folder!

public class SameFolderApp {
    public static void main(String[] args) {

        // -----------------------------------------------------
        // ATTEMPT 1: Calling WITHOUT creating an object (Using Class Name "Student.")
        // Rule: Only works if the method is STATIC and NOT PRIVATE!
        // -----------------------------------------------------
        Declaration.pubStatic();   // ✅ WORKS! (It is static + public)
        Declaration.protStatic();  // ✅ WORKS! (It is static + protected allows same-folder)
        Declaration.defStatic();   // ✅ WORKS! (It is static + default allows same-folder)
        
        //*  Declaration.privStatic();  // ❌ ERROR! Even though it's static, it is "private"!
        
        //*  Declaration.pubNormal();   // ❌ ERROR! It is NOT static! You cannot use "Declaration."!
        //*  Declaration.protNormal();  // ❌ ERROR! Not static!
        //*  Declaration.defNormal();   // ❌ ERROR! Not static!


        // // -----------------------------------------------------
        // // ATTEMPT 2: Calling WITH an object ("new Student()")
        // // Rule: Required for all non-static methods (except private)!
        // // -----------------------------------------------------
         Declaration s = new Declaration(); // <-- Creating the object!

        s.pubNormal();   // ✅ WORKS! (Object created + public)
        s.protNormal();  // ✅ WORKS! (Object created + protected allows same-folder)
        s.defNormal();   // ✅ WORKS! (Object created + default allows same-folder)
        
        //* s.privNormal();  // ❌ ERROR! It is "private"! Even with an object, you can't touch it!

        // // What happens if you call a STATIC method using the object "s"?
        //* s.pubStatic();   // ⚠️ COMPILES (Works), BUT BAD STYLE! 
                         // VS Code will underline it in yellow and say: 
                         // "Should be accessed in a static way: write Student.pubStatic() instead!"
    }
}
    }

