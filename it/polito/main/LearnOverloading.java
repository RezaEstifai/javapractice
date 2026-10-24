package it.polito.main;

/* =============================================================================
 * TOPIC: Constructor and Method Overloading
 * FILE NAME: LearnOverloading.java
 * ============================================================================= */

// -----------------------------------------------------------------------------
// PART 1: THE BLUEPRINT WITH OVERLOADS (Renamed to avoid folder conflicts)
// -----------------------------------------------------------------------------
class OverloadedCar {
    String brand;
    String color;

    /*
     * CONSTRUCTOR OVERLOADING
     * Three different ways to build the object.
     */
    
    // Version 1: No inputs. (The Default)
    public OverloadedCar() {
        color = "red";
        brand = "Ferrari";
        System.out.println("   [Constructor 1 Built]: A default " + color + " " + brand);
    }

    // Version 2: One String input. (Custom brand, default color)
    public OverloadedCar(String carBrand) {
        color = "white";
        brand = carBrand;
        System.out.println("   [Constructor 2 Built]: A default " + color + " " + brand);
    }

    // Version 3: Two String inputs. (Fully custom)
    public OverloadedCar(String carBrand, String carColor) {
        color = carColor;
        brand = carBrand;
        System.out.println("   [Constructor 3 Built]: A custom " + color + " " + brand);
    }

    /*
     * METHOD OVERLOADING
     * Three different ways to paint the object.
     */

    // Version 1: No inputs.
    public void paint() {
        color = "white";
        System.out.println("   [Paint 1 Triggered]: Car painted default " + color);
    }

    // Version 2: Integer input.
    public void paint(int colorCode) {
        System.out.println("   [Paint 2 Triggered]: Applying special paint code #" + colorCode);
    }

    // Version 3: String input.
    public void paint(String newCol) {
        color = newCol;
        System.out.println("   [Paint 3 Triggered]: Car custom painted to " + color);
    }
}

// -----------------------------------------------------------------------------
// PART 2: THE MAIN EXECUTION CLASS
// -----------------------------------------------------------------------------
public class LearnOverloading {
    
    public static void main(String[] args) {
        
        System.out.println("--- TESTING CONSTRUCTOR OVERLOADING ---");
        
        // Java sees empty (), so it routes to Constructor 1
        OverloadedCar defaultCar = new OverloadedCar(); 
        
        // Java sees one String, so it routes to Constructor 2
        OverloadedCar halfCustomCar = new OverloadedCar("Porsche");
        
        // Java sees two Strings, so it routes to Constructor 3
        OverloadedCar fullyCustomCar = new OverloadedCar("Aston Martin", "silver");


        System.out.println("\n--- TESTING METHOD OVERLOADING ---");
        
        // Java sees a String, so it routes to Paint 3
        fullyCustomCar.paint("matte black");
        
        // Java sees an int, so it routes to Paint 2
        fullyCustomCar.paint(9945);
        
        // Java sees empty (), so it routes to Paint 1
        fullyCustomCar.paint(); 
    }
}