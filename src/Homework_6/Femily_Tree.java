package Homework_6;


import Print.IPrintList;
import Print.PrintList;
import OldClass.PrintMetods;

import Iterator.StaddyIterator;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

import static java.lang.System.in;


public class Femily_Tree implements Serializable, Iterable<Designer_Human>  {//добавил Iterable к конструктору
    // человека
    /*
     *ОПИСАНИЕ КЛАССА
     *В этом классе реализованны методы добавления + итераторы
     */
    private static int id;


//    Designer_Human designer_human;
    PrintMetods printMetods;

    public final List<Designer_Human> designer_human; //константа


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
    public  void forEach(Consumer<? super Designer_Human> action) {
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


