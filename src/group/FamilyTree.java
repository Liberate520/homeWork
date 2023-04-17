package group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import human.Human;

public class FamilyTree implements Groupable, Serializable {

    private List<Human> famyliTree;

    public FamilyTree() {
        famyliTree = new ArrayList<>();
    }

    int id = 0;

    public void addHuman(Human human) {
        famyliTree.add(human);
        if (human.getMother() != null)
            human.getMother().addChild(human);

        if (human.getFather() != null)
            human.getFather().addChild(human);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public Human getHumanByName(String name) {
        Human findHuman = null;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().equals(name)) {
                findHuman = famyliTree.get(i);
            }
        }
        if (findHuman == null)
            System.out.println("Такой человек не найден.");
        return findHuman;
    }

    public void findHuman(){
        System.out.println("Введите имя или фамилию для поиска:");
        Scanner iScanner=new Scanner(System.in, "cp866");
        String findName=iScanner.nextLine();
        boolean find=false;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().contains(findName)) {
                System.out.println(famyliTree.get(i));
                find=true;
            }    
        }
        if (!find) System.out.println("Такой человек не найден.");
        iScanner.close();
    }

    public List<Human> getHumanList() {
        return famyliTree;
    }
}