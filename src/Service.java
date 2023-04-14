import Human.Human;
import Tree.Comparators.humanComparatorByAge;
import Tree.Comparators.humanComparatorBySecondName;
import Tree.Comparators.humanComparatorBySex;

import java.util.List;

public class Service {
    private List<Human> relatives;

    public Service(List<Human> relatives) {
        this.relatives = relatives;
    }
    public void sortBySecondName(){
        relatives.sort(new humanComparatorBySecondName());

    }
    public void sortBySex(){
        relatives.sort(new humanComparatorBySex());

    }
    public void sortByYear(){
        relatives.sort(new humanComparatorByAge());

    }
}
