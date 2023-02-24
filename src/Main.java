package src;

import src.comparator.SortBy;
import src.presenter.Presenter;
import src.ui.Console;
import src.ui.View;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> t1 = new FamilyTree<>();
//        Human a5 = new Human("Male", "25.04.1920", "", "Москва", "Иван", "Федорович", "Спиридонов");
//        Human a1 = new Human("Male", "25.04.1914", "31.12.2000", "СПБ", "Сергей", "Петрович", "Евдокимов");
//        Human a3 = new Human("Female", "28.03.1918", "", "СПБ", "Авдотья", "Павловна", "Евдокимова");
//        Human r = new Human(a1, a3, "Female", "07.12.1937", "01.01.2011", "СПБ", "Светлана","Петровна", "Евдокимова");
//        Human r1= new Human("Male", "22.06.1990", "", "СПБ", "И", "Ю", "Я");
////        System.out.println(a5.getId());
//        a1.addChild(r);
//        r.addChild(r1);
//        t1.addToFamily(a1);
//        t1.addToFamily(a3);
//        t1.addToFamily(r);
//        t1.addToFamily(a5);
//        System.out.println(t1);
//        t1.save();
//
        t1.load();
//        for (Human h :
//                t1) {
//            System.out.println(h);
//        }
//        t1.load();
//        System.out.println(t1);
//        System.out.println(t1.findHumans("Male", "", "", "", "", "", "", "", ""));

        Human nh = new Human();
        View view = new Console();
        new Presenter(view, t1);
        System.out.println("-----------------");
        view.start();


        //        t1.getStatistics(t1.findHumans("Male", "", "", "", "", "", "", "", "").get(0));
//        TreeFilter<Human> tf = new TreeFilter<>();
//        System.out.println(tf.filter(t1.getFamily(), "Male", Human::getGender, FilterType.STRING));

//        for (Human h :
//                t1) {
//            System.out.println(h);
//        }
//        t1.addToFamily(a5);
//        t1.sortByAge();
//        System.out.println("----------------------------------------");
//
//        for (Human h :
//                t1) {
//            System.out.println(h);
//        }
//
//        System.out.println("----------------------------------------");
//
//        t1.sort(SortBy.DATE_OF_BIRTH);
//
//        for (Human h :
//                t1) {
//            System.out.println(h);
//        }



        //        FamilyTree t2 = new FamilyTree();
//        t2.load();
////        t1.load();
//        System.out.println(t2);
//        t2.getStatistics(a1);

//        System.out.println("Годков: " + a3.getAge());
//        System.out.println(a3.getAge());
//        System.out.println(r.getAge());
//        System.out.println(t1);
//        System.out.println(t1.findFamily("Ждо"));
//        System.out.println();
//        System.out.println(t1.getClildrenAndGrandsonsList(a1));
//        t1.getStatistics(a1);
//        t1.addToFamily(r1);
//        Dates d = new Dates();
//
//        System.out.println(t1.findHumans("Male", "", "", "", "", "", "", "", "СПБ").size());
//        FileRW fa1 = new FileRW();
//        fa1.saveFile(a1, "a1");
//
//        FileRW f = new FileRW();
//        Object t1 = f.loadFile("out1");
//        if(t1 instanceof FamilyTree res){
//            System.out.println("OK");
//            System.out.println(res);
//        } else {
//            System.out.println("Не OK");
//        }
    }

}
