package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person me;
    Person father;
    Person mother;
    Person sister;
    Person daughter;
    Person wife;
    Pet cat;

    @BeforeEach
    void setUp() {
        // Arrange (voor een aantal testen was het handig om hierboven vast wat persons te declareren, dat scheelt schrijfwerk. In andere gevallen vond ik het handiger en leesbaarder om bij de test zelf persons aan te maken.)
        me = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        father = new Person("Christiaan", "Frederik", "Bosma", 'M', 68);
        mother = new Person("Johanna", "Bonsma", 'V', 68);
        sister = new Person("Marianne", "Bosma", 'V', 40);
        daughter = new Person("Hannah", "Esther", "Daalder", 'V', 10);
        wife = new Person("Rieneke", "Esther", "Daalder", 'V', 47);
    }

    @Test
    void getNameTest() {
        // Act
        String getName = me.getName();
        // Assert
        assertEquals("Marjet", getName);
    }

    @Test
    void setNameTest() {
        // Act
        me.setName("Johanna");
        String getName = me.getName();
        // Assert
        assertEquals("Johanna", getName);
    }

    @Test
    void getMiddleNameTest() {
        // Act
        String getMiddleName = me.getMiddleName();
        // Assert
        assertEquals("Johanna", getMiddleName);
    }

    @Test
    void setMiddleNameTest() {
        // Act
        me.setMiddleName("Marianne");
        String getMiddleName = me.getMiddleName();
        // Assert
        assertEquals("Marianne", getMiddleName);
    }

    @Test
    void getLastNameTest() {
        // Act
        String getLastName = me.getLastName();
        // Assert
        assertEquals("Bosma", getLastName);
    }

    @Test
    void setLastNameTest() {
        // Act
        me.setLastName("Daalder");
        String getLastName = me.getLastName();
        // Assert
        assertEquals("Daalder", getLastName);
    }

    @Test
    void getSexTest() {
        char getSex = me.getSex();
        assertEquals('V', getSex);
    }

    @Test
    void setSexTest() {
        me.setSex('M');
        char getSex = me.getSex();
        assertEquals('M', getSex);
    }

    @Test
    void getAgeTest() {
        int getAge = me.getAge();
        assertEquals(42, getAge);
    }

    @Test
    void setAgeTest() {
        me.setAge(43);
        int getAge = me.getAge();
        assertEquals(43, getAge);
    }

    @Test
    void getMotherTest() {
        // Arrange (personen staan ook al onder setup, maar ik gebruik hier even andere variabelenamen voor de helderheid en om verwarring te voorkomen.
        Person person1 = new Person("Hannah", "Esther", "Daalder", 'V', 10);
        Person person2 = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        person1.setMother(person2); // De setterfunctie wordt meteen meegetest
        // Act
        Person mother = person1.getMother();
        // Assert
        assertEquals(person2, mother);
    }
    // Mijn dochter heeft 2 moeders en geen (bekende) vader, maar dat kun je nu niet vastleggen volgens mij. Wellicht leuk om nog eens uit te zoeken hoe dat dan zou moeten, maar ik vond voor nu deze opdracht al uitdagend genoeg...

    @Test
    void getFatherTest() {
        // Arrange
        Person person1 = new Person("Marianne", "Bosma", 'V', 40);
        Person person2 = new Person("Christiaan", "Frederik", "Bosma", 'M', 68);
        person1.setFather(person2); // De setterfunctie wordt meteen meegetest
        // Act
        Person father = person1.getFather();
        // Assert
        assertEquals(person2, father);
    }


    @Test
    void getChildrenTest() {
        // Arrange
        Person person1 = new Person("Marjet", "Johanna","Bosma", 'V', 42);
        Person person2 = new Person("Hannah", "Esther", "Daalder", 'V', 10);
        List<Person> children = new ArrayList<>();
        children.add(person2);
        // Act
        List<Person> mySistersChildren = person1.getChildren();
        // Assert
        assertEquals(children, mySistersChildren);
    }

    @Test
    void getSiblingsTest() {
        // Arrange
        Person person1 = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        Person person2 = new Person("Marianne", "Bosma", 'V', 40);
        List<Person> children = new ArrayList<>(); // zussen worden in
        children.add(person2);
        person1.setSiblings(children); // setterfunctie meegetest
        // Act
        List<Person> siblings = person1.getSiblings();
        // Assert
        assertEquals(children, siblings);
    }

    @Test
    void addChildTest() {
        father.addChild(father, me);
        father.addChild(father, sister);
        assertEquals("Marjet", father.getChildren().get(0).getName()); // get(0): eerste index van de lijst
        assertEquals(2, father.getChildren().size());
    }

    @Test
    void addSiblingTest() {
        me.addSibling(me, sister);
        assertEquals("Marianne", me.getSiblings().get(0).getName());
        assertEquals(1, me.getSiblings().size());
    }

    @Test
    void addParents() {
        me.addParents(father, mother, me);
        assertEquals(father, me.getFather()); // manier 1
        assertEquals("Johanna", me.getMother().getName()); // manier 2
    }

    @Test
    void addPartnerTest() {
        me.addPartner(me, wife);
        assertEquals(me.getPartner(), wife);
        assertEquals(wife.getPartner(), me);
    }

    // Deze lukt me niet... Ergens mis ik iets, maar ik kom er maar niet achter.
    @Test
    void getGrandchildrenTest() {
        // Arrange
        Person grandparent = new Person("Johanna", "Bonsma", 'V', 68); // Mijn moeder
        Person parent = new Person("Marianne", "Bosma", 'V', 40); // Mijn zus, gekozen omdat zij twee kinderen heeft, zodat je de lijst kan vullen met meer dan 1 item.
        Person child1 = new Person("Eva", "Johanna", "Veldhuizen", 'V', 8); // Oudste dochter van mijn zus
        Person child2 = new Person("Rosa", "Tooske", "Veldhuizen", 'V', 5); // Jongste dochter van mijn zus


        parent.addChild(parent, child1);
        parent.addChild(parent, child2);
        grandparent.addChild(grandparent, parent);

        List<Person> grandchildren = grandparent.getGrandchildren(grandparent);

        // Act
        List<Person> expectedGrandchildren = new ArrayList<>();
        expectedGrandchildren.add(child1);
        expectedGrandchildren.add(child2);
        // Assert
        assertEquals(expectedGrandchildren, grandchildren);
    }

    @Test
    void addPetTest1() { // Deze is geschreven tijdens de huiswerkklas
        me.addPet(me, cat);
        assertEquals("Firsa", me.getPets().get(0).getName());
    }

    @Test
    void addPetTest2() { // Ik wilde voor mijn eigen begrip ook nog even een andere manier proberen die iets leesbaarder is
        // Arrange (naast onderstaande pets gebruik ik person "me" zoals gedeclareerd bij ForEach bovenaan.
        Pet pet1 = new Pet("Firsa", 17, "kat");
        Pet pet2 = new Pet("Kees", 15, "kat"); // Deze kat is van mijn zus, maar nu even zogenaamd van mij, zodat ik de lijst kan vullen met meer dan 1 huisdier.
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        // Act
        me.addPet(me, pet1);
        me.addPet(me, pet2);
        // Assert
        assertEquals(pets, me.getPets()); // Getterfunctie wordt ook meegetest
    }

}