import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> snils = new ArrayList();

        Family_tree myFamily = new Family_tree();

        Human human1 = new Human("123-563-128 22", "Кулиев", "Рафик", LocalDate.of(1980, 3, 11));
        Human human2 = new Human("123-563-127 22", "Кулиев", "Анатолий", LocalDate.of(1999, 5, 11));
        Human human3 = new Human("123-563-126 22", "Кулиев", "Ренат", LocalDate.of(2001, 1, 25));
        Human human4 = new Human("123-563-125 22", "Кулиева", "Вера", LocalDate.of(1944, 9, 23));
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);

        human1.AddMother(human4);
        System.out.println("----".repeat(5));
        System.out.println("Мама");
        System.out.println(human1.GetMother());

        System.out.println("----".repeat(5));
        human1.AddChildren(human2);
        human1.AddChildren(human3);
        System.out.println("Дети ");
        System.out.println(human1.GetChildren());


        System.out.println("----".repeat(5));
        System.out.println("Дерево ");
        myFamily.AddHuman(human1);
        myFamily.AddHuman(human2);
        myFamily.AddHuman(human4);
        System.out.println(myFamily.getHumanListInfo());
    }
}
