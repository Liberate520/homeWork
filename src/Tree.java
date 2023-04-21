import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private List<Human> humans;

    public Tree(List<Human> humans) {
        this.humans = humans;
    }

    public Tree() {
        this.humans = new ArrayList<Human>();
    }

    public void addHuman(Human human) {
        Human mother = human.getMother();
        Human father = human.getFather();
        List<Human> childrens = human.getChildrens();
        if (mother != null && this.humans.contains(mother)) {
            mother.addChildren(human);
        }
        if (father != null && this.humans.contains(father)) {
            father.addChildren(human);
        }
        if (childrens.size() > 0) {
            for (Human children : childrens) {
                if (children != null && this.humans.contains(children)) {
                    children.addParent(human);

                }
            }
        }
        humans.add(human);
    }

    public void removeHuman(Human human) {
        if (human.getChildrens().size() > 0) {
            for (Human person : human.getChildrens()) {
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

    public void showChildrensInfo(Human human) {
        System.out.println("\n" + human.getFullName().toUpperCase() + " ИНФОРМАЦИЯ О ДЕТЯХ");
        if (this.humans.contains(human)) {
            List<Human> childrens = human.getChildrens();
            if (childrens.size() > 0) {
                System.out.println(human.convertChildrensToString(childrens));
            } else {
                System.out.println("Детей нет");
            }
        } else {
            System.out.println("Указанный человек отсутствует в генеологическом дереве");
        }

    }

    public Human getHumanByFullName(String fullName) {
        for (Human human : humans) {
            if (human.getFullName().equals(fullName)) {
                return human;
            }
        }
        return null;
    }

    public void showFullTreeInfo() {
        System.out.println("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (Human human : humans) {
            System.out.println(human.getFullHumanInfo());
        }

    }

    public void showShortTreeInfo() {
        System.out.println("\nКРАТКАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (Human human : humans) {
            System.out.println(human.getShortHumanInfo());
        }

    }

    public void showGenderStatistics(Gender gender) {
        List<Human> list = new ArrayList<>();
        for (Human human : humans) {
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
                Human human = getHumanByFullName(fullName);

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
                Human human = getHumanByFullName(fullName);
                result = human.getFather().getFather().getFullName();
            } catch (NullPointerException e) {
                result = "не обнаружено";
            }
            System.out.printf("\nЗАПРОС ПОИСКА ДЕДУШКИ ДЛЯ %s:\n", fullName);
            System.out.println(result);

        }
    }
}
