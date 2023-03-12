package genealogicalTree;
import package1.*;
import sorted.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GenealogicalTree  implements Serializable, Iterable<Human> {
    private ArrayList<Human> familyList;
    private Writable fileHandler;

    public GenealogicalTree(){
        this.familyList = new ArrayList();
    }

    public void setFileHandler(Writable fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void save(){
        fileHandler.write(); 
    }

    // public void read(){
    //     FileHandler.read("myTree.txt");
    // }

    public void addMember(Human member){
        familyList.add(member);
        if (member.getFather() != null){
            Human p1 = member.getFather();
            p1.addChild(member);
            p1 = member.getMother();
            p1.addChild(member);
        }
    }

    public Human searchName (String name){
        Human findingHuman = new Human(null, null, 0, 0, 0);
        for (Human human : familyList) {
            if (human.getName().equals(name)){
                findingHuman = human;
            }
        }
        return findingHuman;
    }

    public void printTree(){
        for (Human member : familyList) {
            System.out.println(member.getName() + " " + member.getBirthDate());
        }
        System.out.println();
    }

    public void sortByName(){
        Collections.sort(familyList);
    }

    public void sortByYear(){
        Collections.sort(familyList, new ComparatorByYear());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIteratir(familyList);
    }
}


