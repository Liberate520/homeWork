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
        Human HB = new Human("name 2", 1); // муж
        Human HC = new Human("name 3", 0); // дочь
        Human HD = new Human("name 4", 1); // сын
        Human HE = new Human("name 5", 0); // Бабушка жены
        Human HF = new Human("name 6", 1); // дедушка жены
        Human HG = new Human("name 5", 0); // Бабушка отца
        Human HH = new Human("name 6", 1); // дедушка отца

        // человек находится в дереве
        // создаём дерево

        //<editor-fold desc="Description">
        HA.addTree();
        HB.addTree();
        HC.addTree();
        HD.addTree();
        HE.addTree();
        HF.addTree();
        HG.addTree();
        HH.addTree();
        //</editor-fold>

        System.out.println(Tree.getHumanList());


        //region Description
        new Link(HA, HB, 300);
        new Link(HA, HC, 800);
        new Link(HA, HD, 800);
        new Link(HA, HE, 900);
        new Link(HA, HF, 900);

        HB.addLink(HC, 801);
        HB.addLink(HD, 801);
        HB.addLink(HG, 901);
        HB.addLink(HH, 901);

        HC.addLink(HD, 300);
        HC.addLink(HE, 1000);
        HC.addLink(HF, 1000);
        HC.addLink(HG, 1000);
        HC.addLink(HH, 1000);

        HD.addLink(HE, 1001);
        HD.addLink(HF, 1001);
        HD.addLink(HG, 1001);
        HD.addLink(HH, 1001);

        HE.addLink(HF, 300);
        HG.addLink(HH, 300);
        //endregion


        System.out.println(Tree.getHumanList(0).getLink());
        System.out.println(Tree.getHumanList(0).getLink(0).getFirst() + " -> " + Tree.getHumanList(0).getLink(0).getSecond());
        System.out.println(Tree.getHumanList(1).getLink());
        System.out.println(Tree.getHumanList(1).getLink(0).getFirst() + " -> " + Tree.getHumanList(1).getLink(0).getSecond());


        Cat cat = new Cat("Киса", HC);

/*
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
*/

    }


}
