import family.FamilyTree;
import human.Human;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree testFamily = new FamilyTree();
        Service service = new Service(testFamily);

        service.addPerson("Алексей", "Яковлев",
                new Date(54, 1, 1),
                new Date(114, 5, 1), null, null, 1);
        service.addPerson("Алевтина", "Яковлева",
                new Date(64, 2, 2), null, null, null, 0);
        service.addPerson("Борис", "Яковлев",
                new Date(91, 1, 1), null, 1, 0, 6);
        service.addPerson("Бьянка", "Юргент",
                new Date(92, 2, 2), null, 1, 0, 7);
        service.addPerson("Богдан", "Яковлев",
                new Date(93, 3, 3), null, 1, 0, 8);
        service.addPerson("Белла", "Юшкова",
                new Date(94, 4, 4), null, 1, 0, 9);
        service.addPerson("Белка", "Яковлева",
                new Date(91, 5, 5), null, null, null, 2);
        service.addPerson("Билл", "Юргент",
                new Date(92, 6, 5), null, null, null, 3);
        service.addPerson("Бибигуль", "Яковлева",
                new Date(93, 7, 5), null, null, null, 4);
        service.addPerson("Булат", "Юшков",
                new Date(94, 8, 5), null, null, null, 5);
        service.addPerson("Валера", "Яковлев",
                new Date(111, 1, 1), null, 6, 2, null);
        service.addPerson("Виолетта", "Яковлева",
                new Date(112, 2, 1), null, 6, 2, null);
        service.addPerson("Вилор", "Юргент",
                new Date(113, 3, 2), null, 3, 7, null);
        service.addPerson("Валя", "Юргент",
                new Date(114, 4, 3), null, 3, 7, null);
        service.addPerson("Веня", "Яковлев",
                new Date(115, 5, 4), null, 8, 4, null);
        service.addPerson("Вера", "Яковлева",
                new Date(116, 6, 5), null, 8, 4, null);
        service.addPerson("Вано", "Юшков",
                new Date(117, 7, 6), null, 5, 9, null);
        service.addPerson("Вета", "Юшкова",
                new Date(118, 8, 7), null, 5, 9, null);

        System.out.println(testFamily.showTree(2)); // относительно какого id Human строить дерево

        SaveRestoreSerializable serializableTree = new SaveRestoreSerializable(testFamily);
        serializableTree.save("test2.fml");

        FamilyTree loadedTree = new FamilyTree();
        serializableTree.load("test2.fml");
        loadedTree = serializableTree.getTree();

        System.out.println("\n\nЗагруженное из файла дерево: ");
        System.out.println(loadedTree.showTree(4));

        System.out.println("\nFor each:");
        for (Human oneHuman : testFamily) {
            System.out.println(oneHuman);
        }

        System.out.println("\nid DESC:");
        for (Human oneHuman : service.getSortedListByIdDESC()) {
            System.out.println(oneHuman);
        }

        System.out.println("\nName ASC:");
        for (Human oneHuman : service.getSortedListByNameASC()) {
            System.out.println(oneHuman);
        }

        System.out.println("\nName DESC:");
        for (Human oneHuman : service.getSortedListByNameDESC()) {
            System.out.println(oneHuman);
        }
    }
}
