import human.Gender;
import human.Human;
import relative.Relative;
import tree.Compilation;
import tree.Node;
import workingFile.FileData;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        var irina = new Human("Ирина", Gender.Male, LocalDate.of(1990, 12, 12));
        var kesha = new Human("Кеша", Gender.Male, LocalDate.of(1992, 9, 1));
        var vasya = new Human("Вася", Gender.Male, LocalDate.of(1940, 3, 15));
        var masha = new Human("Маша", Gender.Female, LocalDate.of(1972, 9, 10));
        var jane = new Human("Женя", Gender.Male, LocalDate.of(2019, 4, 2));
        var ivan = new Human("Ваня", Gender.Male, LocalDate.of(2019, 4, 2));
        var larisa = new Human("Лаиса", Gender.Male, LocalDate.of(2022, 5, 10));
        Node gt = new Node();
        gt.append(masha, irina);
        gt.append(vasya, masha);
        gt.append(irina, jane);
        gt.append(kesha, jane);
        gt.append(irina, ivan);
        gt.append(kesha, ivan);
        gt.addHuman(larisa);
        gt.toFileString();
        Compilation com = new Compilation(gt);
        gt.append(irina, larisa);
        com.printSearch(larisa, Relative.children);
        com.printSearch(masha, Relative.parent);
        com.printSearch(masha, Relative.children);
        System.out.println();
        com.printSearch(kesha, Relative.parent);
        com.printSearch(kesha, Relative.children);
        System.out.println();
        com.printSearch(irina, Relative.parent);
        com.printSearch(masha, Relative.children);
        System.out.println();
        com.printSearch(vasya, Relative.parent);
        com.printSearch(vasya, Relative.children);
        com.printSearch(ivan, Relative.parent);

        FileData fd = new FileData("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt", "\\s\\|\\s");
        fd.add(gt);
        fd.load("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt");

    }
}
