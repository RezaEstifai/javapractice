// since this file is just a class it doesn't need a main method 
public class Car {
    // attributes
    private String color;
    int numSeats;
    private String plate;
    boolean turnedOn;
    public Car() {}
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
}
