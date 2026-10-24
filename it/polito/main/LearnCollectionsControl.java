package it.polito.main;

/* =============================================================================
 * TOPIC: Complex Control Flow (Arrays, ArrayLists, and the For-Each Loop)
 * FILE NAME: LearnCollectionsControl.java
 * ============================================================================= */

// We must import ArrayList to use dynamic lists in Java
import java.util.ArrayList; 

public class LearnCollectionsControl {

    public static void main(String[] args) {

        /* ---------------------------------------------------------------------
         * PART 1: THE STANDARD FOR-LOOP WITH AN ARRAY
         * THE SCENARIO: We have an array of daily temperatures for a week. 
         * We want to find the highest temperature in the array.
         * 
         * HOW IT WORKS: We use 'i' as an index to point to each slot (0 to 6).
         * --------------------------------------------------------------------- */
        System.out.println("--- 1. SEARCHING AN ARRAY WITH A STANDARD FOR-LOOP ---");
        
        // Creating an array of 7 integers (fixed size)
        int[] weeklyTemperatures = {12, 15, 22, 18, 25, 19, 14}; 
        
        int maxTemp = 0; // Variable to keep track of the highest number found

        // Loop from index 0 up to the length of the array
        for (int i = 0; i < weeklyTemperatures.length; i++) {
            
            // Extract the current temperature using the index [i]
            int currentTemp = weeklyTemperatures[i];
            System.out.println("Reading day " + i + " temperature: " + currentTemp + "°C");

            // Complex Control: Compare current item to our stored max
            if (currentTemp > maxTemp) {
                maxTemp = currentTemp; // Update the max if we found a hotter day
            }
        }
        System.out.println("-> The maximum temperature this week was: " + maxTemp + "°C\n");


        /* ---------------------------------------------------------------------
         * PART 2: THE ENHANCED FOR-LOOP (FOR-EACH)
         * THE SCENARIO: We have an array of weather conditions. We want to count
         * how many rainy days there were without caring about index numbers.
         * 
         * HOW IT WORKS: 'for (String condition : weatherConditions)' means 
         * "For each String (which we will call 'condition') inside the array..."
         * --------------------------------------------------------------------- */
        System.out.println("--- 2. FILTERING AN ARRAY WITH A FOR-EACH LOOP ---");
        
        String[] weatherConditions = {"Sunny", "Rainy", "Cloudy", "Rainy", "Sunny"};
        int rainyDaysCount = 0;

        // No index needed! It automatically pulls out each item one by one.
        for (String condition : weatherConditions) {
            
            // * Note: In Java, we use .equals() to compare Strings, NOT ==
            if (condition.equals("Rainy")) {
                rainyDaysCount++;
                System.out.println("Found a rainy day. Incrementing count.");
            }
        }
        System.out.println("-> Total rainy days: " + rainyDaysCount + "\n");


        /* ---------------------------------------------------------------------
         * PART 3: DYNAMIC LISTS (ArrayList) & EARLY EXITS (Break)
         * THE SCENARIO: We have a dynamic list of cities that reported severe
         * weather. We need to check if "Turin" is on that list. Once we find it,
         * we stop searching to save computer memory/time.
         * --------------------------------------------------------------------- */
        System.out.println("--- 3. SEARCHING A DYNAMIC LIST WITH BREAK ---");
        
        // Creating a dynamic list that can grow and shrink
        ArrayList<String> severeWeatherCities = new ArrayList<>();
        // Adding items to the list dynamically using .add()
        severeWeatherCities.add("Milan");
        severeWeatherCities.add("Genoa");
        severeWeatherCities.add("Turin");
        severeWeatherCities.add("Rome");
        severeWeatherCities.add("Naples");

        boolean isTurinSafe = true;

        // Using a For-Each loop on the ArrayList
        for (String city : severeWeatherCities) {
            
            System.out.println("Checking city: " + city);
            
            if (city.equals("Turin")) {
                System.out.println("  -> ALERT: Severe weather reported in Turin!");
                isTurinSafe = false;
                
                // We found what we need. There is no reason to check Rome or Naples.
                // We use 'break' to instantly smash out of the loop.
                break; 
            }
        }
        
        if (isTurinSafe) {
            System.out.println("-> Turin is clear of severe weather.");
        }
    }
}

/* =============================================================================
 * EXPECTED TERMINAL OUTPUT:
 * -----------------------------------------------------------------------------
 * --- 1. SEARCHING AN ARRAY WITH A STANDARD FOR-LOOP ---
 * Reading day 0 temperature: 12°C
 * Reading day 1 temperature: 15°C
 * Reading day 2 temperature: 22°C
 * Reading day 3 temperature: 18°C
 * Reading day 4 temperature: 25°C
 * Reading day 5 temperature: 19°C
 * Reading day 6 temperature: 14°C
 * -> The maximum temperature this week was: 25°C
 * 
 * --- 2. FILTERING AN ARRAY WITH A FOR-EACH LOOP ---
 * Found a rainy day. Incrementing count.
 * Found a rainy day. Incrementing count.
 * -> Total rainy days: 2
 * 
 * --- 3. SEARCHING A DYNAMIC LIST WITH BREAK ---
 * Checking city: Milan
 * Checking city: Genoa
 * Checking city: Turin
 *   -> ALERT: Severe weather reported in Turin!
 * ============================================================================= */