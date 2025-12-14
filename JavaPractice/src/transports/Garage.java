package transports;

public class Garage {
    private Mechanic owner;
    private String garageName;
    private Car[] cars;
    private int currOcc;
    private final static int MAX_STORAGE = 10; // constant 
    public Garage(String garageName, String owner) {
        this.garageName = garageName;
        this.owner = new Mechanic(owner);
        this.cars = new Car[MAX_STORAGE];
        this.currOcc = 0;
    } 

    public String getGarageName() {
        return garageName;
    }

    public void receiveNewCar( Car c) {
        if (currOcc < MAX_STORAGE) {
            IO.println("let " + this.owner.getName() + " take care of your car!");
        }
    }
}
