package com.example.FamilyTree;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = createHumanList();
        FamilyTree familyTree = createFamilyTree(humanList);

        Scanner scan = new Scanner(System.in);
        String answer = "0";
        do {
            System.out.println("Выберите и введите цифру, кому вывести семейное дерево,\n" +
                            "или показать родственную связь с другим человеком (цифры через пробел): ");
            for (int i = 0; i < humanList.size(); i++) {
                System.out.println("  "+(i+1)+": " + humanList.get(i));
            }
            System.out.println("---------\n"+
                               "  0: ВЫХОД");
            answer = scan.nextLine();
            if (answer.equals("0")!=true) {filterFamilyTree(answer,humanList, familyTree);}
        } while (answer.equals("0")!=true);
        scan.close();
    }

    public static List<Human> createHumanList() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Olga Ivanova","1980-11-20", Gender.female));
        humanList.add(new Human("Petr Ivanov","1978-03-10", Gender.male));
        humanList.add(new Human("Alisa Ivanova","2002-08-14", Gender.female));
        humanList.add(new Human("Anton Ivanov","2005-01-10", Gender.male));
        return humanList;
    }

    public static FamilyTree createFamilyTree(List<Human> humanList) {
        String path = "./src/main/java/com/example/FamilyTree/FT.txt";
        File file = new File(path);
        FamilyTree familyTree = new FamilyTree();
        if (!file.exists()) {
            HumanFamily element = new HumanFamily(humanList.get(0));
            element.addChildren(humanList.get(2));
            element.addChildren(humanList.get(3));
            familyTree.addHumanFamilyList(element);

            element = new HumanFamily(humanList.get(1));
            element.addChildren(humanList.get(2));
            element.addChildren(humanList.get(3));
            familyTree.addHumanFamilyList(element);

            element = new HumanFamily(humanList.get(2));
            element.addParents(humanList.get(0));
            element.addParents(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            element = new HumanFamily(humanList.get(3));
            element.addParents(humanList.get(0));
            element.addParents(humanList.get(1));
            familyTree.addHumanFamilyList(element);

            familyTree.save(path);
        } else {
            familyTree = familyTree.read(path);
        }
        return familyTree;
    }


    public static void filterFamilyTree(String answer, List<Human> humanList, FamilyTree familyTree) {
        List<Integer> listNumber = Arrays.stream(answer.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        if (listNumber.size()==1 && listNumber.get(0)<=humanList.size()){
            System.out.println(familyTree.getHumanFamilyList(listNumber.get(0)-1));
        } else if (listNumber.size()==2 && listNumber.get(0)<=humanList.size() && listNumber.get(1)<=humanList.size()){
            showRelatives(familyTree.getHumanFamilyList(listNumber.get(0)-1), familyTree.getHumanFamilyList(listNumber.get(1)-1));
        } else {
            System.out.println("Ошибка ввода, попробуйте снова");
        }
    }

    public static void showRelatives(HumanFamily human1, HumanFamily human2) {
        if (human1.getParents().contains(human2.getHuman())) {
            System.out.println(human2.getHuman() + (human2.getHuman().getGender()==Gender.female ? " - mother " : " - father") + "\n" +
                               human1.getHuman() + (human1.getHuman().getGender()==Gender.female ? " - daughter " : " - son") );
        } else if (human1.getChildren().contains(human2.getHuman())) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender()==Gender.female ? " - mother " : " - father") + "\n" +
                               human2.getHuman() + (human2.getHuman().getGender()==Gender.female ? " - daughter " : " - son") );
        } else if (human1.getParents().equals(human2.getParents()) && human1.getParents().isEmpty()==false) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender()==Gender.female ? " - sister " : " - brother") + "\n" +
                               human2.getHuman() + (human2.getHuman().getGender()==Gender.female ? " - sister " : " - brother") );
        } else if (human1.getChildren().equals(human2.getChildren())) {
            System.out.println(human1.getHuman() + (human1.getHuman().getGender()==Gender.female ? " - mother " : " - father") + "\n" +
                               human2.getHuman() + (human2.getHuman().getGender()==Gender.female ? " - mother " : " - father") );
        }
    }
}

