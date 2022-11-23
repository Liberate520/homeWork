import Model.Child;
import Model.Human;
import Model.Parent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<Human>();

        Child child1 = new Child(Human.male, 4, "Bobby", "Jackson");
        Child child2 = new Child(Human.female, 15, "Marta", "Jackson");

        Child child3 = new Child(Human.female, 10, "Anna", "Smith");

        List<Child> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);

        Parent mom = new Parent(Human.female, 30, "July", "Fox", null);
        Parent mom2 = new Parent()
                .setSex(Human.female)
                .setAge(33).setFirstName("July")
                .setLastName("Foxer")
                .setChildren(children);
        Parent dad = new Parent(Human.male, 35, "Jakob", "Jackson", children);

        Parent dad2 = new Parent()
                .setAge(40)
                .setFirstName("Bill")
                .setLastName("Murray")
                .setSex(Human.male)
                .setChild(child3);

        people.add(child1);
        people.add(child2);
        people.add(child3);
        people.add(mom);
        people.add(mom2);
        people.add(dad);
        people.add(dad2);

        Research researcher = new Research(people);
        researcher.findPerson("July Fox").printData();

        researcher.whoYourChildren("Jakob Jackson");
        researcher.whoYourFather("Anna Smith");

        /*child1.whoYourFather();
        child1.whoYourMother();

        mom.whoYourChildren();

        dad2.whoYourChildren();*/

    }
}
