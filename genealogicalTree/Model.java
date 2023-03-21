package genealogicalTree;

import java.util.ArrayList;
import genealogicalTree.*;

public class Model {

    GenealogicalTree genealogicalTree;
    Human human, humanM, humanF;

    public Model(GenealogicalTree genealogicalTree){
        this.genealogicalTree = genealogicalTree;
    }
    
    public void addMember(ArrayList<String> memberData){
        human = new Human(memberData.get(0), memberData.get(1), Integer.parseInt(memberData.get(2)), Integer.parseInt(memberData.get(3))+1, Integer.parseInt(memberData.get(4)));
        genealogicalTree.addMember(human);
    }

    public void printmember(String name) {
        genealogicalTree.searchName(name).printMember();
    }

    public void printTree() {
        genealogicalTree.printTree();
    }

    public void addParents(ArrayList<String> member) {
        human = genealogicalTree.searchName(member.get(0));
        humanF = genealogicalTree.searchName(member.get(1));
        humanM = genealogicalTree.searchName(member.get(2));
        human.setFather(humanF);
        human.setMother(humanM);
    }
}
