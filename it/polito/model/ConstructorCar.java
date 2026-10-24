package it.polito.model;

public class ConstructorCar {
    public String color;
    public int numSeats;
    public String plate;
    public boolean turnedOn;


    // Note: Passing exactly one String argument automatically triggers the constructor
    //  that expects one String.

    public ConstructorCar (String plate) { //* the orange plate can be named anything but it's better to name it same as the attribute defined above */
        this.plate = plate;
        this.color = "white";
        this.numSeats = 4;
    }
    public ConstructorCar() {

    }
    public ConstructorCar(String plate, int numSeats, String color) {
        this.plate = plate;
        this.numSeats = numSeats;
        this.color = color;
        turnOn(); //* for method there is no need for THIS you can put it but NO MATTER */
    }

    // Note: Calling a method inside a constructor runs it automatically upon object creation.
    //  It sets up the object's starting state so we don't have to call it manually in Main.
    
    public void turnOn() {
        turnedOn = true;
        IO.println("I am ready to go!!");
    }
}
