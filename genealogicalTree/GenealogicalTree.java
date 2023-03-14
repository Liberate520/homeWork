package genealogicalTree;
import package1.*;
import sorted.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GenealogicalTree<T extends Human>  implements Serializable, Iterable<T> {
    private ArrayList<T> familyList;
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

    public void addMember(T member){
        familyList.add(member);
        if (member.getFather() != null){
            T p1 = (T) member.getFather();
            p1.addChild(member);
            p1 = (T) member.getMother();
            p1.addChild(member);
        }
    }

    public T searchName (String name){
        T findingHuman = (T) new Human(null, null, 0, 0, 0);
        for (T human : familyList) {
            if (human.getName().equals(name)){
                findingHuman = human;
            }
        }
        return findingHuman;
    }

    public void printTree(){
        for (T member : familyList) {
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
    public Iterator<T> iterator() {
        return new HumanIteratir(familyList);
    }
}


