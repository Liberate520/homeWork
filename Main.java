import model.human.Gender;
import model.human.Human;
import model.tree.relative.Relative;
import model.service.Service;
import model.tree.Compilation;
import model.tree.Node;
import model.workingWithFile.FileData;
import view.Console;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Пока оставила для проверки
//
//        var irina = new Human("Ирина", Gender.Female, LocalDate.of(1990, 12, 12));
//        var kesha = new Human("Кеша", Gender.Male, LocalDate.of(1992, 9, 1));
//        var vasya = new Human("Вася", Gender.Male, LocalDate.of(1940, 3, 15));
//        var masha = new Human("Маша", Gender.Female, LocalDate.of(1972, 9, 10));
//        var jane = new Human("Женя", Gender.Male, LocalDate.of(2017, 4, 2));
//        var ivan = new Human("Ваня", Gender.Male, LocalDate.of(2019, 4, 2));
//        var larisa = new Human("Лариса", Gender.Female, LocalDate.of(2022, 5, 10));
//        Node gt = new Node<>();
//        gt.append(vasya, masha);
//        gt.append(masha, irina);
//        gt.append(irina, jane);
//        gt.append(kesha, jane);
//        gt.append(irina, ivan);
//        gt.append(kesha, ivan);
//        gt.append(irina, larisa);
//        Compilation com = new Compilation(gt);
//        System.out.println("________________");
//        com.printSearch(masha, Relative.parent);
//        com.printSearch(masha, Relative.children);
//        System.out.println("________________");
//        com.printSearch(vasya, Relative.parent);
//        com.printSearch(vasya, Relative.children);
//        System.out.println("________________");
//        com.printSearch(irina, Relative.parent);
//        com.printSearch(irina, Relative.children);
//        System.out.println("________________");
//        com.printSearch(kesha, Relative.parent);
//        com.printSearch(kesha, Relative.children);
//        System.out.println("________________");
//        com.printSearch(ivan, Relative.parent);
//        com.printSearch(ivan, Relative.children);
//        System.out.println("________________");
//        com.printSearch(jane, Relative.parent);
//        com.printSearch(jane, Relative.children);
//        System.out.println("________________");
//        com.printSearch(larisa, Relative.parent);
//        com.printSearch(larisa, Relative.children);
//        System.out.println("*****************");
//        FileData fd = new FileData("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt", "\\s\\|\\s");
//        fd.add(gt);
//        fd.load("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source.txt");
//
//
//        Dog sharik = new Dog("Шарик", dog.Gender.Male, LocalDate.of(2010, 10, 10));
//        Dog mila = new Dog("Мила", dog.Gender.Famale, LocalDate.of(2012, 06, 01));
//        Dog fima = new Dog("Фима", dog.Gender.Male, LocalDate.of(2019, 05, 03));
//        Node dt = new Node<>();
//        dt.append(sharik, fima);
//        dt.append(mila, fima);
//        Compilation dog_com = new Compilation<>(dt);
//        dog_com.printSearch(sharik, Relative.parent);
//        dog_com.printSearch(sharik, Relative.children);
//        FileData fd_dog = new FileData("C:\\Users\\Irina1Fil\\IdeaProjects\\Java_project\\homeWork\\Source_dog.txt", "\\s\\|\\s");
//        fd_dog.add(dt);
//        fd_dog.load("C:\\Users\\IrinaFil\\IdeaProjects\\Java_project\\homeWork\\Source_dog.txt");
//        Service ser = new Service();
//
//        System.out.println(ser.getHumanList());
//        ser.sortByAge();
//        System.out.println(ser.getHumanList());


        View view = new Console();
        view.start();
    }



}