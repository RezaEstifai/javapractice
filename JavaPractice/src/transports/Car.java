package transports;
// since this file is just a class it doesn't need a main method 
public class Car {
    // attributes
    private String color;
    private int numSeats;
    private String plate;
    boolean turnedOn;
    private int fuelLevel; // max fuelLevel = 10
    private Mechanic myMechanic; // we can put objects of other classes

    public Car() {}
    
    
    /* constructor overloading  */
    public Car(int n) {
        this.numSeats = n;
    }

    public Car(String plate) {
        this.plate = plate;
    }
    public Car( int n, String plate) {
        this.numSeats = n;
        this.plate = plate;
    }
    /* end of constructor overloading  */
    public void turnOn() {
        turnedOn = true;
    }
    public String getColor() {
        return color;
    }
    public String getPlate() {
        return plate;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public void setNseats(int numSeats) {
        if (numSeats < 0) {
            System.out.println("NOT VALID");
        }
        this.numSeats = numSeats;
    }

    // overloading example 
    public void fillFuelLevel() {
        if (fuelLevel < 10) {
            fuelLevel = 10;
        }
    }
    public void fillFuelLevel(int recharge) {
        if (fuelLevel + recharge <= 10) {
            fuelLevel += recharge;
        }
        else {
            fuelLevel = 10;
        }
    }
    public int showNumseats() {
        return numSeats;
    }
    public String showPlate() {
        return plate;
    }

    public Car wash() {
        System.out.println("the car is being washed");
        return this;
    }
    public void dry() {
        System.out.println("the is being dried!");
    }

    /* Comparison Method */
    public boolean isEqual (Car c) {
        if (this.plate == c.plate) {
            return true;
        }
        // no need for writing else
        return false;
    }

    public void setMyMechanic(Mechanic m) {
        this.myMechanic = m;
    }

    public void setMyMechanic(String mName) {
        this.myMechanic = new Mechanic(mName);
    }
    public String repair() {
        return myMechanic.repair(this);
    }  

}
