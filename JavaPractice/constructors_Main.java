public class constructors_Main {
    public static void main (String [] args) {
        constructors_Human human = new constructors_Human("Reza", 23, 95.9); /* object name is human  */
        System.out.println(human.name + " "+ human.age + " " + human.weight);
        human.eat();
        human.drinking();
    }
}