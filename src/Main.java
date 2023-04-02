import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Human human7 = new Human("Федор", "Сидоров", "25.05.1938");
        Human human8 = new Human("Мария", "Сидорова", "07.06.1939");
        Human human6 = new Human("Виктор", "Иванов", "23.03.1934");
        Human human5 = new Human("Раиса", "Максимова", "15.03.1935");
        Human human1 = new Human("Елена", "Иванова", "30.03.1965", human8, human7);
        Human human2 = new Human("Анатолий", "Иванов", "30.01.1964", human5,human6);
        Human human3 = new Human("Максим", "Иванов", "06.09.1991",human1, human2);
        Human human4 = new Human("Аня", "Иванова", "10.06.1987", human1, human2);


        FamilyTree tree = new FamilyTree();
        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);
        tree.add(human8);

        System.out.println(tree);
        tree.searchForSurnameandName("Иванова", "Аня");// вывод данного человека и его детей


    }


}