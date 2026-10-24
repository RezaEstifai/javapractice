package it.polito.main;

// We can import BankAccount because it is PUBLIC (part of the Exported Public API)
import it.polito.model.BankAccount;

// WE CANNOT IMPORT InternalAuditLogger!
// If you uncomment the line below, the compiler says:
// "InternalAuditLogger is not public in it.polito.model; cannot be accessed from outside package"
// import it.polito.model.InternalAuditLogger;

public class BankAccountMain {

    public static void main(String[] args) {
        System.out.println("=== PLAIN ENGLISH DEMO ===\n");

        // 1. Interacting with the Public API
        BankAccount myAccount = new BankAccount(100);

        // 2. We interact through the safe doorways (methods), NOT by touching balance directly
        myAccount.deposit(50);

        // 3. We check the result through the query doorway
        System.out.println("Final Account Balance: " + myAccount.getBalance() + " EUR");

        // 4. What happens if we try to break the encapsulation boundary?
        // myAccount.balance = 99999; // COMPILE ERROR: balance has private access in BankAccount!
        
        // 5. What happens if we try to cross the trust boundary?
        // InternalAuditLogger.log("Hacked!"); // COMPILE ERROR: InternalAuditLogger is invisible here!
    }
}

/*
======================================================================
EXPECTED TERMINAL OUTPUT:
======================================================================
=== PLAIN ENGLISH DEMO ===

[INTERNAL LOG]: Deposited: 50
Final Account Balance: 150 EUR
======================================================================
*/


/*
* Top-level class               A normal class written directly in its own file (not inside another class's {}).   
* Encapsulation boundary        Putting private variables behind a wall so outside code cannot tamper with them.   
* Public API                    The list of public methods on the outside of your class that anyone is allowed to call.   
* Trust boundary                Classes in the same folder share internal tools; classes outside that folder are kept out.   
* Package-private               A class or method with no keyword (class Foo { }). Only files in the exact same package folder can see it.   
 */