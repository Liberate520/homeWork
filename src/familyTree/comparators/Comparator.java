package homeWork.src.familyTree.comparators;

import homeWork.src.familyTree.Human;

public class Comparator implements java.util.Comparator<Human> {

    private String sortParameter;
    public Comparator(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    /**
     * сравнение двух Human
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return результат сравнения Integer
     */
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
