package model.treeWork;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import model.fileClass.File_interface;
import model.fileClass.Files_working;
import model.treeWork.HumanComparatorName;
import model.treeWork.HumanComparatorToAge;
import model.treeWork.HumanIterator;

public class FamilyTree<T extends ElementTree> implements Serializable, Iterable<T>{


    private List<T> famTree;


    public void setFamTree(List<T> famTree) {
        this.famTree = famTree;
    }

    public T getName() {
        return name;
    }

    private T name;
    public FamilyTree() {
        this.famTree = (new ArrayList<>());
    }

   // @Override
    public void addElement(T element) {
        this.famTree.add((T) element);

    }



//    public void addHuman(T human) {
//
//        this.famTree.add(human);
//        if (human.getFather() != null) {
//            human.getFather().getChildList().add(human);
//        }
//        if (human.getMother() != null) {
//            human.getMother().getChildList().add(human);
//        }
//        if (human.getChildList().size() > 0) {
//            for (model.treeWork.Human child : human.getChildList()) {
//                if (human.getGender().equals("Male")) {
//                    child.setFather(human);
//                } else if (human.getGender().equals("FeMale")) {
//                    child.setMother(human);
//                }
//            }
//        }
//
//    }
//

    public String toString() {
        String res = "";
        for (T hum : famTree) {
            res += hum + "\n";
        }
        return res;
    }

    public void printAllTree() {
        System.out.println("Список всех членов дерева");
        String res = "";
        for (T hum : famTree) {
            res += hum + "\n";
        }
        System.out.println(res);
    }

  public T findByName(String name) {
      for (T hum : famTree) {
          if (((hum.getName().equals(name)))) {
              return hum;
          }
      }
      return null;
  }


    public String findChild(Human hum) {
        return hum.getChildren();
    }


    public String findParents(Human hum) {
        return hum.printParents();
    }

    public List<T> getFamTree() {
        return famTree;
    }
    public List<T> read() throws IOException, ClassNotFoundException {
        File_interface work = new Files_working();
        famTree = (List<T>) new ArrayList<>(work.read_files());
        return (List<T>) famTree;
   }
//
    public void write() throws IOException {
        File_interface work = new Files_working();
        work.write_files((List<ElementTree>) this.famTree);
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(famTree);
    }

    public void sortingByAge() {

        Collections.sort(famTree, new HumanComparatorToAge());
    }

    public void sortingByName() {

        Collections.sort(famTree, new HumanComparatorName());
    }



}



//




