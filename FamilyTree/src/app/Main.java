package app;

import people.*;
import research.Research;

import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        FamilyTree humans= new FamilyTree("output.txt"); // создала пустой список

        List<Humans> humans1;
        humans1 = new ArrayList<Humans>();

        humans1.add(new Kinship("Jon","Robert","brothers"));
        humans1.add(new Kinship("Kristina","Alisa","sisters"));
        humans1.add(new Kinship("Elvira","Diana","sisters"));
        humans1.add(new Kinship("Andrey","Anton","Andrey father Anton's"));
        humans1.add(new Kinship("Elvira", "Oksana","Oksana mother Elvira's"));
        System.out.println(humans1);

        /**
         * Создание текстого файла
         */
        FileWriter writer = new FileWriter("output.txt");
        for(Humans str: humans1) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();



        while(true) {
            System.out.print("Введите имя:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();

            //для выхода из программы пишем "exit"
            if (str.equals("exit")) {
                return;
            }

            /**
             * Вызов метода поиска по имени, для отображения всех родственных связей
             */
            List<Humans> humansListResult = Research.findHumansByExample(humans1, str);
            for (Humans hum : humansListResult) {
                System.out.println(hum.toString());

            }
        }
    }


}