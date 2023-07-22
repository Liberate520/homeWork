package FamTree;

import java.util.ArrayList;
import java.util.Scanner;
public class Searching {
    ArrayList<String>result = new ArrayList<>();
    ArrayList<NodeFamilyTree>tree;
    ArrayList<String>resAge = new ArrayList<>();

    public Searching(FamilyTree familyTree){
        tree = familyTree.getTree();
    }

    public ArrayList<String>spend(Human human, Family familyTree){
        for(NodeFamilyTree t : tree) {
            if(t.h1.humanName == human.humanName && t.family == familyTree){
                result.add(t.h2.humanName);
            }
        }
        return result;
    }

    public ArrayList<String>searchAge(){
        System.out.println("Input age: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("Peoples younger:"+age+":");

        for(NodeFamilyTree t : tree){
            if(t.h1.humanAge <= age && !resAge.contains(t.h1.humanName)){
                resAge.add(t.h1.humanName);
            }
        }
        return resAge;
    }
}
