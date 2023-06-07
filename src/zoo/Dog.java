package zoo;

public class Dog extends Animal{

    public Dog (String name) {
        this.name = name;
    }
    @Override
    public void speak () {
        System.out.println("Wof-wof");
    }
}
