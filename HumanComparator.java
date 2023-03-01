package comparators;

import main.Human;

public class HumanComparator<Human> implements java.util.Comparator<Human> {

    private String sortParameter;

    public HumanComparator(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    @Override
    public int compare(Human o1, Human o2) {
        if (this.sortParameter.equals("name")) {
            return ((main.Human) o1).getName().compareTo(((main.Human) o2).getName());
        } else if (sortParameter.equals("age")) {
            return Integer.compare(((main.Human) o1).getAge(), ((main.Human) o2).getAge());
        }
        return 0;
    }
}