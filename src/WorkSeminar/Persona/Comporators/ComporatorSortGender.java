package WorkSeminar.Persona.Comporators;

import WorkSeminar.Persona.Persona;

import java.util.Comparator;

public class ComporatorSortGender implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
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

