import model.Human.Human;
import model.FamilyTreeService;
import model.tree.FamilyTree;
import view.Console;
import view.View;
import presenter.Presenter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human7 = new Human("Федор", "Сидоров",
                LocalDate.of(1938,5,25));//"25.05.1938"
        Human human8 = new Human("Мария", "Сидорова",
                LocalDate.of(1939,6,7));//07.06.1939
        Human human6 = new Human("Виктор", "Иванов",
                LocalDate.of(1934,3,23));//23.03.1934
        Human human5 = new Human("Раиса", "Максимова",
                LocalDate.of(1935,3,15));//15.03.1935
        Human human1 = new Human("Елена", "Иванова",
                LocalDate.of(1965,3,30), human8, human7);//30.03.1965
        Human human2 = new Human("Анатолий", "Иванов",
                LocalDate.of(1964,1,30), human5,human6);//30.01.1964
        Human human3 = new Human("Максим", "Иванов",
                LocalDate.of(1991,9,6),human1, human2);//06.09.1991
        Human human4 = new Human("Аня", "Иванова",
                LocalDate.of(1987,6,10), human1, human2);//10.06.1987

        FamilyTree<Human> tree = new FamilyTree<>();
        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);
        tree.add(human8);

        FamilyTreeService srv = new FamilyTreeService(tree);

        View view = new Console();
        new Presenter(view,srv);
        view.start();

        //новое дерево для проверки восстановления из файла, выше закомментировать tree.add все
//        FamilyTree treeFromFile = srv.read();
//        for (Object item : treeFromFile) {
//            System.out.println(item);
//        };
    }
}
