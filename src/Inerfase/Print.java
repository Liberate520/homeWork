package Inerfase;

import Homework_5.Designer_Human;
import Homework_5.Femily_Tree;

import java.util.List;
import java.util.function.Consumer;


public interface Print {
    void printDrevo(List<Designer_Human> humans);
//    //Вопросы
//
//    Femily_Tree femily_tree = new Femily_Tree();
//
//    default void printDrevo(List<Designer_Human> humans) {
//        System.out.println(humans);
//    }
//
//     default void printTheTreeForEach() {
//         femily_tree.forEach(Designer_Human -> System.out.println());
//         femily_tree.forEach(System.out::println); //указатель на метод выше
//
//
//    }



}
