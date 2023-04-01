public class FamilyTree {
    private Person person;

    public FamilyTree(Person person) {
        this.person = person;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        return toString(result, this.person, 1);
    }

    private String toString(StringBuilder result, Person person, int iter) {
        result.append(String.format("%s%s|", person.toString(), getSpace(person.toString())));
        if (person.countChildren() > 0) {
            for (int i = 0; i < person.countChildren(); i++) {
                if (i > 0) result.append(String.format("%s", getSpaces(iter)));
                toString(result, person.getChildren().get(i), iter + 1);
            }
        } else {
            result.append("\n");
        }
        return result.toString();
    }

    private String getSpace(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15 - str.length(); i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private String getSpaces(int iter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            result.append(String.format("%s|", getSpace("")));
        }
        return result.toString();
    }
}