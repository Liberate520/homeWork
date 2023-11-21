package familyTree;

import human.Human;
import human.HumanComparatorByAge;
import human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList = new ArrayList<>();
    private int humanId = 1;

    public void addFamilyTree(Human human) {
        if (!humanList.contains(human)) {
            human.setId(humanId++);
            humanList.add(human);
            addToParrents(human);
            addToChildren(human);
        }}
    public void addToParrents(Human human){
        for (Human parent: human.getParrent()){
            parent.addChildren(human);
        }
    }
    public void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

        public String familyTreeInfo () {
            StringBuilder sb = new StringBuilder();
            for (Human human : humanList) {
                sb.append(human);
                sb.append("\n");
            }
            return sb.toString();
        }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator();
    }

    class HumanIterator implements Iterator<Human>{
        private int index;
        @Override
        public boolean hasNext() {
            return index<humanList.size();
        }

        @Override
        public Human next() {
            return humanList.get(index++);
        }
    }
}
