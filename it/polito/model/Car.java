package it.polito.model;

public class Car {
    public String color;
    public int numSeats;
    public String plates;
    public boolean turnedOn;

    public void turnOn() {
        turnedOn = true;
        IO.println("I am ready to go!!");
    }
}
