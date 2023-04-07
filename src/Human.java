package treePackage;

import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human> {

    private Human mother;
    private Human father;

    private String name;
    private String family;
    private String dateBirth;
    private List<Human> children;

    // родители или муж/жена
    public Human(String name, String family, String dateBirth) {
        this(name, family, dateBirth, null, null);
    }

    // ребенок

    public Human(String name, String family, String dateBirth, Human father, Human mother) {
        this.name = name;
        this.family = family;
        this.dateBirth = dateBirth;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    // добавление ребенка с проверкой

    public boolean addChildren(Human chld) {
        if (!children.contains(chld)) {
            children.add(chld);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;

    }

    public String getMotherInfo() {
        String result = "Мать: ";
        if (mother != null) {
            result += mother.getName();

        } else {
            result += "неизвестна";
        }
        return result;
    }

    public String getFatherInfo() {
        String result = "Отец: ";
        if (father != null) {
            result += father.getName();

        } else {
            result += "неизвестен";
        }
        return result;
    }

    public String getChildrenInfo() {

        StringBuilder infoRes = new StringBuilder();

        infoRes.append("ДЕТИ: ");

        if (children.size() != 0) {

            infoRes.append(children.get(0).getName());

            for (int i = 1; i < children.size(); i++) {
                infoRes.append(", ");
                infoRes.append(children.get(i).getName());

            }
        } else {
            infoRes.append("детей нет");
        }
        return infoRes.toString();

    }

    public String getInfo() {
        StringBuilder infoHumun = new StringBuilder();
        infoHumun.append("Имя: ");
        infoHumun.append(name);
        infoHumun.append("; ");
        infoHumun.append("Фамилия: ");
        infoHumun.append(family);
        infoHumun.append("; ");
        infoHumun.append("Дата рождения: ");
        infoHumun.append(dateBirth);
        infoHumun.append("; ");
        infoHumun.append(getMotherInfo());
        infoHumun.append("; ");
        infoHumun.append(getFatherInfo());
        infoHumun.append("; ");
        infoHumun.append(getChildrenInfo());

        infoHumun.append("; \n");

        return infoHumun.toString();

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals((getName()));
    }

    @Override
    public String toString() {
        return "Human { " + "name = " + name +  "\t" +
                "family = " + family + '}';
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

    public static Object getHumanList() {
        return null;
    }

    public void sort(HumanComparatorByName humanComparatorByName) {
    }

    public void addHumanForSort(Human human) {
    }

}