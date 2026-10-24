package it.polito.model;

// 1. THE CLASS (The Blueprint)
public class SmartPhone {
    
    // 2. ATTRIBUTES (The Data / State of the phone)
    public String brand;
    public int batteryLevel;   // Percentage: 0 to 100
    public boolean screenOn;

    // 3. CONSTRUCTOR (Initializes the phone when created)
    public SmartPhone(String phoneBrand, int initialBattery) {
        brand = phoneBrand;
        batteryLevel = initialBattery;
        screenOn = false; // By default, the screen starts off
    }

    // 4. METHODS (The Actions / Messages the phone can accept)
    
    // Method that modifies an attribute (changes state)
    public void pressPowerButton() {
        screenOn = !screenOn; // Flips between true and false
        if (screenOn) {
            System.out.println(brand + ": Screen turned ON.");
        } else {
            System.out.println(brand + ": Screen turned OFF.");
        }
    }

    // Method that accepts an argument and modifies an attribute
    public void charge(int amount) {
        batteryLevel = batteryLevel + amount;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.println(brand + " charged by " + amount + "%. Current battery: " + batteryLevel + "%");
    }

    // Method that returns a value back to the caller
    public int checkBattery() {
        return batteryLevel;
    }

    // Method that prints out the current state
    public void displayStatus() {
        System.out.println("--- " + brand + " Status ---");
        System.out.println("Screen On: " + screenOn);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("-------------------------");
    }
}