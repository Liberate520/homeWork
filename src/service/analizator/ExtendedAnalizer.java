package service.analizator;

import service.classes.Person;

public class ExtendedAnalizer extends PersonAnalizer {

    @Override
    public void analyze() {
        line.addPosition("\n__________________________________Find children_______________________________\n");
        showChildrenTree();
        this.stats = line.toString();
    }

    public void showChildrenTree() {
        String spacer = "";
        childrenTreeWorker(super.testPerson, spacer);
    }

    private void childrenTreeWorker(Person person, String spacer) {
        if (!person.getChildren().isEmpty()) {
            line.addPosition(spacer + "Parent: " + person.getName() + " "
                    + person.getFamilyname() + " " + person.getGender() + "\n");
            line.addPosition(spacer + "Children: " + "\n");

            for (Person child : person.getChildren()) {
                line.addPosition(spacer + child.getName() + " " + child.getFamilyname() + " "
                        + child.getGender() + " " + child.getMarigeStatus() + "\n");

                spacer += " |";
                childrenTreeWorker(child, spacer);
            }
        }
    }


    @Override
    public String getStats() {
        return stats;
    }


    public ExtendedAnalizer(Person person) {
        super(person);
    }
}
