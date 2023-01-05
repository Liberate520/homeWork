package homeWorkSem1.Service;

import java.util.Collections;

import homeWorkSem1.FamilyTree;

public class ServiceComparator {

    public void sortbyName1(FamilyTree humansList) { 
        Collections.sort(humansList.getHumans());
    }

    public void sortById(FamilyTree humansList) {
        Collections.sort(humansList.getHumans(), new HumanComparatorbyId());
    }

    public void sortByAge(FamilyTree humansList) {
        Collections.sort(humansList.getHumans(), new HumanComparatorbyAge());
    }

}
