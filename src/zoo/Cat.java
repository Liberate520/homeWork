package zoo;

public class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public void speak () {
        System.out.println("Myau-myau");
    }

}
