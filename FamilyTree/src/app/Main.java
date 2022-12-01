package app;

import people.*;
import research.Research;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        FamilyTree humans = new FamilyTree(); // создала пустой список

        List<Humans> humans1;
        humans1 = new ArrayList<Humans>();

        humans1.add(new Kinship("Bob", "Piter", "brothers"));
        humans1.add(new Kinship("Anna", "Alisa", "sisters"));
        humans1.add(new Kinship("Alexandra", "Irina", "sisters"));
        humans1.add(new Kinship("John", "Vlad", "John father and Vlad"));

        FileWriter writer = new FileWriter("output.txt");
        for (Humans str : humans1) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

        while (true) {
            System.out.print("Введите имя: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();

            if (str.equals("exit")) {
                return;
            }

            List<Humans> humansListResult = Research.findHumansByExample(humans1, str);
            for (Humans hum : humansListResult) {
                System.out.println(hum.toString());
            }

        }

    }

}
