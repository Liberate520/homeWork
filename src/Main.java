//В проекте с гениалогическим древом подумайте и используйте интерфейсы.
//        Дополнить проект методами записи в файл и чтения из файла.
//        Для этого создать отдельный класс и реализовать в нем нужные методы.
//        Для данного класса сделайте интерфейс, который и используйте в своей программе.
//        Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.
//        Поправить замечания к первому уроку

import family_tree.FileHandler;
import family_tree.Gender;
import family_tree.Person;
import family_tree.Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree familyTree = new Tree();

        Person grandmotherF = new Person("FathersMom", LocalDate.of(1901, 01, 01), LocalDate.of(2000, 01, 01), Gender.Female);
        Person grandmotherM = new Person("MothersMom", LocalDate.of(1900, 01, 01), LocalDate.of(1999, 01, 01), Gender.Female);
        Person grandfatherM = new Person("MothersFather", LocalDate.of(1900, 01, 01), Gender.Male);
        grandmotherM.setPartner(grandfatherM);
        Person motherBrother = new Person("MotherBrother", LocalDate.of(1960, 01, 01), Gender.Male, grandmotherM, grandfatherM);
        Person mother = new Person("Mother", LocalDate.of(1955, 01, 01), Gender.Female, grandmotherM, grandfatherM);
        Person father = new Person("Father", LocalDate.of(1965, 01, 01), Gender.Male, grandmotherF, null);
        mother.setPartner(father);
        Person child1 = new Person("FirstChild", LocalDate.of(2000, 01, 01), Gender.Female, mother, father);
        Person child2 = new Person("SecondChild", LocalDate.of(2001, 01, 01), Gender.Male, mother, father);

        familyTree.add(grandfatherM);
        familyTree.add(grandmotherM);
        familyTree.add(grandmotherF);
        familyTree.add(motherBrother);
        familyTree.add(mother);
        familyTree.add(father);
        familyTree.add(child1);
        familyTree.add(child2);

        familyTree.reviseDependencies();

        System.out.println(familyTree);

        String path = "src/family_tree/familyTree.out";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, path);
        Tree familyTreeFromFile = (Tree) fileHandler.read(path);
        System.out.println(familyTreeFromFile);

    }

}
