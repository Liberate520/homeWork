package homeWork.tree2;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {
    private ArrayList<Human> families;


    public FamilyTree() {
        families = new ArrayList<>();
    }

    public void addPeople(Human person) {
        families.add(person);
    }

    public String getFamilies() {
        StringBuilder sb = new StringBuilder();
        for(Human person : families){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Human findPersonByName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(Human man: families) {
            if(man.getName().equalsIgnoreCase(name)){
                return man;
            }
        }
        return null;
    }


}
