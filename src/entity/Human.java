package entity;

public class Human extends Mammal {

    public Human(int id, String name, String gender, Mammal father, Mammal mother) {
        super(id, name, gender, father, mother);
        setType("human");
    }

    public Human(int id, String name, String gender) {
        super(id, name, gender);
        setType("human");
    }

}
