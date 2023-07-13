package familyTree;
import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;

 import familyTree.Comporator.AnimalIterator;

 public class FamilyTree<T extends Animal> implements Iterable<T>, Serializable {
     private List<T> familyTree;

     public FamilyTree() {
         familyTree = new ArrayList<>();
     }

     public void addFamilyTree(T human) {
         if (!familyTree.contains(human)) {
             familyTree.add(human);
             if (human.getMather() != null) {
                 human.getMather().addChild(human);
             }
             if (human.getFather() != null) {
                 human.getFather().addChild(human);
             }
         }
     }

     @Override
     public String toString() {
         String res = "В семье " + familyTree.size() + " человек:\n";
         for (int i = 0; i < familyTree.size(); i++) {
             res += (i + 1) + ") " + familyTree.get(i).toString() + "\n";
         }
         return res;
     }

     public T getByName(String humanName) {
         for (T human : familyTree) {
             if (human.getName().equalsIgnoreCase(humanName)) {
                 return human;
             }
         }
         return null;
     }

     public List<T> getfamilyTree() {
         return familyTree;
     }

     @Override
     public Iterator<T> iterator() {
         return new AnimalIterator<T>(familyTree);
         // return familyFree.iterator(); // простой способ достать итератор
     }

 } 