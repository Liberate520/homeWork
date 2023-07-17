// import java.util.ArrayList;
// import java.util.Scanner;

import java.time.LocalDate;

import mvp.model.geoTree.GeoTree;
import mvp.model.person.Person;

public class Main {
    public static void main(String[] args) {
        GeoTree<Person> familyTree = new GeoTree<>();

// =================================ЗАНЕСЕНИЕ ИНФОРМАЦИИ О ЛИЧНОСТЯХ===============================
        familyTree.addPerson(new Person(
            "bEger", 
            "Akerman", 
            "Grigoriev", 
            LocalDate.of(1290, 10, 9))
        );

        familyTree.addPerson(new Person(
            "aMikasa", 
            "Akerman", 
            "Titanovich", 
            LocalDate.of(1293, 1, 20))
        );

        familyTree.addPerson(new Person(
            "dMik", 
            "Akerman", 
            "Egerevich", 
            LocalDate.of(1321, 5, 7),
            familyTree.getByName("bEger", "Akerman", "Grigoriev"),
            familyTree.getByName("aMikasa", "Akerman", "Titanovich"))
        );

        familyTree.addPerson(new Person(
            "cKris", 
            "Akerman", 
            "Egerevich", 
            LocalDate.of(1319, 8, 2),
            familyTree.getByName("bEger", "Akerman", "Grigoriev"),
            familyTree.getByName("aMikasa", "Akerman", "Titanovich"))
        );
// ================================================================================================

// ======================================ЗАПИСЬ ДАННЫХ В ФАЙЛ======================================
        // String filePath = "src/mvp/model/data/tree.txt";

        // Writable writable = new FileHandler();

        // writable.write(familyTree, filePath);
// ================================================================================================

// ===================================ИЗВЛЕЧЕНИЕ ДАННЫХ ИЗ ФАЙЛА===================================
        // GeoTree familyTree = (GeoTree) writable.read(filePath);
// ================================================================================================

        System.out.println(familyTree.getInfo());
        
// ============================================СОРТИРОВКА ДАННЫХ===================================
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>sortName<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        
        familyTree.sortByName();
        System.out.println(familyTree.getInfo());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>sortDateOfBirth<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        familyTree.sortByDateOfBirth();
        System.out.println(familyTree.getInfo());
// ================================================================================================
    }
}