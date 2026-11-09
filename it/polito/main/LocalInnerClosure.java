package it.polito.main;

public class LocalInnerClosure {

    // ====================================================================
    // THIS CLASS MUST BE DECLARED AT THE OUTER CLASS LEVEL.
    // A local class cannot be used outside the method where it is defined.
    // ====================================================================
    //* --------------------------------------------------------------------------------------------------------------  */
    //* HOW A STATIC INNER CLASS CAN ACCESS THE OUTER CLASS NON-STATIC INSTANCE (IT CANNOT DO IT IN NORMAL WAY)  */
    //* --------------------------------------------------------------------------------------------------------------  */
    private String name;
    public LocalInnerClosure(String name) {
        this.name = name;
    }

    static class Student {


        void display(LocalInnerClosure uni) {    //* uni is just a name that refers to LocalInnerClosure class so with saying uni.name it can access to the non-static name (since Student class is static and cannot directly access non-static members of the outer class) */
            System.out.println(uni.name);
        }
    }


    //* --------------------------------------------------------------------------------------------------------------  */
    //* --------------------------------------------------------------------------------------------------------------  */




    private static class LocalPrinter {

        private final String messageFromOutside;
        private final int magicMultiplier;

        public LocalPrinter(String messageFromOutside, int magicMultiplier) {
            this.messageFromOutside = messageFromOutside;
            this.magicMultiplier = magicMultiplier;
        }

        public void printData() {
            // CLOSURE IN ACTION:
            // The object keeps the values it was created with,
            // so they remain available even after the method has finished.
            System.out.println("Message: " + messageFromOutside);
            System.out.println("Magic Multiplier: " + magicMultiplier);
        }
    }




    // Look here! The method returns the actual class type: LocalPrinter
    public static LocalPrinter createPrinter(String messageFromOutside) {

        // 1. A local variable inside the method
        int magicMultiplier = 10;

        // 2. We create an object that stores those values and return it OUT of the method
        //    This is the key idea of the closure-like behavior: the object carries the data.
        return new LocalPrinter(messageFromOutside, magicMultiplier);
    }

    public static void main(String[] args) {
        System.out.println("=== 1. CALLING THE METHOD ===");

        // We call the method. The method finishes running, and its local variables
        // (messageFromOutside and magicMultiplier) should normally be destroyed.
        // But because the object stores them as fields, it still remembers them later.
        LocalPrinter myPrinter = createPrinter("Hello from the past!");

        System.out.println("\n=== 2. USING THE OBJECT LATER (FIRST TIME) ===");
        // The method is long gone, but the object still remembers the data!
        myPrinter.printData();

        System.out.println("\n=== 3. USING IT FOR A SECOND TIME ===");
        // Using it again proves it permanently keeps those remembered values:
        myPrinter.printData();


        //* THE PART BELONG TO UNIVERSITY  */
        
        LocalInnerClosure uni1 = new LocalInnerClosure("Polito");

        LocalInnerClosure uni2 = new LocalInnerClosure("University of Turin");

        LocalInnerClosure.Student s = new LocalInnerClosure.Student();

        s.display(uni1);
        s.display(uni2);
    }
}