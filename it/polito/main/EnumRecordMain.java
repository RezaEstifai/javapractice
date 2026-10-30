package it.polito.main;
import it.polito.model.EnumRecordModel.Suit;
import it.polito.model.EnumRecordModel.PlayingCard;

public class EnumRecordMain {


/**
 * Executable driver testing Enum iteration, switch expressions, and Record features.
 */
    public static void main(String[] args) {

        System.out.println("=== 1. USING ENUMS (Slides 121 & 122) ===");
        
        // Accessing enum constant
        Suit mySuit = Suit.HEARTS;
        System.out.println("Selected Suit     : " + mySuit);
        System.out.println("Suit Color        : " + mySuit.getColor());
        
        // Iterating over all enum values using the compiler-generated .values() method
        System.out.println("All available suits:");
        for (Suit s : Suit.values()) {
            System.out.println(" - " + s + " (" + s.getColor() + "), ordinal index = " + s.ordinal());
        }


        System.out.println("\n=== 2. USING RECORDS (Slides 124 & 125) ===");
        
        // Instantiating a record using the automatically generated constructor
        PlayingCard card = new PlayingCard(Suit.SPADES, 10);
        
        // Accessing fields using record getter methods (notice no 'get' prefix!)
        System.out.println("Card Suit         : " + card.suit());
        System.out.println("Card Rank         : " + card.rank());
        
        // Records automatically provide a clean toString() implementation
        System.out.println("Card toString()   : " + card);

        // Immutability test: card.rank = 5; -> COMPILE ERROR! Fields are final.
    }
}
