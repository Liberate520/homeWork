package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree<H extends Human> implements Serializable, FamilyTreeIterator {
    private int id;
    private List<H> familyTree;
    private Scanner scanner;

    public FamilyTree() {
        this.familyTree = new ArrayList<H>();
        this.scanner = new Scanner(System.in);
    }

    List<H> getFamilyTree() {
        return familyTree;
    }

    public void printTree() {
        for (H h : familyTree) {
            System.out.println(h.toString());
        } 
    }

    int getLastId() {
        if (familyTree == null){
            return 0;
        }
        return familyTree.size();
    }

    void addHuman(H human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    Human CreateHuman() {
        try {
            String newHuman = scanner.nextLine();
            newHuman = newHuman.replace(",","  ");
            newHuman = newHuman.replaceAll("\\s+"," ");
            String[] data = newHuman.split("[ ]");

            String name = data[0];
            Human father = getHumanByName(data[2]);
            Human mother = getHumanByName(data[3]);
            int birthYear = Integer.parseInt(data[4]);
            int id = getLastId() + 1;
            return new Human(id, name, getGender(data[1]), father, mother, birthYear);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! " + e);
        }
         return null;
    }

    
    void getHumanByName() {
        System.out.println("Введите имя:");
        try {
            String name = scanner.next();
            Human human = getHumanByName(name);
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


    Human getHumanByName(String name) {
        String nameFull = name.replace(",", " ");
        for (H h : familyTree) {
            if (h.getName().equals(nameFull)) {
                return h;
            }
        }
        return null;
    }

    Gender getGender(String gender) {
        if (gender.equals("M")) {
            return Gender.Male;
        } else if (gender.equals("F")){
            return Gender.Female;
        }
        return null;
    }

    void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    void sortByBirth() {
        familyTree.sort(new HumanComparatorByBirth());
    }

    @Override
    public boolean hasNext() {
        return this.id < familyTree.size();
    }

    @Override
    public H next() {
        return this.familyTree.get(id++);
    }
}
