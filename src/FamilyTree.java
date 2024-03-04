import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class FamilyTree  implements Serializable, Iterable<Human> {

    private int humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add (Human human){
        humanList.add(human);
        human.setId(humansId++);
        addToParents(human);
        addToChildren(human);


    }



    public Human getById (int id) {
        if (!checkId(id)) {
            return null;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;

    }


    public List<Human> getSiblings(int id) {
        Human human = getById(id);

        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }

            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1,human2);

        }
        return false;
    }

    public boolean setWedding (Human human1, Human human2){
        if (human1.getMarried()== null && human2.getMarried() == null){
            human1.setMarried(human2);
            human2.setMarried(human1);
            return true;
        } else {
            return false;
        }
    }




    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);

        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);

        }
    }

    public boolean remove (int eId){
        if (checkId(eId)) {
            Human human = getById(eId);
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
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString () {
        return getInfo();
    }


    public void sortByName() {humanList.sort(new FamilyTreeComparatorByName());}

    public void sortByDeathDate() {humanList.sort(new FamilyTreeComparatorByName());}

    @Override
    public Iterator<Human> iterator(){return new FamilyTreeIterator(humanList);}

}
