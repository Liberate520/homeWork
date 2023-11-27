package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /*
        familyTree - этот объект будет в единственном экземпляр,
        а уже внутри него будет ArrayList, т.е. список из людей
         */
        FamilyTree familyTree = new FamilyTree();

        //создаем объекты human и каждого добавляем в familyTree
        Human human1 = new Human("Иванов Иван Иванович", Gender.Male, LocalDate.of(1984, 12, 31));
        familyTree.addHuman(human1);

        Human human2 = new Human("Петров Петр Петрович", Gender.Male, LocalDate.of(1976, 06, 11));
        familyTree.addHuman(human2);

        Human human3 = new Human("Семенов Семен Семенович", Gender.Male, LocalDate.of(1964, 01, 16));
        familyTree.addHuman(human3);

        Human human4 = new Human("Венедиктов Венедикт Венедиктович", Gender.Male, LocalDate.of(1949, 12, 3), LocalDate.of(2000, 07, 9));
        familyTree.addHuman(human4);

        Human human5 = new Human("Стаценко Елена Геннадьевна", Gender.Male, LocalDate.of(1952, 04, 26));
        familyTree.addHuman(human5);

        //добавим родителей
        human2.setFather(human4);
        human2.setMother(human5);


        //выведем фамильное древо
        System.out.println(familyTree);

        //перенести в FamilyTree
        System.out.println("Всего людей создано: " + Human.getCounter());


    }
}
