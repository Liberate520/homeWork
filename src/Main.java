public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Никита", 33);
        Human human2 = new Human("Георгий", 32);
        human1.addChildren(human2);
        System.out.println(human1.getChild());
    }
}
