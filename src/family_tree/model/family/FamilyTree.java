package family_tree.model.family;

import family_tree.model.family.comparator.FamilyTreeComparatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.family.comparator.FamilyTreeComparatorByName;


public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T> {

    private List<T> familyMembersList;
    private long humanId;

    public FamilyTree() {
        familyMembersList = new ArrayList<>();
    }

    public FamilyTree(List<T> humanList) {
        this.familyMembersList = humanList;
    }

    public boolean addFamilyMember(T human) {
        if (human == null) {
            return false;
        }
        if (!familyMembersList.contains(human)) {
            familyMembersList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToChildren(T human) {
        for (T parent : human.getParentsList()) {
            parent.addChild(human);
        }
    }

    private void addToParents(T human) {
        for (T child : human.getChildrenList()) {
            child.addParent(human);
        }
    }

    public List<T> getSiblingsList(long id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent : human.getParentsList()) {
            for (T child : parent.getChildrenList()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name, String familyName) {
        List<T> res = new ArrayList<>();
        for (T human : familyMembersList) {
            if (human.getName().equals(name) && human.getFamilyName().equals(familyName)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWeddingById(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    private boolean setWedding(T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setFatherById(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T humanChild = getById(humanId1);
            T humanFather = getById(humanId2);
            return setFatherToHuman(humanChild, humanFather);
        }
        return false;
    }

    private boolean setFatherToHuman(T humanChild, T humanFather) {
        if (humanChild.getFather() == null) {
            humanChild.setFather(humanFather);
            humanFather.addChild(humanChild);
            return true;
        }
        return false;
    }

    public boolean setMotherById(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T humanChild = getById(humanId1);
            T humanMother = getById(humanId2);
            return setMotherToHuman(humanChild, humanMother);
        }
        return false;
    }

    private boolean setMotherToHuman(T humanChild, T humanMother) {
        if (humanChild.getMother() == null) {
            humanChild.setMother(humanMother);
            humanMother.addChild(humanChild);
            return true;
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Integer humanId) {
        if (checkId(humanId)) {
            T human = getById(humanId);
            return familyMembersList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humanId && id >= 0;
    }

    public T getById(long id) {
        if (checkId(id)) {
            for (T human : familyMembersList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семья состоит из: \n");
        for (T human : familyMembersList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getFamilyTreeMembers() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи:\n");
        for (T human : familyMembersList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getChildrenListById(long parentId) {
        if (checkId(parentId)) {
            T humanParent = getById(parentId);
            return getHumanChildrenList(humanParent);
        }
        return null;
    }

    private String getHumanChildrenList(T humanParent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список детей:\n");
        assert humanParent != null;
        for (T human : humanParent.getChildrenList()) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyMembersList);
    }

    public void sortByAge() {
        familyMembersList.sort(new FamilyTreeComparatorByAge<>());
    }

    public void sortByName() {
        familyMembersList.sort(new FamilyTreeComparatorByName<>());
    }
}
