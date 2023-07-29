import model.Organisms.Dogs.Dog;
import model.FamilyTree.FamilyTree;
import model.Organisms.Human.Human;
import model.Organisms.Person.Sex;
import model.Organisms.Person.OrganismType;
import view.UI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        // Заводим экземпляры класса
//        Human john = new Human(OrganismType.human, "John", LocalDate.of(1990,12, 9), Sex.male);
//        Human max = new Human(OrganismType.human, "Max", LocalDate.of(1978,8, 4), Sex.male);
//        Human mary = new Human(OrganismType.human, "Maria", LocalDate.of(1979,4, 2), Sex.female);
//        Human julia = new Human(OrganismType.human, "Julia", LocalDate.of(1992,2, 8), Sex.female);
//        Human zoe = new Human(OrganismType.human, "Zoe", LocalDate.of(2009,1, 1), Sex.female);
//        Dog jack = new Dog(OrganismType.dog, "Jack", LocalDate.of(2007, 2,3), Sex.male);
//        FamilyTree tree = new FamilyTree();
//        tree.addPerson(john);tree.addPerson(max);tree.addPerson(mary);tree.addPerson(julia);tree.addPerson(zoe);
        UI ui = new UI();
        ui.start();


    }

}
