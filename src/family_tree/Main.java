package family_tree;

import Human.Human;
import Tree.familyTree;

import java.time.LocalDate;

import static Human.Gender.Female;
import static Human.Gender.Male;

public class Main {
    public static void main(String[] args) {
        familyTree Starki = new familyTree();
        Human Eddard = new Human("Eddard Stark", LocalDate.of(1234,12,5),Male);
        Human Catelyn = new Human("Catelyn Stark", LocalDate.of(1244,11,19),Female);
        Human Robb = new Human("Robb Stark", LocalDate.of(1254,5,12),Male);
        Human Aria = new Human ("Aria Stark",LocalDate.of(1263,4,3),Female);
        Human Jon = new Human ("Jon Snow", LocalDate.of(1245,9,14),Male);
        Human Sansa = new Human("Sansa Stark", LocalDate.of(1246,12,24),Female);
        Human Eddard2 = new Human("Eddard Stark", LocalDate.of(1234,12,5),Male);
        Starki.addHuman(Eddard); // добавили объект
        Starki.addHuman(Catelyn); // добавили объект
        Starki.addHuman(Robb); // добавили объект
        Starki.addHuman(Aria); // добавили объект
        Starki.addHuman(Jon); // добавили объект
        Starki.addHuman(Sansa); // добавили объект
        Starki.addHuman(Eddard2); // Еще один Eddward. Не добавляется
        Eddard.setChild(Jon);      // Едварду добавили сына Роба, но так как он еще не супруг Кейтелин. У Джона только отец.
        Eddard.setChild(Jon);      // Проверка на добавление уже имеющегося ребенка.  НЕ добавляется.
        Eddard.setSpouse(Catelyn);  // Eddard супруг Catelyn
        Eddard.setChild(Robb);      // Едварду добавили сына Роба
        Catelyn.setChild(Aria);     // Кейтелин добавили дочь Арию.
        Catelyn.setChild(Sansa);    //Кейтелин добавили дочь Сансу
        System.out.printf(Jon.getParensts()); // Родители Джона
        System.out.printf(Robb.getParensts()); // Родители Роба
        System.out.printf(Catelyn.getChildren()); // У Кейтелин только 4 ребенка. Джона Сноу нет.
        System.out.printf(Eddard.getSpouse()); // У Едварда супруга Кейтелин
        System.out.printf(Starki.getInfoHuman()); // Вывод всех членов семьи Старков. 2 Эдаварда нет.
    }
}