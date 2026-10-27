package it.polito.main;
import it.polito.model.SingleInstance;
import it.polito.model.SingleInstance.DirectoryEager;

public class SingleInstanceMain {
    public static void main(String[] args) {

        System.out.println("=== 1. TESTING SLIDE 119 (EAGER) ===");
        // The instance is created when DirectoryEager is first loaded.
        DirectoryEager eagerDir1 = DirectoryEager.root;
        DirectoryEager eagerDir2 = DirectoryEager.root;
        eagerDir1.displayRootPath();
        System.out.println("Are eager references identical? " + (eagerDir1 == eagerDir2));

        System.out.println("\n=== 2. TESTING SLIDE 120 (LAZY) ===");
        // The instance is created on the first getInstance() call.
        SingleInstance configScreen1 = SingleInstance.getInstance();
        configScreen1.setSetting("theme", "dark");
        System.out.println("Screen 1 updated theme to: " + configScreen1.getSetting("theme"));

        // Retrieved from a different context/file:
        SingleInstance configScreen2 = SingleInstance.getInstance();
        System.out.println("Screen 2 reads active theme: " + configScreen2.getSetting("theme"));

        // Memory identity verification:
        System.out.println("Do both variables share the identical memory reference? " + (configScreen1 == configScreen2));
    }
}