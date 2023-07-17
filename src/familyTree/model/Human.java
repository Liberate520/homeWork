package familyTree.model;

public class Human extends Animal {
    private static final long serialVersionUID = 1L;

    public Human(String name, String sex, int age) {
        super(name, sex, age);
    }

    public Human(String name, String sex, int age, Animal mather, Animal father) {
        super(name, sex, age, mather, father);
    }
}
