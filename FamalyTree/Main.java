package homeWork.FamalyTree;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamalyTree famalyTree = new FamalyTree();
        Human humman1 = new Human("Сергей", "Петров", LocalDate.of(1963, 05, 17), Gender.Male);
        Human humman2 = new Human("Мария", "Петрова", LocalDate.of(1965,03,11), LocalDate.of(1999,04,18), Gender.Female);        
        Human humman3 = new Human("Василий", "Петов", LocalDate.of(1986, 10, 30), null, Gender.Male, humman1, humman2);
        famalyTree.addHumman(humman1);
        famalyTree.addHumman(humman2);        
        famalyTree.addHumman(humman3);
        humman2.addChild(humman3);
        humman1.addChild(humman3);
        
        File file = new File("homeWork\\FamalyTree\\Hanler.txt");
        // famalyTree.SaveData(famalyTree, file);
        famalyTree.LoadDate(famalyTree, file);
        // System.out.println(famalyTree);
        
    }
}
