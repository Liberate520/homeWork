package ru.gb.family_tree.model.servise;

import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

import static ru.gb.family_tree.model.human.Human.Gender.Female;
import static ru.gb.family_tree.model.human.Human.Gender.Male;

public class TestData {
    public static FamilyTree testData() {

        FamilyTree familyTree = new FamilyTree();

        // создаем родителей
        Human mother = new Human("4А5810", "САФРОНОВА", "ЕКАТЕРИНА", Female, LocalDate.of(1984, 10, 20), null);
        familyTree.addHuman(mother);
//        mother.addPartner(familyTree.searchHuman("АЛЕКСЕЙ"));
        Human father = new Human("145G10", "САФРОНОВ", "АЛЕКСЕЙ", Male, LocalDate.of(1981, 11, 21), null);
        familyTree.addHuman(father);

        // создаем детей добавляя к ним родителей
        familyTree.addHuman(new Human("1DWG10", "Сафронов", "Николай", Male, LocalDate.of(2007, 5, 20),
                (LocalDate) null, (Human) familyTree.searchHuman("ЕКАТЕРИНА"), (Human) familyTree.searchHuman("АЛЕКСЕЙ")));
        familyTree.addHuman(new Human("246H10", "Сафронова", "Елена", Female, LocalDate.of(2010, 10, 10),
                (LocalDate) null, (Human) familyTree.searchHuman("ЕКАТЕРИНА"), (Human) familyTree.searchHuman("АЛЕКСЕЙ")));


        Human grandMother1 = new Human("RT473G", "ЕжовА", "МариЯ", Female, LocalDate.of(1958, 11, 21),
                LocalDate.of(2008, 11, 21));
        familyTree.addHuman(grandMother1);
        grandMother1.addKid((Human) familyTree.searchHuman("САФРОНОВА"));

        Human grandFather1 = new Human("SD473G", "ЕжоВ", "НиколаЙ", Male, LocalDate.of(1963, 3, 21),
                LocalDate.of(2023, 3, 21));
        familyTree.addHuman(grandFather1);
        grandFather1.addKid((Human) familyTree.searchHuman("ЕКАТЕРИНА"));


        Human grandMother2 = new Human("DH473G", "СафроновА", "Оксана", Female, LocalDate.of(1960, 3, 21), null);
        familyTree.addHuman(grandMother2);
        grandMother2.addKid((Human) familyTree.searchHuman("САФРОНОВ"));
//
        Human grandFather2 = new Human("DG573G", "СафроноВ", "Михаил", Male, LocalDate.of(1952, 11, 21), null);
        familyTree.addHuman(grandFather2);
        grandFather2.addKid((Human) familyTree.searchHuman("АЛЕКСЕЙ"));


//        System.out.println(familyTree.getTreeInfo());
//
//        System.out.println(grandMother1.toString());
//        System.out.println();
//        System.out.println(familyTree.searchHuman("МариЯ"));
//        System.out.println("------------------");
//        System.out.println(familyTree.searchHuman("SD473G"));
//        System.out.println("=================");
//        System.out.println(familyTree.searchHuman("Николай"));
//        System.out.println();

        return familyTree;
    }
}
