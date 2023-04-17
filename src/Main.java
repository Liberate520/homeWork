package OOPjavaTree.src;/*Метод обработки введенной фамилии, после метод поиска Персоны по цельной строке Ф.И.Д,
* затем метод создания объекта со связями. Далее метод операции над Персоной, при получении детей/родителей отправить в метод выбора Персоны*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("InfiniteLoopStatement")

    public static void getStart(List<String> people) {
        Tree family = new Tree(people);
        String path = "FamTree/src/Data/DATA.txt";
        while (true) {

            System.out.println("\nВведите фамилию: ");
            String scan = scanner.next();
            List<String> resultFind = new ArrayList<>();
            resultFind = family.searchFamily(scan, resultFind, path);
            if (resultFind.isEmpty()) {
                System.out.println("Фамилия не найдена");
            } else {
                getOnce(resultFind, path, family);
            }
        }
    }

    public static void getOnce(List<String> resultMany, String path, Tree tree) {
        System.out.println("\n0: Ввести другую фамилию: \nВыберите человека для операций: ");
        int scan = scanner.nextInt();
        if (!(scan == 0) && (!(resultMany.get(0).equals("null"))) && (!(scan > resultMany.size()))) {
            Human person = tree.getPerson(resultMany.get(scan - 1), path);
            getOperation(person, path, tree);
        }
    }



    public static void getOperation(Human select, String path, Tree branch) {
        System.out.println("1: Список детей" + "\n2: Список родителей" +
                "\n0: Ввести другую фамилию" + "\nВыберите операцию: ");
        int choice = scanner.nextInt();
        int count = 1;
        switch (choice) {
            case 1:
                for (String child : select.getChildren()) {
                    System.out.printf("\n%d: %s", count++, child);
                }
                getOnce(select.getChildren(), path, branch);
                break;
            case 2:
                for (String parent : select.getParents()) {
                    System.out.printf("\n%d: %s", count++, parent);
                }
                getOnce(select.getParents(), path, branch);
                break;
            case 0:
                break;
        }
    }


    public static void main(String[] args) {
        List<String> people = new ArrayList<>();
        getStart(people);
    }
}