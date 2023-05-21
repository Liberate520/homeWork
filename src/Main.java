import model.Elements.Human;
import model.Elements.TreeElement;
import model.HumanModel;
import model.Tree.FromTo;
import model.Tree.FromToSerializeFile;
import model.Tree.GenealogicalTree;
import UI.Console;
import UI.View;
import presenter.Presenter;

public class Main {
    public static void main(String[] args) {

        // Создание объектов model.Elements.Human.
        Human human1 = new Human("Пушкин Лев Александрович", 1723, 1790);
        Human human2 = new Human("Чичерина Ольга Васильевна", 1737, 1802);
        Human human3 = new Human("Пушкин Сергей Львович", 1770, 1848);
        Human human4 = new Human("Ганнибал Надежда Осиповна", 1775, 1836);
        Human human5 = new Human("Пушкина Ольга Сергеевна", 1797, 1868);
        Human human6 = new Human("Пушкин Александр Сергеевич", 1799, 1837);
        Human human7 = new Human("Пушкин Лев Сергеевич", 1805, 1852);
        Human human8 = new Human("Гончарова Наталья Николаевна", 1812, 1863);

        // Создание связей между model.Elements.Human.
        human1.setSpouse(human2);
        human2.setSpouse(human1);
        human2.addChildren(human3);
        human3.setFather(human1);
        human3.setMother(human2);

        human3.setSpouse(human4);
        human4.setSpouse(human3);
        human3.addChildren(human5);
        human3.addChildren(human6);
        human3.addChildren(human7);
        human4.addChildren(human5);
        human4.addChildren(human6);
        human4.addChildren(human7);
        human5.setFather(human3);
        human5.setMother(human4);
        human6.setFather(human3);
        human6.setMother(human4);
        human7.setFather(human3);
        human7.setMother(human4);
        human6.setSpouse(human8);
        human8.setSpouse(human6);

        human6.setSpouse(human8);
        human8.setSpouse(human6);

        // Создание генеалогического дерева.
        GenealogicalTree<Human> pushkin = new GenealogicalTree<>();
        pushkin.addElement(human1);
        pushkin.addElement(human2);
        pushkin.addElement(human3);
        pushkin.addElement(human4);
        pushkin.addElement(human5);
        pushkin.addElement(human6);
        pushkin.addElement(human7);
        pushkin.addElement(human8);


        System.out.println(human4.getChildrensName());
        System.out.println();

        for (String human:
                pushkin.getViewFamily()) {
            System.out.println(human);
        }
        System.out.println();

        System.out.println(pushkin.findElement("Пушкин Сергей Львович"));
        System.out.println();

        System.out.println(pushkin.findElement("Пушкин Александр Сергеевич").getSpouse().getName());
        System.out.println();


        // Сериализация в файл.
        FromTo savedFamily = new FromToSerializeFile("pushkin.out");
        savedFamily.saveTo(pushkin);


        // Получение списка имён из загруженного дерева.
        System.out.println("Загружено из файла:");
        System.out.println();
        GenealogicalTree<TreeElement> loadedPushkin = savedFamily.readFrom("pushkin.out");
        for (String human:
                loadedPushkin.getViewFamily()) {
            System.out.println(human);
        }
        System.out.println();


        // Перебор human в дереве
        for (Human human :
                pushkin) {
            System.out.println(human);
        }


        // Сортировка по умолчанию по дню рождения (от младших к старшим).
        pushkin.sort();
        for (String human:
                pushkin.getViewFamily()) {
            System.out.println(human);
        }
        System.out.println();


        // Сортировка по имени.
        pushkin.sortByName();
        for (String human:
                pushkin.getViewFamily()) {
            System.out.println(human);
        }
        System.out.println();


        // MVP реализация
        View view = new Console();
        new Presenter(new HumanModel(pushkin), view);

        //Можно начать с выгрузки дерева из файла.
 //       new Presenter(new HumanModel(),view);
        view.start();


    }


}
