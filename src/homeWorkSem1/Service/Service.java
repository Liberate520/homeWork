package homeWorkSem1.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class Service <T extends Human> implements Serializable, Iterable<T> {

    Service<T> fileHandler;
    private List<T> humans;

    public void sortbyName1(FamilyTree<T> humansList) { 
        Collections.sort(humansList.getHumans());
    }

    public void sortById(FamilyTree<T> humansList) {
        Collections.sort(humansList.getHumans(), new HumanComparatorbyId());
    }

    public void sortByAge(FamilyTree<T> humansList) {
        Collections.sort(humansList.getHumans(), new HumanComparatorbyAge());
    }

        /** сохранение */
        public void save(Serializable serializable) throws IOException {
            fileHandler.save(serializable);
        }
    
        //* создаем объект кдасса итератор */
        @Override
        public Iterator<T> iterator() {
            return new FamilyTreeIterator<>(humans);
        }

}
