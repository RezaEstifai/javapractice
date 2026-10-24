package it.polito.main;

// ArrayList is a list that can grow or shrink; this class uses it to keep tags.
import java.util.ArrayList;
// Arrays provides helper methods for working with arrays.
import java.util.Arrays;
// List is the general type used for an ordered collection of values.
import java.util.List;

/**
 * Runs examples showing how varargs let a method accept a variable number
 * of values, and how a constructor can use varargs too.
 */
public class VarargsLab {

    // "int..." means this method can receive any number of int values.
    // Java collects those values into an int array named values.
    static int min(int... values) {
        // Start with the largest possible int so the first real value is smaller.
        // If there are no values, this starting value is returned unchanged.
        // * THIS PART IS ALGORITHM IS FOR FINDING MINIMUM, NOT VARARGS! *
        int res = Integer.MAX_VALUE;

        // Check each number from the array that Java made for the varargs.
        for (int v : values) {
            // If this number is smaller than the smallest found so far...
            if (v < res) {
                res = v; // ...remember it as the new smallest number.
            }
        }
        return res; // Give the smallest number back to whoever called min.

        //* ANOTHER ALGORITHM FOR FINDING MIN */
        //     static int min(int... values) {
        // // Guard clause: stop immediately if no numbers were passed
        // if (values.length == 0) {
        //     throw new IllegalArgumentException("Cannot find minimum of zero numbers!");
        // }

        // // Pick the first item as the starting minimum
        // int res = values[0];

        // // Start checking from the second element (index 1)
        // for (int i = 1; i < values.length; i++) {
        //     if (values[i] < res) {
        //         res = values[i];
        //     }
        // }
        // return res;
}


    // Java starts running the program here.
    // "args" can hold command-line text, but this example does not use it.
    public static void main(String[] args) {

        // Print a heading so it is easy to recognize the first example.
        System.out.println("=== 1. SLIDE 100: PASSING LOOSE ARGUMENTS ===");
        
        // Pass six separate numbers; Java gathers them into the values array.
        int m = min(9, 3, 5, 7, 2, 8);
        // Print the result stored in m.
        System.out.println("min(9, 3, 5, 7, 2, 8) = " + m);


        // This heading introduces the example where we already have an array.
        System.out.println("\n=== 2. SLIDE 100: PASSING AN EXISTING ARRAY ===");
        
        // Create an int array and fill it with six numbers.
        int[] numbers = {9, 3, 5, 7, 2, 8};
        // Pass the existing array to min; Java does not need to gather separate values.
        int mFromArray = min(numbers);
        // Print the smallest value found in numbers.
        System.out.println("min(numbers) = " + mFromArray);


        // This heading introduces the case where min receives no numbers.
        System.out.println("\n=== 3. EDGE CASE: ZERO ARGUMENTS ===");
        
        // With no arguments, values is an empty array, so the loop runs zero times.
        // The method therefore returns its starting value, Integer.MAX_VALUE.
        int emptyMin = min();
        // Print that result; it is a special fallback, not a useful minimum of real numbers.
        System.out.println("min() with 0 args = ------------------" + emptyMin);


        // This heading introduces a class whose constructor also accepts varargs.
        System.out.println("\n=== 4. OBJECT VARARGS IN EXAM DOMAIN MODELS ===");
        
        // Create a TaggedItem with a category and no tags.
        TaggedItem item1 = new TaggedItem("Electronics");
        // Create another TaggedItem with a category and three separate tag strings.
        TaggedItem item2 = new TaggedItem("Clothing", "Sale", "Cotton", "Summer");
        
        // Printing an object automatically calls its toString method.
        System.out.println(item1);
        System.out.println(item2);
    }
}

// A second class can be in this file because it is not public.
// It describes an item with a category and a list of tags.
class TaggedItem {
    // Store the item's category; final means it cannot be reassigned after construction.
    private final String category;
    // Store the item's tags as an ordered list of strings.
    private final List<String> tags;

    // This constructor runs when code creates a new TaggedItem.
    // It always needs a category, and can receive zero or more tag strings.
    public TaggedItem(String category, String... tags) {
        this.category = category; // Save the provided category in this object's field.
        // Turn the tags array into a list, then copy it into a growable ArrayList.
        this.tags = new ArrayList<>(Arrays.asList(tags));
    }

    // Tell Java to use this method when this object needs to be shown as text.
    @Override
    public String toString() {
        // Build and return readable text using the saved category and tags.
        return "Item{category='" + category + "', tags=" + tags + "}";
    }
}