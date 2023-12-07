package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class FamilyTree<E extends FamilyTreeItem>  implements Serializable, Iterable<E> {
    // Класс имеет одно поле с листом
    private List<E> humans;

    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        this(new ArrayList<>());
    } public FamilyTree(List<E> humans) {
        this.humans = humans;
    }


    // Метод для заполнения ArrayList экземплярами класса ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human
    public  boolean addHuman(E human) {
        if (human == null)  return false;
        if (!humans.contains(human))  humans.add(human);
        return false;
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

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E h : humans) {
            if (h.getChildren().isEmpty()) {
                builder.append("РЕБЕНОК: ");
            }else if (h.getGender().equals(Gender.MALE)){
                builder.append("ОТЕЦ: ");
            }else {
                builder.append("МАТЬ: ");
            }
            builder.append("имя: ")
                    .append(h.getName())
                    .append(", Фамилия: ")
                    .append(h.getLastName())
                    .append(", возраст: ");
            if (h.getDateDeath() == null) {
                builder.append(Period.between(h.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
            }else{
                builder.append(" умер в количестве: ")
                        .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                        .append(" лет");
            }

            builder.append(", пол: ")
                    .append(h.getGender()).append(",дети: ");
            if (h.getChildren().isEmpty()) {
                builder.append(",нет детей.").append("\n");

            }else {
                ArrayList<E> child = new ArrayList<>();
                Iterator<E> it = h.getChildren().iterator();
                while (it.hasNext()) {
                    child.add(it.next());
                    for (E ch : child) {
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

}



















