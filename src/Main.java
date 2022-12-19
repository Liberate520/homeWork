//package    FamilyTree;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("FATHER", 1960, "male");
        Human human = new Human("Вася", father);
        Human human2 = new Human("children", human);
        System.out.println(human2.toString());
        System.out.println(human.toString());
        System.out.println(father.toString());
    }
}
