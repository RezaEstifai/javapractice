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
}