package FamilyTree;

import FamilyTree.model.FamilyTreeService;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.human.Gender;
import FamilyTree.model.human.Human;
import FamilyTree.model.save.FileHandler;
import FamilyTree.presenter.Presenter;
import FamilyTree.view.ConsoleUI;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        familyTree.addMember(new Human("Николай", Gender.MALE));
        familyTree.addMember(new Human("Анатолий", Gender.MALE));
        familyTree.addMember(new Human("Зинаида", Gender.FEMALE));
        familyTree.addMember(new Human("Татьяна", Gender.FEMALE, familyTree.getByName("Николай"), familyTree.getByName("Зинаида")));
        familyTree.addMember(new Human("Олег", Gender.MALE));
        familyTree.addMember(new Human("Иван", Gender.MALE, familyTree.getByName("Олег"), familyTree.getByName("Татьяна")));
        System.out.println(familyTree.getInfo());


        FamilyTreeService service = new FamilyTreeService();
        service.setWritable(new FileHandler());
        service.save();
        service.load();
        View view = new ConsoleUI();
        new Presenter(view, service);

        view.start();
        }
}
