package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import human.Gender;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByChildrens;

public class Tree<T extends TreeItem<T>> implements Serializable, Iterable<T> {
    private List<T> humans;

    public Tree(List<T> humans) {
        this.humans = humans;
    }

    public Tree() {
        this.humans = new ArrayList<T>();
    }

    public void sortBySurName() {
        Collections.sort(humans,new HumanComparatorByAge<>());    
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
            List<T> childrens = human.getChildrens();
            System.out.println(human.getChildrenInfo(childrens));
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

    public void showFullTreeInfo() {
        System.out.println("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (T human : humans) {
            System.out.println(human.getFullInfo());
        }

    }

    public void showShortTreeInfo() {
        System.out.println("\nКРАТКАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (T human : humans) {
            System.out.println(human.getShortInfo());
        }

    }

    public void showGenderStatistics(Gender gender) {
        List<T> list = new ArrayList<>();
        for (T human : humans) {
            if (human.getGender().equals(gender)) {
                list.add(human);
            }
        }
        System.out.printf("\nСПИСОК ВСЕХ ЛЮДЕЙ %s ПОЛА В ДЕРЕВЕ\n",
                (gender.equals(Gender.Male)) ? "МУЖСКОГО" : "ЖЕНСКОГО");
        System.out.println(list);
    }

    public void showGrandmotherInfo(String fullName) {
        if (!fullName.equals(null)) {
            String result;
            try {
                T human = getHumanByFullName(fullName);

                result = human.getMother().getMother().getFullName();
            } catch (NullPointerException e) {
                result = "не обнаружено";
            }
            System.out.printf("\nЗАПРОС ПОИСКА БАБУШКИ ДЛЯ %s:\n", fullName);
            System.out.println(result);

        }
    }

    public void showGrandfatherInfo(String fullName) {
        if (!fullName.equals(null)) {
            String result;
            try {
                T human = getHumanByFullName(fullName);
                result = human.getFather().getFather().getFullName();
            } catch (NullPointerException e) {
                result = "не обнаружено";
            }
            System.out.printf("\nЗАПРОС ПОИСКА ДЕДУШКИ ДЛЯ %s:\n", fullName);
            System.out.println(result);

        }
    }

    public List<T> getHumans() {
        return humans;
    }
}
