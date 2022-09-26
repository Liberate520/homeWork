import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создаем экземпляры класса Human по одному из двух конструкторов без детей и с детьми

        Human son = new Human("Михаил","Черевиченко",Gender.MALE,
                LocalDate.of(2013,Month.OCTOBER,4));
        List<Human> list = new ArrayList<>();
        list.add(son);

        Human father = new Human("Сергей","Черевиченко",Gender.MALE,
                LocalDate.of(1981,Month.DECEMBER,10),list);

        Human mother = new Human("Елена","Черевиченко",Gender.FEMALE,
                LocalDate.of(1986,Month.MARCH,17),list);

        Human fathersSister = new Human("Ольга","Черевиченко",Gender.FEMALE,
                LocalDate.of(1978,Month.SEPTEMBER,19));
        list.clear();
        list.add(fathersSister);
        list.add(father);

        Human fathersMom = new Human("Гульниса","Черевиченко",Gender.FEMALE,
                LocalDate.of(1955,Month.APRIL,26),list);
        Human fathersFather = new Human("Николай","Черевиченко",Gender.MALE,
                LocalDate.of(1948,Month.NOVEMBER,20),list);

        Human mothersBrother = new Human("Валерий","Пузанев",Gender.MALE,
                LocalDate.of(1970,Month.APRIL,12));
        list.clear();
        list.add(mothersBrother);
        list.add(mother);

        Human mothersMom = new Human("Людмила","Краснова",Gender.FEMALE,
                LocalDate.of(1948,Month.NOVEMBER,18),list);
        Human mothersFather = new Human("Борис","Пузанев",Gender.MALE,
                LocalDate.of(1948,Month.SEPTEMBER,15),
                mother.getChildren());

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
        System.out.println(familyTree);


    }

}
