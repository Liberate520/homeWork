import human.Gender;
import human.Human;
import relative.Relative;
import service.Service;
import tree.Compilation;
import tree.Node;
import tree.Tree;
import workingFile.FileData;

import java.time.LocalDate;

public class Main {
    public static <E extends Tree<E>> void main(String[] args) {

        var irina = new Human("Ирина", Gender.Male, LocalDate.of(1990, 12, 12));
        var kesha = new Human("Кеша", Gender.Male, LocalDate.of(1992, 9, 1));
        var vasya = new Human("Вася", Gender.Male, LocalDate.of(1940, 3, 15));
        var masha = new Human("Маша", Gender.Female, LocalDate.of(1972, 9, 10));
        var jane = new Human("Женя", Gender.Male, LocalDate.of(2017, 4, 2));
        var ivan = new Human("Ваня", Gender.Male, LocalDate.of(2019, 4, 2));
        var larisa = new Human("Лариса", Gender.Male, LocalDate.of(2022, 5, 10));
        Node gt = new Node();
        gt.append(vasya, masha);
        gt.append(masha, irina);
        gt.append(irina, jane);
        gt.append(kesha, jane);
        gt.append(irina, ivan);
        gt.append(kesha, ivan);
        gt.append(irina, larisa);
        Compilation com = new Compilation(gt);
        System.out.println("________________");
        com.printSearch(masha, Relative.parent);
        com.printSearch(masha, Relative.children);
        System.out.println("________________");
        com.printSearch(vasya, Relative.parent);
        com.printSearch(vasya, Relative.children);
        System.out.println("________________");
        com.printSearch(irina, Relative.parent);
        com.printSearch(irina, Relative.children);
        System.out.println("________________");
        com.printSearch(kesha, Relative.parent);
        com.printSearch(kesha, Relative.children);
        System.out.println("________________");
        com.printSearch(ivan, Relative.parent);
        com.printSearch(ivan, Relative.children);
        System.out.println("________________");
        com.printSearch(jane, Relative.parent);
        com.printSearch(jane, Relative.children);
        System.out.println("________________");
        com.printSearch(larisa, Relative.parent);
        com.printSearch(larisa, Relative.children);
        System.out.println("*****************");
        FileData fd = new FileData("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt", "\\s\\|\\s");
        fd.add(gt);
        fd.load("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt");

        Service service = new Service();
        service.addHumans(irina);
        service.addHumans(kesha);
        service.addHumans(vasya);
        service.addHumans(masha);
        service.addHumans(jane);
        service.addHumans(ivan);
        service.addHumans(larisa);
        System.out.println(service.getHumanList());
        service.sortByName();
        System.out.println(service.getHumanList());
        service.sortByAge();
        System.out.println(service.getHumanList());
    }
}
