
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Иван", "Иванов");
        Human human2 = new Human("Елизавета", "Попова");
        Human human3 = new Human("Петр", "Иванов");
        human1.addChild(human3);
        human2.addChild(human3);
        human3.addParents(human1, human2);
        System.out.println(human3);
        System.out.print("Родители:\n" + human3.getFather() + "\n" + human3.getMother());
        
    }
}
