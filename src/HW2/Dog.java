package HW2;

public class Dog extends Pet{

    public Dog(String nickName, int age) {
        super(nickName, age);
    }

    @Override
    public void respond() {
        System.out.println("woof-woof-woof");
    }
}
