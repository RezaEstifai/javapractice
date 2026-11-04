package it.polito.main;

// 1. THE REMOTE CONTROL (Interface)
// This is just an empty template that lets the outside world 
// press the "printData()" button without knowing the secret local class name.
interface Printer {
    void printData();
}

public class LocalInnerClosureWithInterface {

    // 2. THE FACTORY METHOD
    public static Printer createPrinter(String messageFromOutside) {
        
        // A local variable inside the method (this is what gets trapped in the closure)
        int magicMultiplier = 10; 

        // ====================================================================
        // 3. THE TRUE LOCAL INNER CLASS
        // Notice it lives completely INSIDE the method { } brackets!
        // ====================================================================
        class LocalPrinter implements Printer { // Signs the contract: "I am a Printer"
            
            @Override
            public void printData() {
                // CLOSURE IN ACTION:
                // This inner class grabs a snapshot copy of "messageFromOutside" 
                // and "magicMultiplier" and holds them in its hidden backpack forever!
                System.out.println("Message: " + messageFromOutside);
                System.out.println("Magic Multiplier: " + magicMultiplier);
            }
        }

        // 4. We create the object of our secret local class 
        // and hand it out wearing the "Printer" disguise!
        return new LocalPrinter();
    }

    public static void main(String[] args) {
        System.out.println("=== 1. CALLING THE METHOD ===");
        
        // 5. Look at the type here: it's "Printer" (the interface), NOT "LocalPrinter".
        // This is how main can receive the object without knowing the secret local class name!
        Printer myPrinter = createPrinter("Hello from the past!");

        System.out.println("\n=== 2. USING THE OBJECT LATER (FIRST TIME) ===");
        // The method has finished and died, but the object still remembers the data!
        myPrinter.printData(); 

        System.out.println("\n=== 3. USING IT FOR A SECOND TIME ===");
        // Proves it permanently keeps those remembered values in its closure backpack:
        myPrinter.printData();
    }
}