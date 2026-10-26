package it.polito.main;

public class SameFolderApp {
    public static void main(String[] args) {
        Declaration.pubStatic();
        Declaration.protStatic();
        Declaration.defStatic();

        Declaration s = new Declaration();
        s.pubNormal();
        s.protNormal();
        s.defNormal();
    }
}
