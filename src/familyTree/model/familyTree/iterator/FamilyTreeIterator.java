package familyTree.model.familyTree.iterator;

import familyTree.model.familyTree.FamilyGroupItem;

import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends FamilyGroupItem<T>> implements Iterator<T> {
        private int index;
        private List<T> list;

        public FamilyTreeIterator(List<T> list){
            this.list = list;
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return list.size() > index;
        }
        @Override
        public T next() {
            return list.get(index++);
        }
    }


