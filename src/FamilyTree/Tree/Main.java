package FamilyTree.Tree;



import FamilyTree.Tree.model.FileHander.readSave;
import FamilyTree.Tree.model.HumanGroup.Human.Gender;
import FamilyTree.Tree.model.HumanGroup.Human.Human;
import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.presenter.Presenter;
import FamilyTree.Tree.view.ConsoleUI;
import FamilyTree.Tree.view.View;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        String filePath = "src/tree.out";
//        FileHandler fileHandler = new FileHandler();
//
//        Service consoleUI = Tree();
//        System.out.println(consoleUI);
//
//        fileHandler.save( consoleUI, filePath);
//
//        fileHandler = new FileHandler();
//        ConsoleUI consoleUI1  = (ConsoleUI) fileHandler.read(filePath);
//        System.out.println(consoleUI1);
//    }
//    public static Service Tree() {
        Service tree = new Service();

        Human kostia = new Human("Константин", "Олегович", Gender.Male, LocalDate.of(1950,12,31), null,null);
         tree.addHuman(kostia);
         Human andrea = new Human("Андрей", "Константинович", Gender.Male, LocalDate.of(1970,6,11), kostia, null);
         tree.addHuman(andrea);
         Human maria = new Human("Мария", "Константинович", Gender.Female, LocalDate.of(1980,1,19), andrea, null);
         tree.addHuman(maria);
         Human julia = new Human("Юлия", "Ивановна", Gender.Female, LocalDate.of(2005,9,25), kostia, maria);
         tree.addHuman(julia);
         Human stiv = new Human("Светлана", "Олеговна", Gender.Female, LocalDate.of(2001,2,1), andrea, maria);
         tree.addHuman(stiv);




        System.out.println("Родители человека 1: " + "Отец:" + kostia.getFather() +": Мать:" + kostia.getMother());
         System.out.println("Родители человека 2: " + "Отец:" + andrea.getFather() +": Мать:" + andrea.getMother());
         System.out.println("Родители человека 3: " + "Отец:" + maria.getFather() + ": Мать:" + maria.getMother());
         System.out.println("Родители человека 4: " + "Отец:" + julia.getFather() + ": Мать:" + julia.getMother());
        System.out.println("Родители человека 5: " + "Отец:" + stiv.getFather() + ": Мать:" + stiv.getMother());

        System.out.println(tree.getHumansInfo());
        tree.sortByName();
        System.out.println(tree.getHumansInfo());
        tree.sortPatronymic();
        System.out.println(tree.getHumansInfo());
        tree.sortDateOfBirth();


        View view = new ConsoleUI();
        readSave serialize = new readSave();
        view.start();
        new Presenter(view);
//        HumanGroup<Dogs> group = new HumanGroup<>();
//        group.sortByName();
//        group.addHuman(new Dogs());
    }

}