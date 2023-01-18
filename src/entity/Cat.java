package entity;

public class Cat extends Mammal {

    public Cat(int id, String name, String gender, Mammal father, Mammal mother) {
        super(id, name, gender, father, mother);
        setType("cat");
    }

    public Cat(int id, String name, String gender) {
        super(id, name, gender);
        setType("cat");
    }
}
