package Homework_3;

import java.io.Serializable;
import java.util.*;

public class Femily_Tree implements Serializable,Iterable<Designer_Human>{//добавил Iterable к
    // конструктору человека
    private List<Designer_Human> humans;

//    public Femily_Tree() {
//        humans = new ArrayList();
//    }


//    public List<Designer_Human> getHumans() {
//        return this.humans;
//    }
//    public List<Designer_Human> getHumans(){
//        return humans;
//    }


    public Femily_Tree() {
        super();
        this.humans = new ArrayList<Designer_Human>();
    }

    public List<Designer_Human> getHumans() {
        return humans;
    }

    /**
     * Метод добавления родителей
     *
     * @param human
     * @param father
     * @param mother
     */
    public void addParents(Designer_Human human, Designer_Human father, Designer_Human mother) {
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
    public void ShowALL(List<Designer_Human> humans) {
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

    /**
//     * метод добавления очередной
//     * @param Humman
//     */
//    public void addHumanH(Designer_Human Humman) {
//        humans.add(Humman);
//    }

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



    @Override
    public Iterator<Designer_Human> iterator() {
        return new StaddyIterator(humans); //Реализуем функционал
    }


}





