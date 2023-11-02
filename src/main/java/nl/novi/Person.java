package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother;
    private Person father;
    private Person partner;
    private List<Person> siblings;
    private List<Person> children;
    private List<Person> grandchildren;
    private List<Pet> pets;


    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }
    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }
    
    public String getName() { return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person getPartner() { return partner; }

    public void setPartner(Person partner) { this.partner = partner;}

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person father, Person mother, Person child) {
        child.setFather(father);
        child.setMother(mother);
        father.addChild(father, child); // verbindt ouders met kinderen
        mother.addChild(mother, child);
    }

    public void addChild(Person parent, Person child) {
        List<Person> children = new ArrayList<>();
        if (parent.getChildren() != null) {
            for (Person p : parent.getChildren()) {
                children.add(p); // bestaande kinderen toevoegen aan lijst
            }
        } children.add(child); // nieuwe kinderen toevoegen
        parent.setChildren(children);
    }

    public void addPet(Person person, Pet pet) {
        List<Pet> pets = new ArrayList<>();
        if (person.getPets() != null) {
            for (Pet owner : getPets()) {
                pets.add(owner);
            }
        } pets.add(pet);
        person.setPets(pets);
    }

    public void addSibling(Person person, Person sibling) {
        List<Person> siblings = new ArrayList<>();
        if (person.getSiblings() != null) {
            for (Person p : person.getSiblings()) {
                siblings.add(person);
            }
        } siblings.add(sibling);
        person.setSiblings(siblings);
    }

    // Bonusopdracht 3
    public void addPartner(Person person, Person partner){
        if(person.getPartner() == null && partner.getPartner() == null){ // als er nog geen partner is
            person.setPartner(partner); // koppelt partner en person wederzijds
            partner.setPartner(person);
        }
    }

    // Onderstaande methode is gedaan tijdens de huiswerkklas, en toen kon ik het volgen, maar teruglezend vind ik het nog heel moeilijk te doorgronden. Dat is waarschijnlijk ook de reden waarom ik de bijbehorende testen ook niet goed krijg...

//    public void setGrandchildren(List<Person> grandchildren) {
//        this.grandchildren = grandchildren;
//    }
    public List<Person> getGrandchildren(Person grandparent) {
        List<Person> grandchildren = new ArrayList<>();
        if (grandparent.getChildren() != null) {
            for (Person child : grandparent.getChildren()) {
                if (child.getChildren() != null) {
//                    for (Person grandchild : child.getChildren()) {
//                        grandchildren.add(grandchild);
//                    }
                    grandchildren.addAll(child.getChildren());
                }
            }
        }
        return grandchildren;
    }
    // Er zijn overigens in totaal drie kleinkinderen, 1 van mij en 2 van mijn zus. Maar hoe je dat nu hierin zou moeten verwerken?
}
