package model;
/**
 * интерфейс создан для различного вывода древа
 */
public interface OutputTree<T> {
    void printTree(T t); //вывод дерева
    void printChildren(String Name, T t); //вывод всех детей родителя (вывод всех детей узла)

}