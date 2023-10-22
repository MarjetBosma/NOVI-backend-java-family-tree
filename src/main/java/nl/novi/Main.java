package nl.novi;

public class Main {
    public static void main(String[] args) {

        // Mijn ouders zijn beide al overleden, dus ik heb maar de leeftijfd ingevuld die ze nu zouden hebben, maar in dit geval had een geboortejaar wellicht beter gewerkt, in stambomen is het natuurlijk heel vaak het geval dat mensen al niet meer leven.

        Person father = new Person("Christiaan", "Frederik", "Bosma", 'M', 68);
        Person mother = new Person("Johanna", "Bonsma", 'V', 68);
        Person me = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        Person sister = new Person("Marianne", "Bosma", 'V', 40);

        me.addParents(father, mother, me);
        sister.addParents(father, mother, sister);
    }
}
