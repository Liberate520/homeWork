package Model;

import java.util.*;

public class FamilyTree<T extends HouseHold> implements Iterable<HouseHold> {
    private List<T> treeList;
    public FamilyTree(){
        treeList = new ArrayList<>();
    }
    public List<T> getTreeList() {
        return treeList;
    }
//    public void print(){
//        for (T h : treeList) {
//            System.out.println(h.getName() + " " + h.getBirthday() + " " +
//                    h.getDeathDate()
//                    + " " + h.getGender());
//        }
//    }

    public void add(T houseHold){
        treeList.add(houseHold);
    }

    @Override
    public Iterator<HouseHold> iterator() {
        return new IteratorForBuffer<>(treeList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево: \n");
        for (T b: treeList) {
            sb.append(b);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(treeList.toString());
    }

    public void sortByAge() {
        treeList.sort(new ComparatorSortByAge<T>());
    }

    public void sortByName() {
        treeList.sort(new ComparatorSortByName<T>());
    }
}