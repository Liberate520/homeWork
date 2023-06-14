package model;

public class SortByBirthDate implements Sortable{
    @Override
    public void sort(FamilyTree<Human> tree) {
        tree.getHumanList().sort(new HumanComparatorByBirthDate<>());
    }
}
