package model;

import java.util.List;

public class GenealogyTreeModelImpl implements GenealogyTreeModel {
    private GenealogyTree<Person> tree;

    public GenealogyTreeModelImpl(GenealogyTree<Person> tree) {
        this.tree = tree;
    }

    @Override
    public void addPerson(Person parent, Person child) {
        tree.addParentChildRelation(parent, child);
    }

    @Override
    public List<Person> getChildren(Person person) {
        return tree.getChildren(person);
    }

    @Override
    public List<Person> getAncestors(Person person) {
        return tree.getAncestors(person);
    }

    @Override
    public List<Person> sortChildrenByName(Person person) {
        return tree.sortChildrenByName(person);
    }

    @Override
    public List<Person> sortAncestorsByName(Person person) {
        return tree.sortAncestorsByName(person);
    }
}
