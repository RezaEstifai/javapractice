// since this file is just a class it doesn't need a main method 
public class Car {
    // attributes
    private String color;
    private int numSeats;
    String plate;
    boolean turnedOn;
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
    public void setNseats(int numSeats) {
        this.numSeats = numSeats;
    }
    public int showNumseats() {
        return numSeats;
    }
    public String showPlate() {
        return plate;
    }
}
