package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String path = "src/FamilyTree/file.txt";
        SaveLoader saveLoader = new FileHandler();

        FamilyTree tree = (FamilyTree) saveLoader.load(path);
//        FamilyTree tree = new FamilyTree();

//        tree.add(new Person("Петрова Ольга Владимировна", Gender.male, LocalDate.of(1941, 6, 24)));
//        tree.add(new Person("Иванов Иван Иванович", Gender.male, LocalDate.of(1935, 12, 14)));
//        tree.add(new Person("Иванова Кристина Ивановна", Gender.male, LocalDate.of(1961, 5, 15),
//                tree.getByName("Петрова Ольга Владимировна"),
//                tree.getByName("Иванов Иван Иванович")));
//        tree.add(new Person("Митрофанов Дмитрий Васильевич", Gender.male, LocalDate.of(1963, 9, 1)));
//        tree.add(new Person("Митрофанов Константин Дмитриевич", Gender.male, LocalDate.of(1981, 8, 25),
//                tree.getByName("Иванова Кристина Ивановна"),
//                tree.getByName("Митрофанов Дмитрий Васильевич")));

//        saveLoader.save(tree, path);

        System.out.println(tree.getFamilyTree());

    }
}
