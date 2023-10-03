import people.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> peopleList;
    private String familyName;
    private int count = 1;

    public FamilyTree(String familyName) {
        this.familyName = familyName;
        peopleList = new ArrayList<>();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void addInFamily(Person person) {
        person.setId(count++);
        peopleList.add(person);
    }

    public void isHusbands (Person person1, Person person2) {

        List<Person> person1Husbands = person1.getHusbands();
        person1Husbands.add(person2);
        person1.setHusband(person1Husbands);

        List<Person> person2Husbands = person2.getHusbands();
        person2Husbands.add(person1);
        person2.setHusband(person2Husbands);

    }

    public void isChildren (Person children, Person father, Person mother) {

        children.setMother(mother);
        children.setFather(father);

        List<Person> fatherChild = father.getChildren();
        fatherChild.add(children);
        father.setChildren(fatherChild);

        List<Person> motherChild = mother.getChildren();
        motherChild.add(children);
        mother.setChildren(motherChild);

    }

    public String getPersonInfo(Person person) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(person.getName());
        stringBuilder.append(":\n\n");

        if (!person.getChildren().isEmpty()) {
            stringBuilder.append("Дети:\n");
            for (Person child: person.getChildren()) {
                stringBuilder.append(child);
            }
            stringBuilder.append("\n");
        }

        if (!person.getHusbands().isEmpty()) {
            stringBuilder.append("Супруги:\n");
            for (Person husband: person.getHusbands()) {
                stringBuilder.append(husband);
            }
            stringBuilder.append("\n");
        }

        if (person.getMother() != null) {
            stringBuilder.append("Мать:\n");
            stringBuilder.append(person.getMother());
            stringBuilder.append("\n");
        }

        if (person.getFather() != null) {
            stringBuilder.append("Отец:\n");
            stringBuilder.append(person.getFather());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(familyName);
        stringBuilder.append(":\n");
        for (Person person: peopleList) {
            stringBuilder.append(person.getId());
            stringBuilder.append(". ");
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamilyInfo();
    }
}
