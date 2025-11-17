package transports;

public class Mechanic {
    private String name;
    
    public Mechanic(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name; // what is the reason behind writing this part of the code ????????
    }

    public String repair(Car c) {
        return "Mecahnic" + this.name + "has fixed car " + c.getPlate(); // we had to define getPlate as a method inside Car.java because Plate is private so we cannot access to that 
    } 
    
}
