package Homework_7;

import Iterator.StaddyIterator;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class Femily_Tree implements Serializable, Iterable<Designer_Human> {//добавил Iterable к конструктору
    // человека
    /*
     *ОПИСАНИЕ КЛАССА
     *В этом классе реализованны итераторы
     */
    public final List<Designer_Human> designer_human; //константа
//Designer_Human designer_human;

    /**
     * Обязательный конструктор
     */
    public Femily_Tree() {
        super();
        this.designer_human = new ArrayList<Designer_Human>();
    }

    /*
     *ИТЕРАТОРЫ
     */
    @Override
    public Iterator<Designer_Human> iterator() {
        return new StaddyIterator(designer_human);
    }

    @Override
    public void forEach(Consumer<? super Designer_Human> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Designer_Human> spliterator() {
        return Iterable.super.spliterator();
    }

    /**
     * Позволяет перебрать объекты коллекции
     */
    public void enumerationСollection(Femily_Tree femily_tree) {
        /*
         * Позволяет перебрать объекты коллекции
         */

        Iterator<Designer_Human> iterator = femily_tree.iterator();
        while (iterator.hasNext()) {
            Designer_Human HHE = iterator.next();
            System.out.println(HHE);
        }
    }


}


