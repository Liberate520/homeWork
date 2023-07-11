package org.genealogy.model.person;

public class Dog extends Animal{
    private static int counter = 0;
    private int id;
    private String breed;
    private int weight;
    public Dog(String firstName) {
        super(firstName);
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (getDateOfDeath() != null) {
            return getId() + ", " + getName() + ", " + getBreed() + ", " + getWeight() + " kg, " + "(" + getDateOfBirth() + " - " + getDateOfDeath() + "), " + getGender();
        } else {
            return getId() + ", " + getName() + ", " + getBreed() + ", " + getWeight() + " kg, " + "(" + getDateOfBirth() + "), " + getGender();
        }
    }
}
