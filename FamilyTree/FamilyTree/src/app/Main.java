package app;

import people.*;
import research.Research;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

         List<String> humans = new ArrayList<>();
         humans.add(String.valueOf(new Status("Эльвира", "ребенок","Оксана", "родитель")));
         humans.add(String.valueOf(new Status("Эльвира", "родитель","Аделина", "ребенок")));
         humans.add(String.valueOf(new Status("Эльвира", "родитель","Мила", "ребенок")));
         humans.add(String.valueOf(new Status("Оксана", "родитель","Владимир", "родитель")));
         

        System.out.println(humans);
        Research file = new Research();
        file.getFormatTxt(Collections.singletonList(humans), "output.txt");


        /**
         * Поиск по имени всех родственных связей, либо можно посмотреть по родственной связи всех.
         */
        System.out.print("Введите имя или родственную связь:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();


        /**
         * Создание результирующего списка с поиском данных
         */
        List<String> result = new ArrayList<>();
        for (String string : humans) {

            if (string.contains(str)) {
                result.add(string);
            }
        }
        System.out.println(result);

    }
}