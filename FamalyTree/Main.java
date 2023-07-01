package homeWork.FamalyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamalyTree famalyTree = new FamalyTree();
        Human humman1 = new Human("Сергей", "Петров", LocalDate.of(1963,12,24), null, Gender.Male, null, null);
        Human humman2 = new Human("Мария", "Петрова", LocalDate.of(1965,03,11), LocalDate.of(1999,04,18), Gender.Female, null, null);        
        Human humman3 = new Human("Василий", "Петов", LocalDate.of(1986, 10, 30), null, Gender.Male, humman1, humman2);
        famalyTree.addHumman(humman1);
        famalyTree.addHumman(humman2);
        humman1.addChild(humman3);
        humman2.addChild(humman3);
        famalyTree.addHumman(humman3);

        System.out.println(humman2);
    }
}
