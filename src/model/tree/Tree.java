package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.human.Gender;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByChildrens;
import model.tree.formatters.TreeFormat;
import model.tree.formatters.TreeGenderStatistics;
import model.tree.formatters.TreeGrandFatherInfo;
import model.tree.formatters.TreeGrandMotherInfo;

public class Tree<T extends TreeItem<T>> implements Serializable, Iterable<T> {
    private List<T> humans;

    public Tree(List<T> humans) {
        this.humans = humans;
    }

    public Tree() {
        this.humans = new ArrayList<T>();
    }

    public int size() {
        return humans.size();
    }

    public void sortByAge() {
        Collections.sort(humans, new HumanComparatorByAge<>());
    }

    public void sortByChildrens() {
        humans.sort(new HumanComparatorByChildrens<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humans);

    }

    public void addHuman(T human) {
        T mother = human.getMother();
        T father = human.getFather();
        List<T> childrens = human.getChildrens();
        if (mother != null && this.humans.contains(mother)) {
            mother.addChildren(human);
        }
        if (father != null && this.humans.contains(father)) {
            father.addChildren(human);
        }
        if (childrens.size() > 0) {
            for (T children : childrens) {
                if (children != null && this.humans.contains(children)) {
                    children.addParent(human);

                }
            }
        }
        humans.add(human);
    }

    public void removeHuman(T human) {
        if (human.getChildrens().size() > 0) {
            for (T person : human.getChildrens()) {
                person.removeParent(human);
            }
        }
        if (human.getMother() != null) {
            human.getMother().removeChildren(human);
        }

        if (human.getFather() != null) {
            human.getFather().removeChildren(human);
        }
        humans.remove(human);
    }

    public void showChildrensInfo(T human) {
        System.out.println("\n" + human.getFullName().toUpperCase() + " ИНФОРМАЦИЯ О ДЕТЯХ");
        if (this.humans.contains(human)) {
            System.out.println(human.getChildrenInfo());
        } else {
            System.out.println("Указанный человек отсутствует в генеологическом дереве");
        }

    }

    public T getHumanByFullName(String fullName) {
        for (T human : humans) {
            if (human.getFullName().equals(fullName)) {
                return human;
            }
        }
        return null;
    }

    public String showFullTreeInfo() {
        if (humans.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ\n");
            for (T human : humans) {
                stringBuilder.append(human.getFullInfo()).append("\n");
            }
            return stringBuilder.toString();
        }
        return "Данные отсутствуют";
    }

    public String showShortTreeInfo() {
        if (humans.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nКРАТКАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ\n");
            for (T human : humans) {
                stringBuilder.append(human.getShortInfo()).append("\n");
            }
            return stringBuilder.toString();
        }
        return "Данные отсутствуют";
    }

    public Gender convertStringToGender(String text) {
        Gender gender = (text.equals("Male")) ? Gender.Male : Gender.Female;
        return gender;
    }

    public String showGenderStatistics(String gender) {
        TreeFormat treeFormat = new TreeGenderStatistics<>(this);
        return treeFormat.showTreeInfo(gender);
    }

    public String showGrandmotherInfo(String fullName) {
        TreeFormat treeFormat = new TreeGrandMotherInfo<>(this);
        return treeFormat.showTreeInfo(fullName);
    }

    public String showGrandfatherInfo(String fullName) {
        TreeFormat treeFormat = new TreeGrandFatherInfo<>(this);
        return treeFormat.showTreeInfo(fullName);
    }

    public List<T> getHumans() {
        return humans;
    }
}
