package HW_4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DowloadData data = new DowloadData();
        FamilyTree<Human> familyIvanov = new FamilyTree();

        Human motherIvanov = new Human("Мария", Gender.female,LocalDate.of(1975,7,6));
        Human fatherIvanov = new Human("Иван", Gender.male,LocalDate.of(1969,11,17));
        Human childIvanov1 = new Human("Петр", motherIvanov, fatherIvanov, Gender.male, LocalDate.of(2000,1,23), null);
        Human childIvanov2 = new Human("Алиса", motherIvanov, fatherIvanov, Gender.female, LocalDate.of(2002,9,15), null);
        Human childIvanov3 = new Human("Костя", motherIvanov, fatherIvanov, Gender.male, LocalDate.of(2005,5,13), null);
        Human childIvanov4 = new Human("Саша", null, childIvanov3, Gender.male, LocalDate.of(2008,3,3), null);

        familyIvanov.addHuman(motherIvanov);
        familyIvanov.addHuman(fatherIvanov);
        familyIvanov.addHuman(childIvanov1);
        familyIvanov.addHuman(childIvanov2);
        familyIvanov.addHuman(childIvanov3);
        familyIvanov.addHuman(childIvanov4);


        data.save(familyIvanov, "familyIvanov.bin");

        FamilyTree<Human> familySidorov = new FamilyTree();

        Human motherSidorov = new Human("Жанна", Gender.female,LocalDate.of(1975,7,6));
        Human fatherSidorov = new Human("Жорж", Gender.male,LocalDate.of(1974,9,16));
        Human childSidorov = new Human("Николай", motherSidorov, fatherSidorov, Gender.male, null, null);

        familySidorov.addHuman(motherSidorov);
        familySidorov.addHuman(fatherSidorov);
        familySidorov.addHuman(childSidorov);

        data.save(familySidorov, "familySidorov.bin");

        FamilyTree<Human> family1 = data.load("familyIvanov.bin");
        FamilyTree<Human> family2 = data.load("familySidorov.bin");


//        family1.getHumanList().sort(new ComparatorByName());
//
//        System.out.println(family1);
//
//        family1.getHumanList().sort(new ComparatorByBirthday());

        System.out.println(familyIvanov);
        familyIvanov.removeHuman(childIvanov3);
        System.out.println(familyIvanov);


    }

}
