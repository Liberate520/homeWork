package model;

import model.Human.Human;
import model.tree.FamilyTree;
import model.tree.comparators.HumanComparatorByDateOfBirth;
import model.tree.comparators.HumanComparatorByName;
import java.time.LocalDate;
import java.util.List;


public class FamilyTreeService extends Data{
    private final FamilyTree<Human> tree;
    private final Writeable wr = new Data();
    public FamilyTreeService(FamilyTree<Human> tree) {
        this.tree = tree;
    }
    public void sortByName(){
        tree.getTree().sort(new HumanComparatorByName());
    }

    public void sortByDateOfBirht(){
        tree.getTree().sort(new HumanComparatorByDateOfBirth());
    }

    public void save() {
        wr.save(tree);
    }

    public FamilyTree read() {
        FamilyTree treeFromFile = (FamilyTree) wr.read();
        return treeFromFile;
    }

    public void addHuman(String name, String surname, LocalDate dayOfBirth) {
        tree.add(new Human(name,surname,dayOfBirth));
    }

    public List<Human> search(String name, String surname) {
        return tree.searchForSurnameAndName(name, surname);
    }

    public String showAll() {
        StringBuilder tempTree = new StringBuilder();
        for (Human item : tree) {
                tempTree.append(item.getName()).append(" ").append(item.getSurname()).append(" ")
                        .append(item.getBirthday()).append("\n");
        }
        return tempTree.toString();
    }
}
