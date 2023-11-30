package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;
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
        familyTree.addHumanToFamilyTree(grandpa);
        familyTree.addHumanToFamilyTree(daddy);
        familyTree.addHumanToFamilyTree(father);
        familyTree.addHumanToFamilyTree(mother);
        familyTree.addHumanToFamilyTree(murat);
        familyTree.addHumanToFamilyTree(gulmira);

        // Вывод информации о древе
        printFamilyTree(familyTree);

        // Serialize для ДЗ Семинара 2
//        load();
//        save(familyTree);
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
