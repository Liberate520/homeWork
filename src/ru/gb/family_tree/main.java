package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.model.FamilyTree;
import ru.gb.family_tree.family_tree.model.Service.Service;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.model.writer.FileHandler;
import java.time.LocalDate;
public class main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addHuman("Grandpa_KuanishKali",Gender.Male,LocalDate.of(1928, 02, 2),LocalDate.of(1998, 5, 12),null,null);
        service.addHuman("Talgat",Gender.Male,LocalDate.of(1954, 5, 15),LocalDate.of(2000, 7, 25),null,null);
        service.addHuman("Serik",Gender.Male, LocalDate.of(1949, 2, 2), LocalDate.of(2018, 6, 18),null,null);
        service.addHuman("Zubarzhat",Gender.Female,LocalDate.of(1949, 12, 14),null,null);
        service.addHuman("Murat",Gender.Male,LocalDate.of(1980, 12, 7),null,null);
        service.addHuman("Gulmira",Gender.Female,LocalDate.of(1971, 7, 25),null,null);
        service.printFamilyTree();
        service.getFamilytree().sortByName();
        System.out.println("После сортировки по имени");
        service.printFamilyTree();
        service.getFamilytree().sortByAge();
        System.out.println("После сортировки по возрасту");
        service.printFamilyTree();
        System.out.println();

//        System.out.println("Проверка метода поиска по имени Murat");
//        System.out.println(familyTree.getByName("Murat"));

        // Serialize для ДЗ Семинара 2
//        System.out.println("вывод загруженного дерева из файла");
//        printFamilyTree(load());
//      save(familyTree);
        // Sort для ДЗ Семинара 3
//        familyTree.sortByName();
//        System.out.println("После сортировки по имени");
//        printFamilyTree(familyTree);
//        System.out.println("После сортировки по возрасту");
//        familyTree.sortByAge();
//        printFamilyTree(familyTree);
    }


    private static FamilyTree load(){
        String filePath = "src/ru/gb/family_tree/writer/file";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.load(filePath);
    }
    private static void save(FamilyTree tree){
        String filePath = "src/ru/gb/family_tree/writer/file";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree,filePath);
    }
}
