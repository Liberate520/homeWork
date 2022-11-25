package Tree;

public class Research {
    public static void getRelation(Human person, Relations relation, Tree tree) {
        for (Link el : tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())
                    && el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getRelation(Relations relation, Tree tree) {
        for (Link el :
                tree.getLinks()) {
            if (el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getRelation(Human person, Tree tree) {
        for (Link el :
                tree.getLinks()) {
            if (el.getPeople().getFirstName().equals(person.getFirstName()) &&
                    el.getPeople().getSurName().equals(person.getSurName())) {
                System.out.println(el);
            }
        }
    }
}

