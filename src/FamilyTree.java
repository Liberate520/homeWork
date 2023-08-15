import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
     public List<Human> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void familyAdd(Human name){
        familyList.add(name);
    }

    public void setFamilyList(List<Human> familyList) {
        this.familyList = familyList;
    }

    public List<Human> getFamilyList() {
        return familyList;
    }

    public void familyInfo(){
        System.out.println(familyList + "\n");
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator();
    }


    // вложенный класс
    class FamilyIterator implements Iterator<Human> {
        private int index;

        @Override
        public boolean hasNext() {
            return familyList.size() > index;
        }

        @Override
        public Human next () {
            return familyList.get(index++);
        }
    }


}
