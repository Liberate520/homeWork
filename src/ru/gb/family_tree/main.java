package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.family_tree.writer.FileHandler;
import java.time.LocalDate;
public class main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        LocalDate kuanishKaliBirthdate = LocalDate.of(1928, 2, 2);
        LocalDate kuanishKaliDeathdate = LocalDate.of(1998, 5, 12);
        LocalDate serikBirthdate = LocalDate.of(1949, 2, 2);
        LocalDate serikDeathdate = LocalDate.of(2018, 6, 18);
        LocalDate talgatBirthdate = LocalDate.of(1954, 5, 15);
        LocalDate talgatDeathdate = LocalDate.of(2000, 7, 25);
        LocalDate zubarzhatBirthDate = LocalDate.of(1949, 12, 14);
        LocalDate muratBirthdate = LocalDate.of(1980, 12, 7);
        LocalDate gulmiraBirthdate = LocalDate.of(1971, 7, 25);

        Human grandpa = new Human("Grandpa_KuanishKali", kuanishKaliBirthdate, kuanishKaliDeathdate, Gender.Male,null,null);
        Human daddy = new Human("Talgat", talgatBirthdate, talgatDeathdate, Gender.Male,null,grandpa);
        Human father = new Human("Serik", serikBirthdate, serikDeathdate, Gender.Male,null,grandpa);
        Human mother = new Human("Zubarzhat", zubarzhatBirthDate, Gender.Female,null,null);
        Human murat = new Human("Murat",muratBirthdate,Gender.Male,mother,father);
        Human gulmira = new Human("Gulmira",gulmiraBirthdate, Gender.Female,mother,father);
        grandpa.addChild(father);
        grandpa.addChild(daddy);

        //  Семейное древо добавление
        familyTree.addToFamilyTree(grandpa);
        familyTree.addToFamilyTree(daddy);
        familyTree.addToFamilyTree(father);
        familyTree.addToFamilyTree(mother);
        familyTree.addToFamilyTree(murat);
        familyTree.addToFamilyTree(gulmira);

        // Вывод информации о древе
        printFamilyTree(familyTree);
//        System.out.println("Проверка метода поиска по имени Murat");
//        System.out.println(familyTree.getByName("Murat"));

        // Serialize для ДЗ Семинара 2
//        System.out.println("вывод загруженного дерева из файла");
//        printFamilyTree(load());
//      save(familyTree);
        // Sort для ДЗ Семинара 3
        familyTree.sortByName();
        System.out.println("После сортировки по имени");
        printFamilyTree(familyTree);
        System.out.println("После сортировки по возрасту");
        familyTree.sortByAge();
        printFamilyTree(familyTree);
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
    static void printFamilyTree(FamilyTree familytree) {
        System.out.println(familytree);
    }
}
