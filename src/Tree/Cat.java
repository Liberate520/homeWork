package Tree;

public class Cat extends Pet {
   
    public Cat(String nickName, int age) {
        super(nickName, age);
    }

    @Override
    public void respond() {
        System.out.println("мяу - мяу - мяу");
    }

}
