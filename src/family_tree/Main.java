package family_tree;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree family_1 = new Tree("Каруселевы");
        Human vanya_1 = new Human("Иван", "Каруселев", "Петрович", LocalDate.of(1985, 5, 24), Gender.male);
        Human olya_1 = new Human("Ольга", "Кирова", "Александровна", LocalDate.of(1987, 12, 29), Gender.female);
        Human kostya_0 = new Human("Константин", "Каруселев", "Иванович", LocalDate.of(2009, 9, 29), Gender.male);
        Human petya_0 = new Human("Петр", "Каруселев", "Георгиевич", LocalDate.of(2006, 7, 15), Gender.male);
        Human masha_0 = new Human("Мария", "Каруселева", "Ивановна", LocalDate.of(2015, 6, 5), Gender.female);
        Human katya_0 = new Human("Екатерина", "Каруселева", "Дмитриевна", LocalDate.of(2007, 8, 12), Gender.female);
        Human petya_2 = new Human("Петр", "Кузнецов", "Олегович", LocalDate.of(1947, 12, 7), Gender.male);
        Human dasha_2 = new Human("Дарья", "Каруселева", "Владимировна", LocalDate.of(1954, 6, 15), Gender.female);
        Human oleg_2 = new Human("Олег", "Каруселев", "Игоревич", LocalDate.of(1956, 9, 19), Gender.male);
        family_1.addFamilyMember(vanya_1);
        family_1.addFamilyMember(olya_1);
        family_1.addFamilyMember(kostya_0);
        family_1.addFamilyMember(petya_0);
        family_1.addFamilyMember(masha_0);
        family_1.addFamilyMember(katya_0);
        family_1.addFamilyMember(petya_2);
        family_1.addFamilyMember(dasha_2);
        family_1.addFamilyMember(oleg_2);
        vanya_1.addParent(petya_2, Parent_Type.Biological_Father);
        vanya_1.addParent(dasha_2, Parent_Type.Biological_Mother);
        vanya_1.addParent(oleg_2, Parent_Type.Foster_Father);
        family_1.wedding(vanya_1, olya_1);
        olya_1.setSecondName("Каруселева");
        vanya_1.addChild(kostya_0, Child_type.Biological_Son);
        vanya_1.addChild(petya_0, Child_type.Foster_Son);
        vanya_1.addChild(masha_0, Child_type.Biological_Daughter);
        vanya_1.addChild(katya_0, Child_type.Foster_Daughter);
        olya_1.addChild(kostya_0, Child_type.Biological_Son);
        olya_1.addChild(petya_0, Child_type.Foster_Son);
        olya_1.addChild(masha_0, Child_type.Biological_Daughter);
        olya_1.addChild(katya_0, Child_type.Foster_Daughter);
        System.out.println(family_1);
        FileHandler fh = new FileHandler();
        fh.save(family_1, family_1.getFamilyName());
//        Tree family_1 = fh.read("Каруселевы.out");
//        System.out.println(family_1);
    }
}
