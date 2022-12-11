package service.analizator;

import service.classes.Person;
import service.dataBase.DBHandler;

/*
Класс для поиска рекурсивно детей у всех потомков
 */
public class ExtendedPersonAnalizer extends PersonAnalizer {

    @Override
    public void analyze() {
        super.analyze();
        line.addPosition("\n__________________________________Find children_______________________________\n");
        startChildrenTree();
        this.stats = line.toString();
    }

    public void startChildrenTree() {
        String spacer = "";
        childrenTreeWorker(super.testPerson, spacer);
    }

    /*
    рекурсивно просматриваем детей у всех потомков
     */
    private void childrenTreeWorker(Person person, String spacer) {
        if (person.getChildren().size() != 0) {
            line.addPosition(spacer + "Parent: " + person.getName() + " "
                    + person.getFamilyName() + " " + person.getGender() + "\n");
            line.addPosition(spacer + "Children: " + "\n");

            for (Integer childIndex : person.getChildren()) {
                Person child = db.getPerson(childIndex);
                line.addPosition(spacer + child.getName() + " " + child.getFamilyName() + " "
                        + child.getGender() + " " + child.getMarriageStatus() + "\n");

                spacer += " |";
                childrenTreeWorker(child, spacer);
            }
        }
    }

    public ExtendedPersonAnalizer(Person person, DBHandler db) {
        super(person, db);
    }
}
