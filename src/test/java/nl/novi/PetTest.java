package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet1;
    Pet pet2;

    @BeforeEach
    void setUp() {
        pet1  = new Pet("Firsa", 17, "kat");
        pet2 = new Pet("Kees", 15, "kat");
    }


    @Test
    void getNameTest() {
        // Act
        String getName = pet1.getName();
        // Assert
        assertEquals("Firsa", getName);
    }

    @Test
    void setNameTest() {
        // Act
        pet2.setName("Kees");
        String getName = pet2.getName();
        // Assert
        assertEquals("Kees", getName);
    }

    @Test
    void getAgeTest() {
        int getAge = pet1.getAge();
        assertEquals(17, getAge);
    }

    @Test
    void setAgeTest() {
        pet2.setAge(15);
        int getAge = pet2.getAge();
        assertEquals(15, getAge);
    }
    @Test
    void getSpeciesTest() {
        String getSpecies = pet1.getSpecies();
        assertEquals("kat", getSpecies);
    }

    @Test
    void setSpeciesTest() {
        pet2.setSpecies("kat");
        String getSpecies = pet2.getSpecies();
        assertEquals("kat", getSpecies);
    }
}