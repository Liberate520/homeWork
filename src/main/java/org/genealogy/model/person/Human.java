package org.genealogy.model.person;

public class Human extends Animal {
    private static int counter = 0;
    private int id;
    private String lastName;
    public Human(String firstName, String lastName) {
        super(firstName);
        this.id = counter++;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        if (getDateOfDeath() != null) {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getDateOfBirth() + " - " + getDateOfDeath() + "), " + getGender();
        } else {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getDateOfBirth() + "), " + getGender();
        }
    }
}
