public class Tree {
    public String getInfo(Person person) {
        return String.format("Name: %s %s\nSex: %s\nAlive: %s\nAge: %d\nMother: %s %s\nFather: %s %s\nSpouse: %s %s\nChildren: %s", person.getFirstName(), person.getLastName(),
                person.getSex(), person.isAlive(), person.getAge(),
                (person.getMother() == null) ? "N/A" : person.getMother().getFirstName(),
                (person.getMother() == null) ? "" : person.getMother().getLastName(),
                (person.getFather() == null) ? "N/A" : person.getFather().getFirstName(),
                (person.getFather() == null) ? "" : person.getFather().getLastName(),
                (person.getSpouse() == null) ? "N/A" : person.getSpouse().getFirstName(),
                (person.getSpouse() == null) ? "" : person.getSpouse().getLastName(),
                (person.getChildren() == null) ? "N/A" : person.getChildren());
    }
}
