import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human person1 = new Human("Anna", "Koshak", Gender.FEMALE);
        Human person2 = new Human("Vika", "Macarova", Gender.FEMALE);
        Human person3 = new Human("Stepan", "Terent", Gender.MALE);
        Human person4 = new Human("Ily", "Macarov", Gender.MALE);
        Human person5 = new Human("Yriy", "Savich", Gender.MALE);

        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);
        familyTree.addPerson(person5);

        familyTree.addParentChildRelationship(person1, person2);
        familyTree.addParentChildRelationship(person1, person4);
        familyTree.addParentChildRelationship(person3, person1);
        familyTree.addParentChildRelationship(person3, person5);

        Human selectedPerson = person1;
        List<Human> children = familyTree.getChildren(selectedPerson);

        System.out.println("Дети из семьи " + selectedPerson.getLast_name() + ":");
        for (Human child : children) {
            System.out.println(child.getName());
        }
    }
}
