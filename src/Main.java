import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human human = new Human("Василий","Иванович","Чапаев", null,null);
        Human human1 = new Human("Анна", "Григорьевна", "Ульянова", null, null);
        Human human2 = new Human("Петр", "Васильевич", "Чапаев", human,human1);
        Human human3 = new Human("Алина", "Васильевна", "Чапаев", human,human1);
        Human human4 = new Human("Елена", "Сергеевна", "Куролесова", null,null);
        Human human5 = new Human("Иван", "Петрович", "Чапаев", human2,human4);
        Human human6 = new Human("Федор", "Петрович", "Чапаев", human2,human4);
        Human human7 = new Human("Елена", "Петровна", "Чапаева", human2,human4);

        tree.addHuman(human);
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        tree.addHuman(human5);
        tree.addHuman(human6);
        tree.addHuman(human7);
//        System.out.println(tree);

        System.out.println(human2.getFullName());

    }
}

