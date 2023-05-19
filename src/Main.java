import module.familystructure.FamilyTree;
import module.human.Human;
import module.service.Service;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Human person1  = new Human("ivan", "ivanov", null, null);
//        Human person2 = new Human("olga", "ivanova", null, null);
//        Human person3 = new Human("oleg","ivanov", person2, person1);
//        Human person4 = new Human("ludmila", "ivanova", person2, person1);
//        Human person5 = new Human("Igor", "Smirnov", null, null);
//        Human person6 = new Human("Dmitry", "Smirnov", person4, person5);
        FamilyTree<Human> tree = new FamilyTree<>();
//        tree.addHuman(person1);
//        tree.addHuman(person2);
//        tree.addHuman(person3);
//        tree.addHuman(person4);
//        tree.addHuman(person5);
//        tree.addHuman(person6);
        Service service = new Service(tree);
//        service.write();
        FamilyTree<Human> persons = service.read();
        System.out.println(persons.getHumans());
        Service service1 = new Service(persons);
        service1.sortByChild();
        System.out.println(persons.getHumans());

    }
}
