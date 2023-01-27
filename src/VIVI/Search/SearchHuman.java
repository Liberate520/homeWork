package VIVI.Search;

import Homework_6.Designer_Human;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class SearchHuman implements ISearch{
    @Override
    public void search(List<Designer_Human> humans) {
        Scanner iScanner = new Scanner(in);
        System.out.println("Введите имя человека для поиска: ");
        String human = iScanner.nextLine();
        for (Designer_Human с : humans) {
            if (human.equals(с.getName())) {
                System.out.println(с);
            } else {
                System.out.println("Нет людей с таким именем.");
            }
            break;
        }
    }
}
