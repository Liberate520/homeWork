import java.util.Collections;
 import java.util.Iterator;
 import java.util.List;

 public class HumanIterator implements Iterator<Human> {
     private int index;
     private List<Human> familyTree;

     public HumanIterator(List<Human> familyTree) {
         this.familyTree = familyTree;
         this.index = 0;
     }

     @Override
     public boolean hasNext() {
         return index < familyTree.size();
     }

     @Override
     public Human next() {
         return familyTree.get(index++);
     }

     public void sortByName() {
         Collections.sort(familyTree);
     }

 }