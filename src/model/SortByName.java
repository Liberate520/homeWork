package model;

public class SortByName implements Sortable{
    @Override
    public void sort(FamilyTree<Human> tree) {
        tree.getHumanList().sort(new HumanComparatorByName<>());
    }
}
