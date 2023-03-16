import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        var tree = new FamilyTree();
        final Writable fileHandler = new FileHandler("FamilyTree.out");
        tree = (FamilyTree) fileHandler.read();

//        tree.add(new Human("Волченко", "Павел", "Александрович", GenderType.Male));
//        tree.add(new Human("Волченко", "Лейла", "Ансаровна", GenderType.Female));
//        tree.add(new Human("Волченко", "Вечислав", "Павлович", GenderType.Male,
//                tree.getByName("Волченко", "Павел"), tree.getByName("Волченко", "Лейла")));
//
//        tree.add(new Human("Мори", "Иван", "Александрович", GenderType.Male));
//        tree.add(new Human("Мори", "Мария", "Денисова", GenderType.Female));
//        tree.add(new Human("Мори", "Дмитрий", "Павлович", GenderType.Male,
//                tree.getByName("Мори", "Иван"), tree.getByName("Мори", "Мария")));
//        tree.add(new Human("Мори", "Генадий", "Павлович", GenderType.Male,
//                tree.getByName("Мори", "Иван"), tree.getByName("Мори", "Мария")));
//
//        tree.add(new Human("Иванов", "Иван", "Александрович", GenderType.Male));
//        tree.add(new Human("Иванова", "Мария", "Сергеевна", GenderType.Female));
//        tree.add(new Human("Иванов", "Дмитрий", "Павлович", GenderType.Male,
//                tree.getByName("Иванов", "Иван"), tree.getByName("Иванова", "Мария")));

        System.out.println(tree.getInfo());
//        System.out.println("--- Отсортировано по фамилии ---");
//        tree.sortByName();
//        System.out.println(tree.getInfo());

        fileHandler.write(tree);
    }
}