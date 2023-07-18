package familyTree;

import familyTree.SaveAndRead.FileHandler;
import familyTree.Human.Gender;
import familyTree.Human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
// Зпись в фаил
        String file = "familyTree.out";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = testTree();
        fileHandler.save(tree, file);
// Чтение из файла
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree)  fileHandler.read(file);
//        System.out.println(tree);


//        FamilyTree familyTree;
//        familyTree = new FamilyTree();
//        familyTree.add((FamilyTreeItem) new Human("Иванов", "Иван", Gender.Male, LocalDate.of(1980, 01, 01)));
//        familyTree.add((FamilyTreeItem) new Human("Иванова", "Дарья", Gender.Female, LocalDate.of(1980, 01, 02)));
//        familyTree.add((FamilyTreeItem) new Human("Петрова", "Светлана", Gender.Female, LocalDate.of(2000, 01, 01), (Human) familyTree.getByName("Иван"), (Human) familyTree.getByName("Дарья")));
//        familyTree.add((FamilyTreeItem) new Human("Иванов", "Павел", Gender.Male, LocalDate.of(2001, 01, 02), (Human) familyTree.getByName("Иван"), (Human) familyTree.getByName("Дарья")));

//        System.out.println(familyTree.getInfo());
////        familyTree.sortByName();
////        System.out.println(familyTree.getInfo());
    }
        static FamilyTree testTree() {
            FamilyTree familyTree;
            familyTree = new FamilyTree();
            Human ivan = new Human("Иванов", "Иван", Gender.Male, LocalDate.of(1980, 01, 01));
            Human dasha = new Human("Иванова", "Дарья", Gender.Female, LocalDate.of(1980, 01, 02));
            Human sveta = new Human("Абрамова", "Светлана", Gender.Female, LocalDate.of(2000, 01, 01), (Human) familyTree.getByName("Иван"), (Human) familyTree.getByName("Дарья"));
            Human pasha = new Human("Иванов", "Павел", Gender.Male, LocalDate.of(2001, 01, 02), (Human) familyTree.getByName("Иван"), (Human) familyTree.getByName("Дарья"));
            familyTree.add((FamilyTreeItem) ivan);
            familyTree.add((FamilyTreeItem) dasha);
            familyTree.add((FamilyTreeItem) sveta);
            familyTree.add((FamilyTreeItem) pasha);

            System.out.println("Первоначальные данные: \n" + familyTree.getInfo());
            familyTree.sortBySurname();
            System.out.println("Сортировка по Фамилии: \n" + familyTree.getInfo());
            familyTree.sortByName();
            System.out.println("Сортировка по Имени: \n" + familyTree.getInfo());
            familyTree.sortByAge();
            System.out.println("Сортировка по Возрасту: \n" + familyTree.getInfo());

            return familyTree;
        }
}