import transports.Car;
import transports.Mechanic;
public class JavaEnvironment {
    public static void basic (String [] args) throws Exception{
        System.out.println("Hello, World!");

        /* basic properties */
        int i =0;
        if (i==0) {
            System.out.println("i is equal to zero");
        }
        else if (i>0) {
            System.out.println("i is positive");
        }

        /*  booleans */
        boolean cond = true;

        while (cond) { /* since it's a boolean therefore there is no need for wirte cond==true */
            System.out.println("this is an infinite loop if you don't break it!");
            break;
        }

        /* data types */
        char f = 'c';
        String c = "this is my java program";

        /* all parameters are passed by value!!!*/
        dumbCharPrinter(f);
        System.out.println(f);
        System.out.println("------------------------------");
        /* defining the first class */ 
        /* it's written down | dubCharPrinter */ 
    }
    public static void dumbCharPrinter( char toPrint) {
        toPrint = '1';
        System.out.println(toPrint);
    }

    public static void for_(String [] args) {
        System.out.println("Number of argument : "+ args.length);
        for (int i=0 ; i<args.length; i++ ) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }

    public static void charnew () {
        char f = 'n';
        String s = "this is a string for testing the environment ";
        System.out.println(s);
        }

    public static void sayHello() {
        System.out.println("Hello from the sayHello method!");
    }


    public static void main (String [] args) throws Exception {
        //basic(args);
        //for_(args);
        //sayHello();
        //charnew();

        /* using Car class from Car.java */ 
        Car c1 = new Car();
        c1.turnOn();
        // System.out.println("car turned on: " + c1.turnedOn);
        // System.out.println(c1.getColor());

        /* if setNseats have return 
         * 1st Method -------------------------------
         *     public int setNseats(int numSeats) {
                    this.numSeats = numSeats;
                    return numSeats;
                }
         *  
         *  int f = c1.setNseats(4);
            System.out.println("num seats : " + f);
         */

        /* 
         * 2st Method -------------------------------
         * 
         *System.out.println("number of available seats are : " + c1.setNseats(4));

         */

        /* defingin another method for returning the number of the seats inside Car.java
         * 3st Method -------------------------------
            public void setNseats(int numSeats) {
                this.numSeats = numSeats;
            }
            public int showNumseats() {
                return numSeats;
         */
        c1.setNseats(4);
        Car c2 = new Car();
        Car c3 = new Car("12x3415");
        // Method Invocation 
        //System.out.println(c3.plate); // cannot be run because plate is private 
        //end of Method Invoaction 
        System.out.println("plate number : " + c3.showPlate());
        System.out.println("numSeats : " + c1.showNumseats());
        System.out.println("num : " + c2.showNumseats());
        
        /* Method Chaining 1st */
        Car c4 = new Car();
        c4.wash().dry();
        /* Method Chaining 2rd */
        Car c5 = c4.wash();
        c5.dry();

        /* Comparing Objects */
        Car bestCar = new Car("120x1341");
        Car anotherCarMaybe = new Car("120x1341");
        Car maybeBestCar = bestCar;
        if (bestCar == maybeBestCar) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
        System.out.println(maybeBestCar.getClass());
        //System.out.println("number of available seats are : " + f);
        /* using constructors from file constructors_Human*/
        constructors_Human human = new constructors_Human("Reza", 23, 92.4);
        
        /* Method Chaining Counter */
        Counter cnt = new Counter();
        cnt.reset().print().increment(10).print().decrement(7).print();

        /* Comparison Method class Car.java */
        if (bestCar.isEqual(anotherCarMaybe)) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
        // now you will see that the output is same, beacuse the elements inside each one of them is same 

        // overloading example 1
        bestCar.fillFuelLevel(2);
        System.out.println("the current fuel level is : " + bestCar.getFuelLevel());
        bestCar.fillFuelLevel(4);
        System.out.println("the current fuel level is : " + bestCar.getFuelLevel());
        bestCar.fillFuelLevel();
        System.out.println("the current fuel level is : " + bestCar.getFuelLevel());
        
        /* Packages and Visibility */
        bestCar.setNseats(-4);
        //bestCar.turnedOn = false;      // ERROR

        Mechanic m = new Mechanic("Karen");
        bestCar.setMyMechanic(m);
        System.out.println(bestCar.repair());
    }
}
