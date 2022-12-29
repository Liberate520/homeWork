package Homework_1_2;

import java.io.Serializable;
import java.util.*;

public class Femily_Tree implements Serializable {
    private final List<Designer_Human> humans;

    public Femily_Tree() {
        this.humans = new ArrayList();
    }

    public List<Designer_Human> getHumans() {
        return this.humans;
    }

    /**
     * Метод добавления родителей
     *
     * @param human
     * @param father
     * @param mother
     */
    public void addparents(Designer_Human human, Designer_Human father, Designer_Human mother) {
        if (father != null) {
            human.setFather(father);

        }
        if (mother != null) {
            human.setMother(mother);
        }

    }

    /**
     * Метод вывода всех людей из списка
     *
     * @param humans
     */
    public void printDrevo(List<Designer_Human> humans) {
        System.out.println(humans);
    }


    public List<Designer_Human> getTree() {
        return this.humans;
    }

    /**
     * метод вывода всех людей из дерева
     */
    public void ShowALL() {
        for (Designer_Human human : this.humans) {
            System.out.println(human.toString());
        }
    }

    /**
     * Поиск по имени
     *
     * @param name
     * @return Возвращает поле humans
     */
    public List<Designer_Human> showName(String name) {
        for (Designer_Human human : humans) {
            if (human.getName() == name) {
                humans.add((Designer_Human) this.humans);
            }
        }
        return humans;
    }

    /**
     * Еще вариант метода добавления людей
     *
     * @param human
     */
    public void addHuman(Designer_Human human) {
        this.humans.add(human);
    }

    public void searchHuman(List<Designer_Human> humans) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите имя человека для поиска: ");
        String human = iScanner.nextLine();
        for (Designer_Human с : humans) {
            if (human.equals(с.getName())) {
                System.out.println(с);
                break;
            } else {
                System.out.println("Нет людей с таким именем.");
                break;
            }
        }
    }

    /**
     * Метод сортировки
     *
     * @param list
     */
    public void sort(List list) {
        Collections.sort(list);
    }


}

