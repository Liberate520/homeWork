//Реализовать, с учетом ооп подхода, приложение.
//        Для проведения исследований с генеалогическим древом.
//        Идея: описать некоторое количество компонент, например:
//        модель человека
//        компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
//        компонент для проведения исследований
//        дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
//        Под “проведением исследования” можно понимать получение всех детей выбранного человека.
//
//        Сделать PR к проекту: https://github.com/Liberate520/homeWork

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lis = new ArrayList<String>();
//        lis.get(1);

        // нужно создать человека
        Human HA = new Human("name 1", 0); // жена
        Human HB = new Human("name 2", 1);
        // человек находится в дереве
        // создаём дерево
        Tree tree = new Tree();
        // добавление в дерево
        tree.addTree(new Human("name 3", 0));
        tree.addTree(new Human("name 4", 1)); // муж
        System.out.println(tree.getHumanList());

        HA.addTree(tree);
        HB.addTree(tree);

        System.out.println(tree.getHumanList());

        // добавляем связь

        new Link(tree.getHumanList(1), tree.getHumanList(2), 12);

        System.out.println(tree.getHumanList(1).getAllLinks());
        System.out.println(tree.getHumanList(1).getLink(0).getFirst() + " -> " + tree.getHumanList(1).getLink(0).getSecond());
        System.out.println(tree.getHumanList(2).getAllLinks());
        System.out.println(tree.getHumanList(2).getLink(0).getFirst() + " -> " + tree.getHumanList(2).getLink(0).getSecond());


    }


}
