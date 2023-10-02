package FamailyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Human.Human;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> listHuman) {
        this.humanList = listHuman;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        } else if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public Human getById(long id) {
        for (Human person : humanList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<Human> getByName(String name) {
        List<Human> list = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getLastName().equals(name)) {
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getByFamily(String family) {
        List<Human> list = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getFistName().equals(family)) {
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getByFIO(String name, String family) {
        List<Human> list = new ArrayList<>();
        for (Human human : humanList) {
            if ((human.getLastName().equals(name)) && (human.getFistName().equals(family))) {
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getList() {
        List<Human> list = new ArrayList<>();
        for (Human human : humanList) {
            list.add(human);
        }
        return list;
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(Human human) {
        Human mother = human.getMother();
        Human father = human.getFather();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private boolean checkId(long id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево: \n");
        sb.append(humanList.size()).append(" - Семейное дерево\n");
        sb.append("Перечень людей в дереве:\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return info();
    }
}
