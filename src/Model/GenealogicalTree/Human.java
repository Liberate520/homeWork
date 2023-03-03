package Model.GenealogicalTree;

public class Human extends Animal {

    public Human(int id, String name, Sex sex, int birthYear) {
        super(id, name, sex, birthYear);
    }

    public Human(int id, String name, Sex sex, int birthYear, 
    Human father, Human mother) {
        super(id, name, sex, birthYear, father, mother);
    }
}