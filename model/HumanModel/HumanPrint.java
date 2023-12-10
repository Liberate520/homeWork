package model.HumanModel;

import java.util.List;

public class HumanPrint<T extends HumanInterface<T>> {
    private T human;

    public HumanPrint(T human) {
        if (human != null) {
            this.human = human;
        }
    }

    public T getHuman() {
        return this.human;
    }

    public void printChildren() {
        if (this.human.getChildren() == null) {
            System.out.println("no children");
        }
        for (T children : this.human.getChildren()) {
            System.out.println(children.getLastName() + " " + children.getFirstName() + " " + children.getAge());
        }
    }

    public void printHumanBasic(T human) {
        System.out.println(human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
    }

    public static <T extends HumanInterface<T>> void printHumanFLA(T human) {
        if (human != null) {
            System.out.println(human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
        } else {
            System.out.println("Нет данных");
        }
    }

    public static <T extends HumanInterface<T>> void printHumanFLAList(List<T> humanlist) {
        for (T human : humanlist) {
            System.out.println(
                    human.getId() + " " + human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
        }
    }

    public void printParents() {
        if (this.human.getMather() != null) {
            printHumanBasic(this.human.getMather());
        } else if (this.human.getFather() != null) {
            printHumanBasic(this.human.getFather());
        } else {
            System.out.println("no parents");
        }
    }
}
