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
        Car myCar = new Car();
        myCar.turnOn();
        // System.out.println("car turned on: " + myCar.turnedOn);
        // System.out.println(myCar.getColor());

        /* if setNseats have return 
         * 1st Method -------------------------------
         *     public int setNseats(int numSeats) {
                    this.numSeats = numSeats;
                    return numSeats;
                }
         *  
         *  int f = myCar.setNseats(4);
            System.out.println("num seats : " + f);
         */

        /* 
         * 2st Method -------------------------------
         * 
         *System.out.println("number of available seats are : " + myCar.setNseats(4));

         */

        /* defingin another method for returning the number of the seats inside Car.java
         * 3st Method -------------------------------
            public void setNseats(int numSeats) {
                this.numSeats = numSeats;
            }
            public int showNumseats() {
                return numSeats;
         */
        myCar.setNseats(4);
        System.out.println("numSeats : " + myCar.showNumseats());
        //System.out.println("number of available seats are : " + f);
        /* using constructors from file constructors_Human*/
        constructors_Human human = new constructors_Human("Reza", 23, 92.4);
            
    }
}
