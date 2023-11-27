import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создаем экземпляры класса Human по одному из двух конструкторов без детей и с детьми

        Human son = new Human("Михаил","Черевиченко",Gender.MALE,
                LocalDate.of(2013,Month.OCTOBER,4),null);

        List<Human> list = new ArrayList<>();
        list.add(son);

        Human father = new Human("Сергей","Черевиченко",Gender.MALE,
                LocalDate.of(1981,Month.DECEMBER,10),null,list);

        Human mother = new Human("Елена","Черевиченко",Gender.FEMALE,
                LocalDate.of(1986,Month.MARCH,17),null,list);

        Human fathersSister = new Human("Ольга","Черевиченко",Gender.FEMALE,
                LocalDate.of(1978,Month.SEPTEMBER,19),null);
        list.clear();
        list.add(fathersSister);
        list.add(father);

        Human fathersMom = new Human("Гульниса","Черевиченко",Gender.FEMALE,
                LocalDate.of(1955,Month.APRIL,26),null,list);
        Human fathersFather = new Human("Николай","Черевиченко",Gender.MALE,
                LocalDate.of(1948,Month.NOVEMBER,20),null,list);

        Human mothersBrother = new Human("Валерий","Пузанев",Gender.MALE,
                LocalDate.of(1970,Month.APRIL,12),null);
        list.clear();
        list.add(mothersBrother);
        list.add(mother);

        Human mothersMom = new Human("Людмила","Краснова",Gender.FEMALE,
                LocalDate.of(1948,Month.NOVEMBER,18),null,list);
        Human mothersFather = new Human("Борис","Пузанев",Gender.MALE,
                LocalDate.of(1948,Month.SEPTEMBER,15),
                LocalDate.of(2003,Month.MARCH,15),list);
        Human child = new Human("Aнна","Черевиченко",Gender.FEMALE,
                LocalDate.of(2023,Month.NOVEMBER,15),null);

        // Создаем экземпляр класса FamilyTree добавляем всех Human и выводим
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(son);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(fathersSister);
        familyTree.addHuman(fathersMom);
        familyTree.addHuman(fathersFather);
        familyTree.addHuman(mothersBrother);
        familyTree.addHuman(mothersFather);
        familyTree.addHuman(mothersMom);
        familyTree.addHuman(child);


        familyTree.addChild("Елена","Черевиченко",child);
        familyTree.addChild("Сергей","Черевиченко",child);

        System.out.println("=========================");
        System.out.println(familyTree);

        System.out.println(familyTree.findChildren("Елена","Черевиченко"));
        System.out.println("======================");
        System.out.println(familyTree.findChildren("etuiwr","sdgf"));





    }

}
