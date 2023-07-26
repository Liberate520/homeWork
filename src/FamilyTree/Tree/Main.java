package FamilyTree.Tree;


import FamilyTree.Tree.FileHander.FileHandler;
import FamilyTree.Tree.HumanGroup.Human.Gender;
import FamilyTree.Tree.HumanGroup.Human.Human;
import FamilyTree.Tree.HumanGroup.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/tree.out";
        FileHandler fileHandler = new FileHandler();

        Service humanList = Tree();
        System.out.println(humanList);

        fileHandler.save(humanList, filePath);

//        FileHandler fileHandler = new FileHandler();
//        Tree humanList = (Tree) fileHandler.read(filePath);
//        System.out.println(humanList);
    }

    public static Service Tree() {
        Service tree = new Service();

         Human kostia = new Human("Константин", "Олегович", Gender.Male, LocalDate.of(1950,12,31), null,null);
         tree.addHuman(kostia);
         Human andrea = new Human("Андрей", "Константинович", Gender.Male, LocalDate.of(1970,6,11), kostia, null);
         tree.addHuman(andrea);
         Human maria = new Human("Мария", "Константинович", Gender.Female, LocalDate.of(1980,1,19), andrea, null);
         tree.addHuman(maria);
         Human julia = new Human("Юлия", "Ивановна", Gender.Female, LocalDate.of(2000,9,25), kostia, maria);
         tree.addHuman(julia);
         Human stiv = new Human("Светлана", "Олеговна", Gender.Female, LocalDate.of(2001,2,1), andrea, maria);
         tree.addHuman(stiv);


         System.out.println(tree.getInfo());
        tree.sortByName();
        System.out.println(tree.getInfo());
        tree.sortPatronymic();
        System.out.println(tree.getInfo());
        tree.sortDateOfBirth();


         System.out.println("Родители человека 1: " + "Отец:" + kostia.getFather() +": Мать:" + kostia.getMother());
         System.out.println("Родители человека 2: " + "Отец:" + andrea.getFather() +": Мать:" + andrea.getMother());
         System.out.println("Родители человека 3: " + "Отец:" + maria.getFather() + ": Мать:" + maria.getMother());
         System.out.println("Родители человека 4: " + "Отец:" + julia.getFather() + ": Мать:" + julia.getMother());
        System.out.println("Родители человека 5: " + "Отец:" + stiv.getFather() + ": Мать:" + stiv.getMother());

        return tree;
    }

}