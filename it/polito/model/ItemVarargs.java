package it.polito.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a collection of items using varargs in the constructor,
 * reflecting typical Politecnico exam design patterns (e.g., entity registration).
 */
public class ItemVarargs {

    private final String category;
    private final List<String> tags;

    /**
     * Constructor using a mandatory first parameter and trailing varargs.
     * 
     * @param category Mandatory category name (Stack reference).
     * @param tags     Variable number of tag strings (packed into a String[] on the Heap).
     */
    public ItemVarargs(String category, String... tags) {
        this.category = category;
        // Copy the compiler-assembled String[] array into a managed ArrayList on the Heap
        this.tags = new ArrayList<>(Arrays.asList(tags));
    }
    

    public String getCategory() {
        return this.category;
    }

    public List<String> getTags() {
        return this.tags;
    }

    @Override
    public String toString() {
        return "Item{category='" + category + "', tags=" + tags + "}";
    }
}