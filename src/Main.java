import java.time.LocalDate;

import familyTree.famTree.FamilyTree;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree myFamilyTree = new FamilyTree(123);

        Human human_1 = new Human("Иван", "Пупкин", LocalDate.of(1955,5,5), Gender.Male);
        Human human_2 = new Human("Петр", "Глобусов",  LocalDate.of(1944,4,4), Gender.Male);
        Human human_3 = new Human("Виктор", "Лопатов",  LocalDate.of(1933,3,3), Gender.Male);
        Human human_4 = new Human("Бушар", "Комбарович",  LocalDate.of(1922,2,2), Gender.Male);
        Human human_5 = new Human("Анастасия", "Загоняева",  LocalDate.of(1911,1,1), Gender.Femala);

        myFamilyTree.addHuman(human_1);
        myFamilyTree.addHuman(human_2);
        myFamilyTree.addHuman(human_3);
        myFamilyTree.addHuman(human_4);
        myFamilyTree.addHuman(human_5);

        System.out.println(myFamilyTree.getHumansInfo());
    }
}