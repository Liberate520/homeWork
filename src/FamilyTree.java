import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class FamilyTree<E extends Dogs<E>>  implements Serializable, Iterable<E> {

    private int humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public void add (E human){
        humanList.add(human);
        human.setId(humansId++);
        addToParents(human);
        addToChildren(human);


    }



    public Human getById (int id) {
        if (!checkId(id)) {
            return null;
        }
        for (E human : humanList) {
            if (human.getId() == id) {
                return (Human) human;
            }
        }
        return null;

    }


    public List<E> getSiblings(int id) {
        E human = (E) getById(id);

        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }

            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = (E) getById(humanId1);
            E human2 = (E) getById(humanId2);
            return setWedding(human1,human2);

        }
        return false;
    }

    public boolean setWedding (E human1, E human2){
        if (human1.getMarried()== null && human2.getMarried() == null){
            human1.setMarried(human2);
            human2.setMarried(human1);
            return true;
        } else {
            return false;
        }
    }




    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);

        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);

        }
    }

    public boolean remove (int eId){
        if (checkId(eId)) {
            E human = (E) getById(eId);
            return humanList.remove(human);
        }
        return false;
    }



    private boolean checkId(int id) {
        return id < humansId && id>=0;
    }

    public String getInfo () {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString () {
        return getInfo();
    }


    public void sortByName() {humanList.sort(new FamilyTreeComparatorByName<>());}

    public void sortByDeathDate() {humanList.sort(new FamilyTreeComparatorByName<>());}

    @Override
    public Iterator<E> iterator(){return new FamilyTreeIterator<>(humanList);}

}
