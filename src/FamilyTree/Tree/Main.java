package FamilyTree.Tree;


import FamilyTree.Tree.FileHander.FileHandler;
import FamilyTree.Tree.Human.Gender;
import FamilyTree.Tree.Human.Human;
import FamilyTree.Tree.Tree.Tree;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/tree.out";
        FileHandler fileHandler = new FileHandler();

        Tree humanList = Tree();
        System.out.println(humanList);

        fileHandler.save(humanList, filePath);

//        FileHandler fileHandler = new FileHandler();
//        Tree humanList = (Tree) fileHandler.read(filePath);
//        System.out.println(humanList);
    }

    static Tree Tree() {
        Tree tree = new Tree();

        Human kostia = new Human("Константин", "Олегович", Gender.Male, "31.12.1950", null, null);
        tree.add(kostia);
        Human andrea = new Human("Андрей", "Константинович", Gender.Male, "13.05.1979", kostia, null);
        tree.add(andrea);
        Human maria = new Human("Мария", "Константинович", Gender.Female, "19.01.1975", andrea, null);
        tree.add(maria);
        Human julia = new Human("Юлия", "Ивановна", Gender.Female, "26.11.1999", kostia, maria);
        tree.add(julia);
        Human stiv = new Human("Светлана", "Олеговна", Gender.Female, "07.7.2000", andrea, maria);
        tree.add(stiv);

        return tree;
    }
}