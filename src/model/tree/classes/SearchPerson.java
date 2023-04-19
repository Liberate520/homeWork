package model.tree.classes;

import java.util.List;
import java.util.Scanner;

public class SearchPerson {
    private Tree tree;
    private Scanner scanner = new Scanner(System.in, "cp866");

    public SearchPerson(Tree tree) {
        this.tree = tree;
    }

    public Human searchPerson() {

        System.out.println("Введите имя для поиска:");
        String name = scanner.nextLine();
        List<Human> matched = tree.searchPerson(name);
        boolean found = false;

        if (matched.size() == 0) {
            System.out.println("Совпадений не найдено.");
            return null;
        }

        else if (matched.size() == 1) {
            return matched.get(0);
        }

        else {
            for (int i = 0; i < matched.size(); i++) {
                System.out.println(i + ": " + matched.get(i).toString());
            }
            while (!found) {
                System.out.println("Выберите номер человека или -1 для отмены поиска: ");
                String indexString = scanner.nextLine();
                int indexInt;
                try {
                    indexInt = Integer.parseInt(indexString);
                    if (indexInt >= 0 & indexInt < matched.size()) {
                        found = true;
                        return matched.get(indexInt);
                    } else if (indexInt == -1) {
                        return null;
                    } else {
                        System.out.println("Ошибка ввода If!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода Catch!");
                }
            }
        }
        return null;
    }

    public void printSearched() {
        Human search = searchPerson();
        if (search != null) {
            System.out.println(search.toString());
        } else {
            System.out.println("Не найдено.");
        }
    }
}
