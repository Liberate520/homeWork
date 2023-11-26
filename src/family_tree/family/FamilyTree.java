package family_tree.family;

import family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private long humanId;
    private List<Human> familyMembersList;

    public FamilyTree() {
        familyMembersList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.familyMembersList = humanList;
    }

    public boolean addFamilyMember(Human human) {
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

    private void addToChildren(Human human) {
        for (Human parent : human.getParentsList()) {
            parent.addChild(human);
        }
    }

    private void addToParents(Human human) {
        for (Human child : human.getChildrenList()) {
            child.addParent(human);
        }
    }

    public List<Human> getSiblingsList(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParentsList()) {
            for (Human child : parent.getChildrenList()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name, String familyName) {
        List<Human> res = new ArrayList<>();
        for (Human human : familyMembersList) {
            if (human.getName().equals(name) && human.getFamilyName().equals(familyName)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            Human human = getById(humanId);
            return familyMembersList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humanId && id >= 0;
    }

    public Human getById(long id) {
        if (checkId(id)) {
            for (Human human : familyMembersList) {
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
        for (Human human : familyMembersList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
