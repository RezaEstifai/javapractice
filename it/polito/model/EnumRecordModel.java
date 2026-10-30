package it.polito.model;

public class EnumRecordModel {

/**
 * Demonstrates an Enum with custom attributes and a modern Java 17+ Record.
 */


    // 1. ENUM DEFINITION (Slides 121 & 122)
    // Strong type safety representing card suits
    public enum Suit {
        SPADES("Black"), 
        HEARTS("Red"), 
        DIAMONDS("Red"), 
        CLUBS("Black");

        private final String color; // Enum fields must be final

        // Enum constructor (always private implicitly)
        Suit(String color) {
            this.color = color;
        }

        public String getColor() {
            return this.color;
        }
    }

    // 2. RECORD DEFINITION (Slides 124 & 125)
    // Automatically creates a final class with fields 'suit' and 'rank', 
    // a constructor, toString(), equals(), and getters suit() and rank()!
    public record PlayingCard(Suit suit, int rank) {
        
        // Compact Constructor Validation (specific to Records in Java 17+)
        public PlayingCard {
            if (rank < 1 || rank > 13) {
                throw new IllegalArgumentException("Card rank must be between 1 and 13.");
            }
        }
    }
}
