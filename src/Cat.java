public class Cat extends Mammal {

    public Cat(String name, String gender, Mammal father, Mammal mother) {
        super(name, gender, father, mother);
        setType("cat");
    }

    public Cat(String name, String gender) {
        super(name, gender);
        setType("cat");
    }
}
