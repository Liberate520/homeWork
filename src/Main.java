import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Role> roles = new ArrayList<>();

        Child child1 = new Child(Role.male, 14, "Bobby", "Jackson");
        Child child2 = new Child(Role.female, 15, "Marta", "Jackson");

        Child child3 = new Child(Role.female, 10, "Anna", "Smith");

        List<Child> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);

        Parent mom = new Parent(Role.female, 30, "July", "Fox", null);
        Parent mom2 = new Parent()
                .setSex(Role.female)
                .setAge(33).setFirstName("July")
                .setLastName("Foxer")
                .setChildren(children);
        Parent dad = new Parent(Role.male, 35, "Jakob", "Jackson", children);

        Parent dad2 = new Parent()
                .setAge(40)
                .setFirstName("Bill")
                .setLastName("Murray")
                .setSex(Role.male)
                .setChild(child3);

        roles.add(child1);
        roles.add(child2);
        roles.add(child3);
        roles.add(mom);
        roles.add(mom2);
        roles.add(dad);
        roles.add(dad2);

        Research researcher = new Research(roles);
        researcher.findPerson("July Fox").printData();

        researcher.whoYourChildren("Jakob Jackson");
        researcher.whoYourFather("Anna Smith");

        /*child1.whoYourFather();
        child1.whoYourMother();

        mom.whoYourChildren();

        dad2.whoYourChildren();*/
        List<Grandchild> grandchildren = new ArrayList<>();
        Grandchild grandson = new Grandchild(Role.male, 9, "Mike", "Polson");
        grandchildren.add(grandson);
        Grandparent grandmother = new Grandparent(Role.female, 65, "Katerina", "Green", grandchildren);

        roles.add(grandson);
        roles.add(grandmother);

        Child child4 = new Child(Role.male, 1, "Ted", "Jackson");
        Parent parent1 = child1.BecomeParent(child4);
        roles.add(child4);
        roles.add(parent1);

        researcher.whoYourChildren("Ted Jackson");
        researcher.whoYourChildren("Bobby Jackson"); // two roles for one

        Child ch = new Child(Role.male, 14, "Rick", "Rock");
        Parent pr = new Parent(ch.identity);
        roles.add(ch);
        roles.add(pr);

        //researcher.printAllRoles();

        UserInterface UI = new UserInterface(researcher);
        UI.Run();
    }
}
