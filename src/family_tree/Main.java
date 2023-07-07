package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        String filePath = "src/family_tree/tree.out";
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = testTree();
//        System.out.println(tree);
//        fileHandler.save(tree, filePath);

        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(tree);

    }
    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10)));
        tree.add(new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15)));

        tree.add(new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                tree.getByName("Василий"), tree.getByName("Мария")));
        tree.add(new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                tree.getByName("Василий"), tree.getByName("Мария")));


        return tree;
    }
}
