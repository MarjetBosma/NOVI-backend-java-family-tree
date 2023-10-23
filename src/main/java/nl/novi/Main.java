package nl.novi;

public class Main {
    public static void main(String[] args) {

        // Mijn ouders zijn beiden al overleden, dus ik heb maar de leeftijd ingevuld die ze nu zouden hebben, maar in dit geval had een geboortejaar wellicht beter gewerkt, want in stambomen is het vaak het geval dat mensen al niet meer leven.

        Person father = new Person("Christiaan", "Frederik", "Bosma", 'M', 68);
        Person mother = new Person("Johanna", "Bonsma", 'V', 68);
        Person me = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        Person sister = new Person("Marianne", "Bosma", 'V', 40);
        Person wife = new Person("Rieneke", "Esther", "Daalder", 'V', 47);
        Person daughter = new Person("Hannah", "Esther", "Daalder", 'V', 10);
        Person sistersHusband = new Person("Jan", "Veldhuizen", 'M', 43);
        Person sistersFirstDaughter = new Person("Eva", "Johanna", "Veldhuizen", 'V', 8);
        Person sistersSecondDaughter = new Person("Rosa", "Tooske", "Veldhuizen", 'V', 5);

        Pet cat = new Pet("Firsa", 17, "kat");
        Pet sistersCat = new Pet("Kees", 15, "kat");

        me.addParents(father, mother, me);
        sister.addParents(father, mother, sister);

        me.addPet(me, cat);
        me.addPet(sister, sistersCat);

    }
}
