package ru.gb.family_tree.Servise;

import ru.gb.family_tree.Tree.FamilyTree;
import ru.gb.family_tree.Human.Human;

import java.time.LocalDate;

import static ru.gb.family_tree.Human.Human.Gender.Female;
import static ru.gb.family_tree.Human.Human.Gender.Male;

public class TestData {
    public static FamilyTree testData() {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("1DWG10", "Сафронов", "Николай", Male, LocalDate.of(2005, 5, 20),
                (LocalDate) null, familyTree.searchHuman("ЕКАТЕРИНА"), familyTree.searchHuman("АЛЕКСЕЙ"));

        Human human2 = new Human("246H10", "Сафронова", "Елена", Female, LocalDate.of(2010, 10, 10),
                null, familyTree.searchHuman("ЕКАТЕРИНА"), familyTree.searchHuman("АЛЕКСЕЙ"));

        Human human4 = new Human("4А5810", "САФРОНОВА", "ЕКАТЕРИНА", Female, LocalDate.of(1982, 10, 20), null);

        Human human3 = new Human("145G10", "САФРОНОВ", "АЛЕКСЕЙ", Male, LocalDate.of(1978, 11, 21), null);

        Human human5 = new Human("RT473G", "ЕжовА", "МариЯ", Female, LocalDate.of(1958, 11, 21),
                LocalDate.of(2008, 11, 21));

        Human human6 = new Human("SD473G", "ЕжоВ", "НиколаЙ", Male, LocalDate.of(1963, 3, 21),
                LocalDate.of(2023, 3, 21));

        Human human7 = new Human("DH473G", "СафроновА", "МариЯ", Female, LocalDate.of(1964, 3, 21), null);
        human7.addKid(familyTree.searchHuman("САФРОНОВА"));

        familyTree.addHuman(new Human("DG573G", "СафроноВ", "НиколаЙ", Male, LocalDate.of(1952, 11, 21), null));

        familyTree.addHuman(human1); // ребенок 1
        familyTree.addHuman(human2); // ребенок 2
        familyTree.addHuman(human3); // мать
        familyTree.addHuman(human4); // отец
        familyTree.addHuman(human5); // бабушка по линии матери
        familyTree.addHuman(human6); // дед по линии матери
        familyTree.addHuman(human7);

//        System.out.println(familyTree.getTreeInfo());

//        System.out.println(human5.toString());
//        System.out.println();
//        System.out.println(familyTree.searchHuman("МариЯ"));
//        System.out.println("------------------");
//        System.out.println(familyTree.searchHuman("SD473G"));
//        System.out.println("=================");
//        System.out.println(familyTree.searchHuman("Николай"));

        return familyTree;
    }
}
