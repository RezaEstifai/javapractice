public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Hello, World!");

        // basic properties 
        int i=0;
        if (i==0) { 
            System.out.println(i);
        }

        // or we have booleans
        boolean cond = true;

        while (cond) { //since cond is a boolean, therefore we don't have to use == for checking them 
            System.out.println("this is an infinite loop if you don't break it ");
            break;
        }

        // data types
        char f = 'c';
        String s = "this is a string";

    }
}
