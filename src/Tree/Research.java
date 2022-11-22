package Tree;

public class Research {
    /**
     * @param person //
     * @param relation//
     * @param tree//
     */
    public static void getRelation(Person person, Relations relation, Tree tree) {
        for (Communications el : tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())
                    && el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    /**
     * @param relation //
     * @param tree//
     */
    public static void getRelation(Relations relation, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getRelation(Person person, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())) {
                System.out.println(el);
            }
        }
    }
}
