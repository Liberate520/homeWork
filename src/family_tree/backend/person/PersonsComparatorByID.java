package family_tree.backend.person;

import family_tree.backend.ftree.Relatives;

import java.util.Comparator;

public class PersonsComparatorByID<T extends Relatives<T>> implements Comparator<T> {
    @Override
    public int compare(T sel1, T sel2){
        if(sel1.getID() < sel2.getID()){
            return -1;
        } else if(sel1.getID() > sel2.getID()){
            return 1;
        }
        return 0;
    }

}
