import ui.View;

import ui.Console;

import model.Service;
//import model.human.Gender;
import presenter.Presenter;

public class Main {

    public static void main(String[] args) {

        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);
        view.start();


        //String filePath = "src/tree.txt";
        //Writable writable = new FileHandler();
        //FamilyTree familyTree = new FamilyTree();
        // Service service = new Service();
        // service.addHuman(1, "Anton", "Repov", "02.12.2000", Gender.Male);
        // service.addHuman(2, "Anna", "Repova", "12.05.2002", Gender.Female);
        // service.addHuman(3, "Fergat", "Repov", "12.05.2020", Gender.Female);

        // Human human1 = new Human("Anton", "Repov", "02.12.2000", Gender.Male);
        // Human human2 = new Human("Anna", "Repova", "12.05.2002", Gender.Female);
        // Human human3 = new Human("Fergat", "Repov", "12.05.2020", Gender.Female, human1, human2);
        // FamilyTree familyTree = new FamilyTree();
        // familyTree.addHuman(human1);
        // familyTree.addHuman(human2);
        // familyTree.addHuman(human3);
        // System.out.println(service.getInfo());
        // System.out.println("-----------------------------------");
        // //System.out.println(service.getHumanByName("Fergat"));
        // System.out.println("-----------------------------------");

        // // // // writable.save(familyTree, filePath);
        // //FamilyTree familyTree = (FamilyTree) writable.read(filePath);


        // service.sortByName();
        // System.out.println(service.getInfo());

        // service.sortById();
        // System.out.println(service.getInfo());

        //FamilyTree<Human> studyGroup = new FamilyTree<>();

    }
}
