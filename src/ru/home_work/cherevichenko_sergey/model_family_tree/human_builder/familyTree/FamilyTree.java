package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    // Класс имеет одно поле с листом
    private List<E> humans;

    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humans) {
        this.humans = humans;
    }


    // Метод для заполнения ArrayList экземплярами класса ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human
    public boolean addHuman(E human) {
        if (human == null) return false;
        if (!humans.contains(human)) humans.add(human);
        return false;
    }

    public String addChildForFamily(String motherName, String motherLastName, String fatherName,
                                    String fatherLastName, String nameChild, String lastNameChild) {
        E child = null;
        boolean findChild = false;
        boolean findFather = false;
        boolean findMother = false;
        StringBuilder br = new StringBuilder();
        for (E human : humans) {
            if (findChild == false) {
                if (human.getName().equals(nameChild) && human.getLastName().equals(lastNameChild)) {
                    child = human;
                    br.append("Ребенок найден!");
                    findChild = true;
                }
            }
        }
        if (findChild == false) {
            br.append(" Ребенка с такими именем и фамилией нет в древе! Добавить? нажмите 1");
        } else if (findChild == true) {

            for (E human : humans) {
                if (findFather == false) {
                    if (human.getName().equals(fatherName) && human.getLastName().equals(fatherLastName)
                            && human.getChildren().contains(child)) {
                        br.append(" Этот ребенок уже добавлен отцу!");
                        findFather = true;
                    } else if (human.getName().equals(fatherName) && human.getLastName().equals(fatherLastName)) {
                        human.getChildren().add(child);
                        br.append(" Ребенок успешно добавлен отцу!");
                        findFather = true;
                    }
                }
                if (findMother == false) {
                    if (human.getName().equals(motherName) && human.getLastName().equals(motherLastName)
                            && human.getChildren().contains(child)) {
                        br.append(" Этот ребенок уже добавлен матери!");
                        findMother = true;
                    } else if (human.getName().equals(motherName) && human.getLastName().equals(motherLastName)) {
                        br.append(" Этот ребенок успешно добавлен матери!");
                        human.getChildren().add(child);
                        findMother = true;

                    }
                }
            }
        }
        if (!findChild && findFather && !findMother) br.append(" Такой матери нет!");
        else if (!findChild && findMother && !findFather) br.append(" Такого отца нет");
        else if (!findMother && !findFather && findChild) br.append(" Таких родителей нет!");
        return br.toString();
    }

    public String removeHuman(String name, String lastName) {
        StringBuilder br = new StringBuilder();
        boolean find = false;
        boolean findChild = false;
        Iterator<E> it = humans.iterator();
        while (it.hasNext()) {
            E itr = it.next();
            if (itr.getName().equals(name) && itr.getLastName().equals(lastName)) {
                it.remove();
                find = true;
            }
        }
        Iterator<E> itr = humans.iterator();
        while (itr.hasNext()) {
            List<E> child = itr.next().getChildren();
            for (int i = 0; i < child.size(); i++) {
                if (child.get(i).getName().equals(name) && child.get(i).getLastName().equals(lastName)) {
                    child.remove(child.get(i));
                    findChild = true;
                }
            }
        }
        if (find && findChild) br.append("Удален успешно из родителя и списка детей!");
        else if (find && !findChild) br.append("Удален успешно!");
        else br.append("Такого человека нет в вашем списке!");

        return br.toString();
    }

    public String findChildren(String name, String lastName) {
        StringBuilder br = new StringBuilder();
        boolean find = false;
        for (E parents : humans) {
            //for (E child : parents.getChildren()) {
            Iterator<E> child1 = parents.getChildren().iterator();
            while (child1.hasNext()) {
                E child = child1.next();
                if (child.getName().equals(name) && child.getLastName().equals(lastName)) {
                    if (!find) {
                        if (child.getGender().equals(Gender.MALE))
                            br.append("НАЙДЕН:").append("\n").append("СЫН: ");
                        else br.append("ДОЧЬ: ");
                        br.append("имя: ")
                                .append(child.getName()).append(", фамилия: ")
                                .append(child.getLastName()).append(", возраст: ");
                        if (child.getDateDeath() == null)
                            br.append(Period.between(child.getBirthDay(), LocalDate.now()).getYears())
                                    .append(" лет");
                        else br.append("Умер в количестве: ")
                                .append(Period.between(child.getBirthDay(), child.getDateDeath()).getYears())
                                .append(" лет");
                        br.append("\n")
                                .append("************************").append("\n");
                    }
                    if (parents.getGender().equals(Gender.MALE))
                        br.append("ОТЕЦ: ");

                    else br.append("МАТЬ: ");

                    br.append(" имя: ").append(parents.getName()).append(", фамилия: ")
                            .append(parents.getLastName()).append(" возраст: ");
                    if (parents.getDateDeath() == null)
                        br.append(Period.between(parents.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
                    else
                        br.append(" умер в возрасте: ")
                                .append(Period.between(parents.getBirthDay(), parents.getDateDeath()).getYears())
                                .append("лет");
                    br.append("\n");
                    find = true;
                }
            }
        }
        if (!find) br.append("Ребенок с таким именем и фамилией НЕ НАЙДЕН!");

        return br.toString();
    }

    public ArrayList<E> getHumans() {
        return new ArrayList<>(humans);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }


    public void sortByName() {
        Collections.sort(humans, new HumanComparatorSortByName<>());
    }

    public void sortByAge() {
        Collections.sort(humans, new HumansComparatorSortByAge<>());
    }

    public void sortByLastName() {
        Collections.sort(humans, new HumanComparatorSortByLaatName<>());
    }

    public void sortByCountChildren() {
        Collections.sort(humans, new HumanComparatorSortByCountChildren<>());
    }

    public String getHumanInfo() {
        StringBuilder builder = new StringBuilder();
        for (E h : humans) {
            if (h.getChildren().isEmpty()) {
                builder.append("имя : ").append(h.getName()).append(" фамилия: ").append(h.getLastName())
                        .append(" пол: ").append(h.getGender());
                if (h.getDateDeath() == null) {
                    builder.append(" Возраст :")
                            .append(Period.between(h.getBirthDay(), LocalDate.now()).getYears())
                            .append(" лет").append("\n");

                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет").append("\n");

                }
            } else {
                builder.append("имя : ").append(h.getName()).append(" фамилия: ").append(h.getLastName())
                        .append(" пол: ").append(h.getGender());
                if (h.getDateDeath() == null) {
                    builder.append(" Возраст :")
                            .append(Period.between(h.getBirthDay(), LocalDate.now()).getYears())
                            .append(" лет").append("\n");

                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет").append("\n");

                }
                if (h.getGender().equals(Gender.MALE)) {
                    builder.append("ОТЕЦ: ");
                } else {
                    builder.append("МАТЬ: ");
                }
                builder.append("имя: ")
                        .append(h.getName())
                        .append(", Фамилия: ")
                        .append(h.getLastName())
                        .append(", возраст: ");
                if (h.getDateDeath() == null) {
                    builder.append(Period.between(h.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет");
                }
                builder.append(", пол: ").append(h.getGender()).append(",дети: ");

                if (h.getChildren().isEmpty()) {
                    builder.append(",нет детей.").append("\n");

                } else {
                    Iterator<E> child1 = h.getChildren().iterator();
                    while (child1.hasNext()) {
                        E ch = child1.next();
                        builder.append("\n").append("имя: ").append(ch.getName())
                                .append(" фамилия: ").append(ch.getLastName())
                                .append(" возраст:")
                                .append(Period.between(ch.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
                    }
                }
            }

            builder.append("\n").append("--------------------------------").append("\n");
        }
        return builder.toString();
    }

    public String toString() {
        return getHumanInfo();
    }
}