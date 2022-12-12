package app;

import people.*;
import research.*;

import java.io.IOException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {


        List<String> kinships = new ArrayList<>();
        kinships.add(String.valueOf(new Parents("Elvira", "Jon")));
        kinships.add(String.valueOf(new Brothers("Cavin", "Nikita")));
        kinships.add(String.valueOf(new Sisters("Korinna", "Diana")));
        kinships.add(String.valueOf(new Brothers("Alexander", "Nikita")));
        System.out.println(kinships);

        FormatTxt file = new FormatTxt();
        file.getFormatTxt(Collections.singletonList(kinships), "output.txt");

        /**
         * Поиск по имени всех родственных связей, либо можно посмотреть по родственной связи всех.
         */
        System.out.print("Введите имя или родственную связь:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();


        /**
         * Создание результирующего списка с поиском данных
         */
        List <String> result = new ArrayList<>();
        for (String string : kinships) {
            if(string.contains(str)){
                result.add(string);
            }
        }
        System.out.println(result);



        }


    }


