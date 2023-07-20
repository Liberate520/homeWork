package familytree.model;

import java.io.Serializable;

public class Familytree implements Serializable {

    public void addPerson(Person person, Person parent1, Person parent2) {
        person.addParent(parent1);
        person.addParent(parent2);
        parent1.addChild(person);
        parent2.addChild(person);

    }

    public void addPerson(Person person, Person partner){
        person.addPartner(partner);
        partner.addPartner(person);
    }


    private void printFamilyTreeRecursive(Person currentPerson, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }
        System.out.println(indent.toString() + "- " + currentPerson.getName() + " " + currentPerson.getSurname());
        for (Person child : currentPerson.getChildren()) {
            printFamilyTreeRecursive(child, level + 1);
        }
    }


    //============================================================

}
