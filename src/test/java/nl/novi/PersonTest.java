package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person me;
    Person father;
    Person mother;
    Person sister;
    Person daughter;
    Pet cat;

    @BeforeEach
    void setUp() {
        me = new Person("Marjet", "Johanna", "Bosma", 'V', 42);
        father = new Person("Christiaan", "Frederik", "Bosma", 'M', 68);
        mother = new Person("Johanna", "Bonsma", 'V', 68);
        sister = new Person("Marianne", "Bosma", 'V', 40);
        daughter = new Person("Hannah", "Esther", "Daalder", 'V', 10);
        cat = new Pet("Firsa", 17, "kat");

    }

    @Test
    void getName() {
        // Act
        String getName = me.getName();
        // Assert
        assertEquals("Marjet", getName);
    }

    @Test
    void setName() {
        me.setName("Johanna");
        String getName = me.getName();
        assertEquals("Johanna", getName);
    }

    @Test
    void getMiddleName() {
        // Act
        String getMiddleName = me.getMiddleName();
        // Assert
        assertEquals("Johanna", getMiddleName);
    }

    @Test
    void setMiddleName() {
        me.setMiddleName("Marianne");
        String getMiddleName = me.getMiddleName();
        assertEquals("Marianne", getMiddleName);
    }

    @Test
    void getLastName() {
        // Act
        String getLastName = me.getLastName();
        // Assert
        assertEquals("Bosma", getLastName);
    }

    @Test
    void setLastName() {
        me.setLastName("Daalder");
        String getLastName = me.getLastName();
        assertEquals("Daalder", getLastName);
    }

    @Test
    void getSex() {
        char getSex = me.getSex();
        assertEquals('V', getSex);
    }

    @Test
    void setSex() {
        me.setSex('M');
        char getSex = me.getSex();
        assertEquals('M', getSex);
    }

    @Test
    void getAge() {
        int getAge = me.getAge();
        assertEquals(42, getAge);
    }

    @Test
    void setAge() {
        me.setAge(43);
        int getAge = me.getAge();
        assertEquals(43, getAge);
    }

    @Test
    void getMother() {

    }

    @Test
    void setMother() {
    }

    @Test
    void getFather() {
    }

    @Test
    void setFather() {
    }

    @Test
    void getSiblings() {
    }

    @Test
    void setSiblings() {
    }

    @Test
    void getChildren() {
    }

    @Test
    void setChildren() {
    }

    @Test
    void getPets() {
    }

    @Test
    void setPets() {
    }

    @Test
    void setGrandchildren() {
    }

    @Test
    void getGrandchildren() {
    }

    @Test
    void addParents() {
        me.addParents(father, mother, me);
        assertEquals(father, me.getFather());
        assertEquals("Johanna", me.getMother().getName());
    }

    @Test
    void addChild() {
        father.addChild(father, me);
        father.addChild(father, sister);
        assertEquals("Marjet", father.getChildren().get(0).getName()); // get(0): eerste index van de lijst
        assertEquals(2, father.getChildren().size());
    }

    @Test
    void addPet() {
        me.addPet(me, cat);
        assertEquals("Firsa", me.getPets().get(0).getName());
    }

    @Test
    void addSibling() {
        me.addSibling(me, sister);
        assertEquals("Marianne", me.getSiblings().get(0).getName());
        assertEquals(1, me.getSiblings().size());
    }
}