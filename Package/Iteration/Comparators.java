package Package.Iteration;

import Package.Tree.Person;

public class Comparators <E extends Person> {
    public Comparators () {}

    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
