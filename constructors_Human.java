public class constructors_Human {
    /* atttributes of the object */
    String name;
    int age;
    double weight;
    constructors_Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /* Methods */
    void eat() { /*calling this method is different w.r.t. constructors_Human */
        System.out.println(this.name + " is eating now ");
    }
    void drinking() {
        System.out.println(this.name + "with age of " +this.age + " is drinking ");
    }
}