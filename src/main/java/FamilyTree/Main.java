package FamilyTree;

import FamilyTree.Family.FamilyItem;
import FamilyTree.Family.FamilyTree;
import FamilyTree.Human.Human;
import FamilyTree.Human.Gender;
import FamilyTree.SaveLoad.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String file = "src/main/java/FamilyTree/SaveLoad/family.sav";
        FileHandler fl = new FileHandler();

//        FamilyTree family = (FamilyTree) fl.load(file);

        Human olga = new Human("Ольга","Петрова", LocalDate.of(1992, 10, 16), Gender.Female );
        Human tamara = new Human("Тамара","Иванова", LocalDate.of(1997, 02, 14), Gender.Female );
        Human anna = new Human("Анна","Силаева", LocalDate.of(1971, 02, 25), Gender.Female );
        Human kirill = new Human("Кирилл","Силаев", LocalDate.of(1970, 04, 27), Gender.Male );

        olga.setFather(kirill);
        tamara.setFather(kirill);
        olga.setMother(anna);
        tamara.setMother(anna);

        FamilyTree<FamilyItem> family = new FamilyTree<>();
        family.addToFamily(olga);
        family.addToFamily(tamara);
        family.addToFamily(anna);
        family.addToFamily(kirill);

//        fl.save(family, file);

        System.out.println(family.getFamilyInfo());

        family.sortByName();
        System.out.println(family.getFamilyInfo());

        family.sortByBirthdate();
        System.out.println(family.getFamilyInfo());
    }
}