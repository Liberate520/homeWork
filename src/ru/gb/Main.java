package ru.gb;

import java.time.LocalDate;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();


        Human human7 = new Human("Степанова Евгения Сергеевна", LocalDate.of(1892, 4, 1),
                LocalDate.of(1944, 2, 22),null, null, Gender.Female, null);

        Human human6 = new Human("Чемезов Иван Валерьевич", LocalDate.of(1890, 1, 1),
                LocalDate.of(1942, 1, 2),null, null, Gender.Male, null);

        Human human5 = new Human("Сергеева Лариса Александровна", LocalDate.of(1931, 5, 6),
                LocalDate.of(2001, 4, 10),null, null, Gender.Female, null);

        Human human4 = new Human("Иванов Владимир Алексеевич", LocalDate.of(1930, 4, 7),
                LocalDate.of(2000, 8, 9),null, null, Gender.Male, null);

        Human human3 = new Human("Чемезова Светлана Сергеевна", LocalDate.of(1962, 3, 12),
                null,human6, human7, Gender.Female, null);

        Human human2 = new Human("Иванов Сергей Владимирович", LocalDate.of(1960, 1, 10),
                null,human4, human5, Gender.Male, null);

        Human human1 = new Human("Иванов Иван Сергеевич", LocalDate.of(1990, 5, 15),
                null,human2, human3, Gender.Male, null);


        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);


        System.out.println(familyTree.getHumanListInfo());
    }

}
