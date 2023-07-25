package FamilyTree.Tree;


import FamilyTree.Tree.FileHander.FileHandler;
import FamilyTree.Tree.Human.Gender;
import FamilyTree.Tree.Human.Human;
import FamilyTree.Tree.Tree.Tree;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/tree.out";
        FileHandler fileHandler = new FileHandler();

        Tree humanList = FamTree();
        System.out.println(humanList);

        fileHandler.save(humanList, filePath);

//        FileHandler fileHandler = new FileHandler();
//        Tree humanList = (Tree) fileHandler.read(filePath);
//        System.out.println(humanList);
    }

    static Tree FamTree() {
        Tree tree = new Tree();

        Human Human1 = new Human("Попов", "Константин", "Андреевич", "25.05.55", Gender.Male);
        Human Human2 = new Human("Попов", "Андрей", "Сергеевич", "15.03.97", Gender.Male, Human1);
        Human Human3 = new Human("Попова", "Мария", "Игоревна", "13.01.80", Gender.Female, Human2);
        Human Human4 = new Human("Попова", "Евгения", "Николаевна", "13.01.00", Gender.Female, Human3);

        System.out.println(tree.getHumansInfo());

        System.out.println("Перечень людей: " + Human.getHumans());

        System.out.println("Дети человека 1: " + Human1.getChildren());
        System.out.println("Дети человека 2: " + Human2.getChildren());
        System.out.println("Дети человека 3: " + Human3.getChildren());

        System.out.println();

        System.out.println("Родители человека 1: " + Human1.getParent());
        System.out.println("Родители человека 2: " + Human2.getParent());
        System.out.println("Родители человека 3: " + Human3.getParent());
        System.out.println("Родители человека 4: " + Human4.getParent());
        return tree;
    }
}