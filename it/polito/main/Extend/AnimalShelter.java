package it.polito.main.Extend;

public class AnimalShelter {

    // This method promises to return an Animal.
    // It actually creates and returns a Dog!

    public Animal giveAnimal() {

        Dog dog = new Dog("Rocky", "German Shepherd");

        return dog;
    }
}