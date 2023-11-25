package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        LocalDate kuanishKaliBirthdate = LocalDate.of(1928, 2, 02);
        LocalDate kuanishKaliDeathdate = LocalDate.of(1998, 5, 12);
        LocalDate serikBirthdate = LocalDate.of(1949, 2, 02);
        LocalDate serikDeathdate = LocalDate.of(2018, 6, 18);
        LocalDate talgatBirthdate = LocalDate.of(1954, 5, 15);
        LocalDate talgatDeathdate = LocalDate.of(2000, 7, 25);
        LocalDate zubarzhatBirthDate = LocalDate.of(1949, 12, 14);
        LocalDate muratBirthdate = LocalDate.of(1980, 12, 07);
        LocalDate gulmiraBirthdate = LocalDate.of(1971, 07, 25);

        Human grandpa = new Human("Grandpa_KuanishKali", kuanishKaliBirthdate, kuanishKaliDeathdate, Gender.Male);
        Human daddy = new Human("Talgat", talgatBirthdate, talgatDeathdate, Gender.Male);
        Human father = new Human("Serik", serikBirthdate, serikDeathdate, Gender.Male);
        Human mother = new Human("Zubarzhat", zubarzhatBirthDate, Gender.Female);
        Human murat = new Human("Murat",muratBirthdate,Gender.Male);
        Human gulmira = new Human("Gulmira",gulmiraBirthdate, Gender.Female);

        Children children = new Children();  // Дети 1-поколение
        children.addMember(father);
        children.addMember(daddy);
        Children children2 = new Children();  // Дети 2 поколение
        children2.addMember(murat);
        children2.addMember(gulmira);

        //  Семейное древо добавление
        familyTree.addHumanToFamilyTree(grandpa, children);
        familyTree.addHumanToFamilyTree(father, children2);
        familyTree.addHumanToFamilyTree(mother, children2);


        // Вывод информации о древе

        printFamilyTree(familyTree);
    }

    static void printFamilyTree(@org.jetbrains.annotations.NotNull FamilyTree familyTree) {
        for (Map.Entry<Human, Children> entry : familyTree.getFamilyMap().entrySet()) {
            Human parent = entry.getKey();
            Children children = entry.getValue();

            System.out.println("Parent: " + parent.getName() + ", Age: " + parent.getAge());

            for (Human child : children.getMembers()) {
                System.out.println("  Child: " + child.getName() + ", Age: " + child.getAge());
            }
        }
    }
}
