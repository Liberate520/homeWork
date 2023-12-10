package WorkSeminar.model.Persona.Comporators;

import WorkSeminar.model.Tree.TreeEtem;

import java.util.Comparator;

public class ComporatorSortGender<T extends TreeEtem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getGender().compareTo(o2.getGender());
        /*if(o1.getGender() == Gender.Male && o2.getGender() == Gender.Female ){
            return 1;
        } else if (o1.getGender() == Gender.Female && o2.getGender() == Gender.Male) {
            return -1;
        } else return 0;*/
        /*
       /*if(o1.getGender() == Gender.Male){
            return 1;
        } return -1;*/

    }
}

