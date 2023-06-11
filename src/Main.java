// import java.util.ArrayList;
// import java.util.Scanner;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // GeoTree familyTree = new GeoTree();

// =================================ЗАНЕСЕНИЕ ИНФОРМАЦИИ О ЛИЧНОСТЯХ===============================
        // familyTree.addPerson(new Person(
        //     "Eger", 
        //     "Akerman", 
        //     "Grigoriev", 
        //     LocalDate.of(1290, 10, 9))
        // );

        // familyTree.addPerson(new Person(
        //     "Mikasa", 
        //     "Akerman", 
        //     "Titanovich", 
        //     LocalDate.of(1293, 1, 20))
        // );

        // familyTree.addPerson(new Person(
        //     "Mik", 
        //     "Akerman", 
        //     "Egerevich", 
        //     LocalDate.of(1319, 5, 7),
        //     familyTree.getByName("Eger", "Akerman", "Grigoriev"),
        //     familyTree.getByName("Mikasa", "Akerman", "Titanovich"))
        // );

        // familyTree.addPerson(new Person(
        //     "Kris", 
        //     "Akerman", 
        //     "Egerevich", 
        //     LocalDate.of(1321, 8, 2),
        //     familyTree.getByName("Eger", "Akerman", "Grigoriev"),
        //     familyTree.getByName("Mikasa", "Akerman", "Titanovich"))
        // );
// ================================================================================================

// ======================================ЗАПИСЬ ДАННЫХ В ФАЙЛ======================================
        String filePath = "src/tree.txt";

        Writable writable = new FileHandler();

        // writable.write(familyTree, filePath);
// ================================================================================================

// ===================================ИЗВЛЕЧЕНИЕ ДАННЫХ ИЗ ФАЙЛА===================================
        GeoTree familyTree = (GeoTree) writable.read(filePath);
// ================================================================================================

        System.out.println(familyTree.getInfo());
    }
}