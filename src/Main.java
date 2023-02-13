package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree t1 = new FamilyTree();
        Human a1 = new Human("Male", "25.04.1914", "31.12.2000", "СПБ", "Сергей", "Петрович", "Евдокимов");
        Human a3 = new Human("Female", "28.03.1918", "", "СПБ", "Авдотья", "Павловна", "Евдокимова");
        Human r = new Human(a1, a3, "Female", "07.12.1937", "01.01.2011", "СПБ", "Светлана","Петровна", "Евдокимова");
        Human r1= new Human("Male", "22.06.1990", "", "СПБ", "И", "Ю", "Я");
        a1.addChild(r);
        r.addChild(r1);
        t1.addToFamily(a1);
        t1.addToFamily(a3);
        t1.addToFamily(r);
//        System.out.println("Годков: " + a3.getAge());
//        System.out.println(a3.getAge());
//        System.out.println(r.getAge());
//        System.out.println(t1);
//        System.out.println(t1.findFamily("Ждо"));
//        System.out.println();
//        System.out.println(t1.getChildrenList(a1));
        t1.getStatistics(a1);

        System.out.println(t1.findHumans("Female", "", "", "Евдокимова", "01.01.1937", "", "", "", ""));

//        String t = "";
//        System.out.println(t.isEmpty());



    }


}
