package com.example.FamilyTree;

import com.example.FamilyTree.DataForTree.*;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = createHumanList();
        FamilyTree<Family<Human>> familyTree = createFamilyTree(humanList);
        System.out.println("Общий список людей: ");
        System.out.println(familyTree.printHumanList());

        System.out.println("Сортировка по дню рождения: ");
        familyTree.sortByBirthday();
        System.out.println(familyTree.printHumanList());

        System.out.println("Сортировка по имени: ");
        familyTree.sortByName();
        System.out.println(familyTree.printHumanList());
        Scanner scan = new Scanner(System.in);
        String answer = "0";
        do {
            System.out.println("\nВыберите и введите цифру, кому вывести семейное дерево, или показать родственную связь с другим человеком (цифры через пробел): ");
            System.out.println(printHumanList(familyTree));
            System.out.println("---------\n"+
                               "  0: ВЫХОД");
            answer = scan.nextLine();
            if (!answer.equals("0")) {filterFamilyTree(answer, familyTree);}
        } while (!answer.equals("0"));
        scan.close();
    }

    public static List<Human> createHumanList() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Olga Ivanova","1980-11-20", Gender.female));
        humanList.add(new Human("Petr Ivanov","1978-03-10", Gender.male));
        humanList.add(new Human("Alisa Ivanova","2002-08-14", Gender.female));
        humanList.add(new Human("Anton Ivanov","2005-01-10", Gender.male));
        humanList.add(new Human("Mariya Petrova","1955-02-28", Gender.female));
        humanList.add(new Human("Vasiliy Petrov","1950-09-15", Gender.male));
        humanList.add(new Human("Anna Sidorova","1960-12-15", Gender.female));
        humanList.add(new Human("Ivan Sidorov","1959-11-20", Gender.male));
        humanList.add(new Human("Svetlana Petrova","1990-10-10", Gender.female));
        return humanList;
    }

    public static FamilyTree<Family<Human>> createFamilyTree(List<Human> humanList) {
        String path = "./src/main/java/com/example/FamilyTree/FT.txt";
        File file = new File(path);
        FamilyTree<Family<Human>> familyTree = new FamilyTree<>();
        Family<Human> element;
        if (!file.exists()) {
            element = new Family<Human>(humanList.get(0));
            element.addChildren(humanList.get(2));
            element.addChildren(humanList.get(3));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(1));
            element.addChildren(humanList.get(2));
            element.addChildren(humanList.get(3));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(2));
            element.addParents(humanList.get(0));
            element.addParents(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(3));
            element.addParents(humanList.get(0));
            element.addParents(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(4));
            element.addChildren(humanList.get(0));
            element.addChildren(humanList.get(8));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(5));
            element.addChildren(humanList.get(0));
            element.addChildren(humanList.get(8));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(6));
            element.addChildren(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(7));
            element.addChildren(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            element = new Family<Human>(humanList.get(8));
            element.addParents(humanList.get(4));
            element.addParents(humanList.get(5));
            familyTree.addHumanFamilyList(element);

            FileProcessing(1, familyTree, path);
        } else {
            familyTree = (FamilyTree<Family<Human>>) FileProcessing(2, familyTree, path);
        }
        return familyTree;
    }

    public static Object FileProcessing(int index, FamilyTree<Family<Human>> familyTree, String path) {
        FileHandler fileHandler = new FileHandler();
        switch (index){
            case 1: {
                fileHandler.save(path, familyTree);
                return fileHandler;
            }
            case 2: {
                return fileHandler.read(path);
            }
        }
        return null;
    }

    public static String printHumanList(FamilyTree<Family<Human>> familyTree) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (Family<Human> human : familyTree) {
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(human.getHuman());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void filterFamilyTree(String answer, FamilyTree<Family<Human>> familyTree) {
        List<Integer> listNumber = Arrays.stream(answer.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        int allHumans = familyTree.getHumanFamilyList().size();
        if (listNumber.size()==1 && listNumber.get(0)<=allHumans){
            System.out.println(familyTree.getHumanFamilyList().get(listNumber.get(0)-1));
        } else if (listNumber.size()==2 && listNumber.get(0)<=allHumans && listNumber.get(1)<=allHumans){
            showRelatives(familyTree.getHumanFamilyList().get(listNumber.get(0)-1), familyTree.getHumanFamilyList().get(listNumber.get(1)-1), familyTree);
        } else {
            System.out.println("Ошибка ввода, попробуйте снова");
        }
    }

    public static void showRelatives(Family human1, Family human2, FamilyTree familyTree) {
        if (human1.getParents().contains(human2.getHuman())) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (human2.getParents().contains(human1.getHuman())) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (human1.getChildren().contains(human2.getHuman())) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (human2.getChildren().contains(human1.getHuman())) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (getHumanFamilyAtParents(human1,human2,familyTree)) {
             System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - sister " : " - brother") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - sister " : " - brother"));
        } else if (human1.getChildren().equals(human2.getChildren()) && !human1.getChildren().isEmpty()) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - mother " : " - father"));
        } else if (getHumanGrandFamily(human1, human2, familyTree)) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                        human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - grandmother " : " - grandfather"));
        } else if (getHumanGrandFamily(human2, human1, familyTree)) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                        human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - grandmother " : " - grandfather"));
        } else if (getHumanFamilyAtChildren(human1.getChildren(), human2.getChildren(), familyTree)) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law"));
        } else if (getHumanFamilyAtChildren(human2.getChildren(), human1.getChildren(), familyTree)) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law"));
        } else if (getHumanFamilyAllChildren(human2.getChildren(), human1.getChildren(), familyTree)) {
            System.out.println(human1.getHuman() + " - matchmaker" + "\n" +
                    human2.getHuman() + " - matchmaker");
        } else if (getHumanFamilyUncle (human1, human2, familyTree)) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - niece" : " - nephew"));
        } else if (getHumanFamilyUncle (human2, human1, familyTree)) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    human1.getHuman() + (human1.getHuman().getGender() == Gender.female ? " - niece" : " - nephew"));
        }
    }

    public static boolean getHumanGrandFamily(Family human1, Family human2, FamilyTree familyTree) {
        Boolean i = false;
        if (!human1.getParents().isEmpty()) {
            for (int j = 0; j < human1.getParents().size(); j++) {
                if (getHumanFamily((Human) human1.getParents().get(j), familyTree).getParents().contains(human2.getHuman()) ||
                    human2.getChildren().contains(getHumanFamily((Human) human1.getParents().get(j), familyTree).getHuman())) {
                    i = true;
                }
            }
        }
        return i;
    }

    public static boolean getHumanFamilyUncle(Family human1, Family human2, FamilyTree familyTree) {
        Boolean i = false;
        if (!human1.getParents().isEmpty()) {
            for (int j = 0; j < human1.getParents().size(); j++) {
                if (getHumanGrandFamily(human2, getHumanFamily((Human) human1.getParents().get(j), familyTree), familyTree)) {
                    i = true;
                }
            }
        }
        return i;
    }

    public static boolean getHumanFamilyAtParents(Family human1, Family human2, FamilyTree familyTree) {
        Boolean i = false;
        if (!human1.getParents().isEmpty() && !human2.getParents().isEmpty()) {
            if (human1.getParents().equals(human2.getParents())) {
                i = true;
            }
        } else if (!human1.getParents().isEmpty()) {
            for (int j = 0; j < human1.getParents().size(); j++) {
                if (getHumanFamily((Human) human1.getParents().get(j), familyTree).getChildren().contains(human2.getHuman())) {
                    i = true;
                }
            }
        } else if (!human2.getParents().isEmpty()) {
            for (int j = 0; j < human2.getParents().size(); j++) {
                if (getHumanFamily((Human) human2.getParents().get(j), familyTree).getChildren().contains(human1.getHuman())) {
                    i = true;
                }
            }
        }
        return i;
    }

    public static boolean getHumanFamilyAtChildren(List<Human> children1, List<Human> children2, FamilyTree familyTree) {
        Boolean i = false;
        for (int j = 0; j < children1.size(); j++) {
            if (getHumanFamily(children1.get(j), familyTree).getChildren().equals(children2)) {
                    i = true;
            }
        }
        return i;
    }

    public static boolean getHumanFamilyAllChildren(List<Human> children1, List<Human> children2, FamilyTree familyTree) {
        Boolean i = false;
        for (int j = 0; j < children1.size(); j++) {
            for (int k = 0; k < children2.size(); k++) {
                if (getHumanFamily(children1.get(j), familyTree).getChildren().equals(getHumanFamily(children2.get(k), familyTree).getChildren())) {
                    i = true;
                }
            }
        }
        return i;
    }

    public static Family getHumanFamily(Human human, FamilyTree<Family> familyTree) {
        for (int i = 0; i < familyTree.getHumanFamilyList().size(); i++) {
            if (familyTree.getHumanFamilyList().get(i).getHuman().equals(human)) {
                return familyTree.getHumanFamilyList().get(i);
            }
        }
        return new Family(human);
    }
}

