import java.io.IOException;
import java.time.LocalDate;

import model.Service;
import model.familyTreeApi.FamilyTree;
import model.familyTreeApi.Human;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human James = new Human("James", "Potter", LocalDate.of(1960, 2, 27), "Male");
        Human Lily = new Human("Lily", "Potter", LocalDate.of(1960, 1, 30), "Female");

        Human Harry = new Human("Harry", "Potter", LocalDate.of(1980, 7, 31), "Male", James, Lily);
        Human Ginevra = new Human("Ginevra", "Potter", LocalDate.of(1981, 8, 11), "Female");

        Human Albus_Severus = new Human("Albus Severus", "Potter", LocalDate.of(2005 , 9, 1), "Male", Harry, Ginevra);
        Human James_Sirius = new Human("James Sirius", "Potter", LocalDate.of(2003 , 9, 1), "Male", Harry, Ginevra);
        Human Lily_Luna = new Human("Lily Luna", "Potter", LocalDate.of(2007 , 9, 1), "Female", Harry, Ginevra);
        
        James.addChildren(Harry);
        Lily.addChildren(Harry);

        Harry.addChildren(Albus_Severus);
        Harry.addChildren(James_Sirius);
        Harry.addChildren(Lily_Luna);

        Ginevra.addChildren(Albus_Severus);
        Ginevra.addChildren(James_Sirius);
        Ginevra.addChildren(Lily_Luna);
    
        FamilyTree<Human> potterTree = new FamilyTree<Human>();

        potterTree.add(James);
        potterTree.add(Lily);
        potterTree.add(Harry);
        potterTree.add(Ginevra);
        potterTree.add(Albus_Severus);
        potterTree.add(James_Sirius);
        potterTree.add(Lily_Luna);

        Service service = new Service(potterTree);
        ConsoleUI view = new ConsoleUI();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
