import model.FamilyTree;
import model.Human;
import model.Service;
import presenter.Presenter;
import view.Console;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree <Human> familyTree = new FamilyTree<>();
        Human person1 = new Human("05.05.1901", "05.05.1977", "male", "Nicola", "Tesla");
        Human person2 = new Human("05.06.1903", "15.08.1979","female", "Maria", "Tropicana");
        Human person3 = person1.createHuman("05.06.1925", "15.08.1980","male", person2, "Max");
        Human person4 = new Human("06.06.1923", "13.08.1989","female", "Anna", "Verita");
        Human person5 = person3.createHuman("05.06.1930", "15.08.1969", "female", person4, "Giulia");
        Human person6 = person3.createHuman("05.06.1931", "15.08.1979","male", person4, "Alessanro");

        familyTree.addElement(person1);
        familyTree.addElement(person2);
        familyTree.addElement(person3);
        familyTree.addElement(person4);
        familyTree.addElement(person5);
        familyTree.addElement(person6);

        View console = new Console();
        Service service = new Service(familyTree);
        new Presenter(console, service);
        console.start();

    }

}