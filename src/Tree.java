import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humans;

    public Tree(List<Human> humans) {
        this.humans = humans;
    }

    public Tree() {
        this.humans = new ArrayList<Human>();
    }

    public void AddHuman(Human human) {
        Human mother = human.GetMother();
        Human father = human.GetFather();
        List<Human> childrens = human.GetChildrens();
        if (mother != null && this.humans.contains(mother)) {
            mother.CheckChildrenRelation(human);
        }
        if (father != null && this.humans.contains(father)) {
            father.CheckChildrenRelation(human);
        }
        if (childrens.size() > 0) {
            for (Human children : childrens) {
                if (children != null && this.humans.contains(children)) {
                    children.CheckParentsRelationAdd(human);
                }
            }
        }
        humans.add(human);
    }

    public void RemoveHuman(Human human) {
        if (human.GetChildrens().size() > 0) {
            for (Human person : human.GetChildrens()) {
                person.CheckParentsRelationRemove(human);
            }
        }
        if (human.GetMother() != null) {
            human.GetMother().RemoveChildren(human);
        }

        if (human.GetFather() != null) {
            human.GetFather().RemoveChildren(human);
        }
        humans.remove(human);
    }

    public void ShowChildrensInfo(Human human) {
        System.out.println("\n" + human.GetFullName().toUpperCase() + " ИНФОРМАЦИЯ О ДЕТЯХ");
        if (this.humans.contains(human)) {
            List<Human> childrens = human.GetChildrens();
            if (childrens.size() > 0) {
                System.out.println(human.ConvertChildrensToString(childrens));
            } else {
                System.out.println("Детей нет");
            }
        } else {
            System.out.println("Указанный человек отсутствует в генеологическом дереве");
        }

    }

    public Human GetHumanByFullName(String fullName) {
        for (Human human : humans) {
            if (human.GetFullName().equals(fullName)) {
                return human;
            }
        }
        return null;
    }

    public void ShowFullTreeInfo() {
        System.out.println("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (Human human : humans) {
            System.out.println(human.GetFullHumanInfo());
        }

    }

    public void ShowShortTreeInfo() {
        System.out.println("\nКРАТКАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ");
        for (Human human : humans) {
            System.out.println(human.GetShortHumanInfo());
        }

    }

    public void ShowGenderStatistics(Gender gender) {
        List<Human> list = new ArrayList<>();
        for (Human human : humans) {
            if (human.GetGender().equals(gender)) {
                list.add(human);
            }
        }
        System.out.printf("\nСПИСОК ВСЕХ ЛЮДЕЙ %s ПОЛА В ДЕРЕВЕ\n", gender.value);
        System.out.println(list);
    }

    public void ShowGrandmotherInfo(String fullName) {
        if (!fullName.equals(null)) {
            String result;
            try {
                Human human = GetHumanByFullName(fullName);

                result = human.GetMother().GetMother().GetFullName();
            } catch (NullPointerException e) {
                result = "не обнаружено";
            }
            System.out.printf("\nЗАПРОС ПОИСКА БАБУШКИ ДЛЯ %s:\n", fullName);
            System.out.println(result);

        }
    }

    public void ShowGrandfatherInfo(String fullName) {
        if (!fullName.equals(null)) {
            String result;
            try {
                Human human = GetHumanByFullName(fullName);
                result = human.GetFather().GetFather().GetFullName();
            } catch (NullPointerException e) {
                result = "не обнаружено";
            }
            System.out.printf("\nЗАПРОС ПОИСКА ДЕДУШКИ ДЛЯ %s:\n", fullName);
            System.out.println(result);

        }
    }
}
