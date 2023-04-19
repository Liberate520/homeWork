package model;

import java.util.Scanner;

public class FindHuman {
    private FamilyTree familyTree;
    private Scanner scanner;

    public FindHuman(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

    void getHumanByName() {
        System.out.println("Введите фамилию,имя,отчество через запятую:");
        try {
            String name = scanner.next();
            Human human = familyTree.getHumanByName(name);
            if (human == null) {
                System.out.println("По введенному имени в древе родственников не нашлось!");
            } else {
                int countChildren = human.getChildren().size();
                String textAboutChildren = "детей нет";
                if (countChildren > 0) {
                    StringBuilder stb = new StringBuilder("дети: \n");
                    stb.append(" ");
                    for (int i = 0; i < countChildren; i++) {
                        stb.append(human.getChildren().get(i).toString());
                    }
                    textAboutChildren = stb.toString();
                }
                System.out.printf("По введенному имени найден следующий родственник:\n %s %s \n", human.toString(), textAboutChildren);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода параметров поиска! " + e);
        }
    }
}
