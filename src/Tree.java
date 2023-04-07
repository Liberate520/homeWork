package OOPjava1.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree {
    private final List<Human> branch;
    private final Scanner scanner = new Scanner(System.in);

    public Tree(List<Human> branch) {
        this.branch = branch;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public List<Human> getBranch() {
        return branch;
    }

    public void getStart() {
        System.out.println("\nВведите фамилию: ");
        String scan = scanner.next();
        List<Human> resultFind = new ArrayList<>();
        int count = 1;
        for (Human item : branch) {
            if (item.getFamily().equals(scan)) {
                System.out.printf("\n%d: %s", count++, item);
                resultFind.add(item);
            }
        }
        getOnce(resultFind);

    }

    public void getOnce(List<Human> selectOnce) {
        if (selectOnce.isEmpty()) {
            System.out.println("Фамилия не найдена");
            getStart();
        }
        System.out.println("\n0: Ввести другую фамилию \nВыберите человека для операций: ");
        int scan = scanner.nextInt();
        if (scan == 0) {
            getStart();
        }
        getOperation(selectOnce.get(scan - 1));
    }

    public void getOperation(Human select) {
        System.out.println("1: Список детей" + "\n2: Список родителей" +
                "\n3: Ввести другую фамилию" + "\nВыберите операцию: ");
        int choice = scanner.nextInt();
        int count = 1;
        switch (choice) {
            case 1:
                for (Human child : select.getChildren()) {
                    System.out.printf("\n%d: %s", count++, child);
                }
                getOnce(select.getChildren());
                break;
            case 2:
                for (Human parent : select.getParents()) {
                    System.out.printf("\n%d: %s", count++, parent);
                }
                getOnce(select.getParents());
                break;
            case 3:
                getStart();
                break;
        }
        scanner.close();
    }
}