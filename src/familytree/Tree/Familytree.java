package familytree.Tree;

import java.io.Serializable;
import java.util.List;

public class Familytree <E extends GetByOn> implements Serializable {
    private E rootPerson;//===Начальная точка дерева

    public Familytree(E rootPerson) {
        this.rootPerson = rootPerson;
    }
    public void addPerson(E person, E parent1, E parent2) {
        person.addParent(parent1);
        person.addParent(parent2);
        parent1.addChild(person);
        parent2.addChild(person);

    }

    public void addPerson(E person, E partner){
        person.addPartner(partner);
        partner.addPartner(person);
    }


    public void printFamilyTree() {
        printFamilyTreeRecursive(rootPerson, 0);
    }

    private void printFamilyTreeRecursive(E currentPerson, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }
        System.out.println(indent.toString() + "- " + currentPerson.getName() + " " + currentPerson.getSurname());
        for ( Person child : currentPerson.getChildren()) {
            printFamilyTreeRecursive((E) child, level + 1);
        }
    }

    /*@Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator();
    }*/


    //============================================================

}
