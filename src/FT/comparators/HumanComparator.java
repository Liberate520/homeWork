package FT.comparators;

import FT.Human;

public class HumanComparator implements java.util.Comparator<Human> {

    private String sortParameter;
    public HumanComparator(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    @Override
    public int compare(Human o1, Human o2){
        if (this.sortParameter.equals("name")){
            return o1.getName().compareTo(o2.getName());
        } else if (sortParameter.equals("age")) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
        return 0;
    }
}