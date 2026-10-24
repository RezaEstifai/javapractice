package it.polito.main;

import it.polito.model.Car;
import it.polito.model.ConstructorCar;
import it.polito.model.SmartPhone;

public class App {
    public static void main (String[] args) throws Exception {
        IO.println("hello, world");
        int i =0;
        if (i ==0) {
            IO.println( "I'm printing");
        }

        boolean cond = true;
        while (cond) {
            if (cond) { 
                cond = false;
            }
            IO.println("this is an infinite loop");
        }

        


        /*
        * CORE JAVA CONCEPT: PASS-BY-VALUE (Primitives)
        * 
        * Why 'f' doesn't change:
        * Java is strictly "pass-by-value". When you pass a primitive variable 
        * (like char, int, boolean, double) into a method, Java passes a COPY 
        * of the value, not the actual variable itself.
        * 
        * 1. 'f' holds the value 'c'.
        * 2. When calling dumCharPrinter(f), a new local variable 'toPrint' is created 
        *    and initialized with a copy of 'c'.
        * 3. Changing 'toPrint' to '1' only modifies the local copy inside the method.
        * 4. The original variable 'f' back in the main method remains totally unaffected.
        */

        char f = 'c';
        dumCharPrinter(f); 
        IO.println(f);
        
        





        // --- IMPORTANT NOTES: OBJECTS, REFERENCES, AND ALIASING ---
        
        // * a1 = null;
        // Breaks the link between a1 and the Car. The Car object 
        // remains alive in memory because a2 is still holding onto it.   

        //a2 = null;Breaks the last remaining link. Now no reference points to the Car. The object becomes "unreachable," and Java's automatic Garbage Collector deletes it from memory to free up space.   

        // * 1. VARIABLES ARE JUST REMOTES (POINTERS): 
        // Variables like 'a1' and 'a2' are NOT the physical objects themselves. 
        // They are references that hold the memory address of the object.

        // * 2. BUILDING THE OBJECT: 
        // The 'new' keyword (e.g., new Car()) is what actually builds the single 
        // physical object in the computer's memory.

        // * 3. ALIASING (a2 = a1;): 
        // Writing 'a2 = a1;' DOES NOT create a second car. It gives 'a2' the 
        // exact same memory address as 'a1'. Both variables now point to the 
        // EXACT SAME object in memory.

        // * 4. SHARED CHANGES: 
        // Because they point to the same object, changing the car's color using 
        // 'a1.paint("yellow")' means 'a2' will also see it as yellow. Any change 
        // made through one reference is instantly visible to all other references.

        IO.println("..................");
        Car c1 = new Car(); 
        c1.turnOn();
        IO.println("the color is " + c1.color);
        IO.println("the number of seats is " + c1.numSeats);
        IO.println("..................");

        IO.println("\n--------   NOW TESTING THE CONSTRUCTOR OF CAR ------------");
        ConstructorCar c2 = new ConstructorCar("öasgnaonon");
        IO.println("the color of c2 is " + c2.color);
        IO.println("the number of seats of c2 is " + c2.numSeats);
        IO.println("..................\n");

        ConstructorCar c3 = new ConstructorCar("öasgnaonon", 6, "blue");
        IO.println("the color of c3 is " + c3.color);
        IO.println("the number of seats of c3 is " + c3.numSeats);
        IO.println("..................\n");
        
        ConstructorCar c4 =c3;  //* we are not creating a new object called c4 we are just putting a reference in c4 that ponits to the mamory location that contains object c3 
                                //* they are simply same object */
        IO.println("the color of c4 is " + c4.color);
        IO.println("the number of seats of c4 is " + c4.numSeats);
        IO.println("..................\n");
        c4.color = "purple";
        IO.println("the color of c3 is " + c3.color); //* the value of collor of both c3 and c4 will be changed to purple and they are equal */
        IO.println("the color of c4 is " + c4.color);
        IO.println("..................\n");
        c4.turnOn();









            /*   TESTING SMARTPHONE FILE  */

        SmartPhone myPhone = new SmartPhone("Apple", 85);
        SmartPhone secondPhone = new SmartPhone("Samsung", 100);

        // 2. CALL A METHOD (Perform an action)
        // Use the dot (.) to tell a specific phone to do something
        myPhone.pressPowerButton(); 
        secondPhone.pressPowerButton();

        // 3. ACCESS AN ATTRIBUTE (Read its data)
        // Use the dot (.) to look at the variables inside the phone
        System.out.println("My first phone is an " + myPhone.brand);
        System.out.println("It has " + myPhone.batteryLevel + "% battery.");





    }






    public static void dumCharPrinter(char toPrint) {
        toPrint = '1';
        IO.println(toPrint);

    }




}
