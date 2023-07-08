package ru.home.familyTree;

import ru.home.familyTree.family_Tree.FamilyTree;
import ru.home.familyTree.human.Gender;
import ru.home.familyTree.human.Human;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = buildTree();
        fileHandler.write(familyTree, "src/ru/home/familyTree/family_Tree/info.out");

//        FamilyTree familyTree = (FamilyTree) fileHandler.read("src/ru/home/familyTree/family_Tree/info.out");

        System.out.println(familyTree.getHumansInfo());
    }

       static FamilyTree buildTree(){
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Ivanov Aleksey Ivanovich", Gender.Male, LocalDate.of(1956, 12, 9),
                LocalDate.of(2018, 1, 24), null, null);
        Human human2 = new Human("Ivanova Alena Petrovna", Gender.Female, LocalDate.of(1959, 4, 11),
                null, null);
        Human human3 = new Human("Ivanova Irina Alekseevna", Gender.Female, LocalDate.of(1983, 9, 18),
                human1, human2);
        Human human4 = new Human("Ivanov Petr Petrovich", Gender.Male, LocalDate.of(2004, 8, 8),
                human3, null);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        return familyTree;
    }

}

