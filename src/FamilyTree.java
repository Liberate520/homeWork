import java.util.*;

public class FamilyTree {
    private List<HashMap<Relation, List<Person>>> persons;

    public FamilyTree (){
        this.persons = new ArrayList<>();
    }

    private void fillPerson (Person targetPerson, Relation relation, LinkedHashMap<Relation, List<Person>> relatives) {
        List<Person> membersInRelative = new ArrayList<>();
        membersInRelative.add(targetPerson);
        relatives.put(relation, membersInRelative);
        this.pushToTree(targetPerson);
    }

    private void fillPersonList (List<Person> personList, LinkedHashMap<Relation, List<Person>> relatives,
                                 Relation maleRelation, Relation femaleRelation, Person mother, Person father) {
        List<Person> maleInRelative = new ArrayList<>();
        List<Person> femaleInRelative = new ArrayList<>();
        for (Person record: personList) {
            if (record.getSex() == Sex.Male) {
                maleInRelative.add(record);
                relatives.put(maleRelation, maleInRelative);
            } else {
                femaleInRelative.add(record);
                relatives.put(femaleRelation, femaleInRelative);
            }
            record.setMother(mother);
            record.setFather(father);
        }
    }

    /**
     * @param person
     */
    public void pushToTree (Person person) {

        if (this.getPerson(person.getFirstName(), person.getLastName()) == null) {
            LinkedHashMap<Relation, List<Person>> relatives = new LinkedHashMap<>();
            Person targetPerson;

            {
                List<Person> membersInRelative = new ArrayList<>();
                membersInRelative.add(person);
                relatives.put(Relation.Person, membersInRelative);
            }

            if ((targetPerson = person.getWife()) != null) {
                this.fillPerson(targetPerson, Relation.Wife, relatives);
            }

            if ((targetPerson = person.getHusband()) != null) {
                this.fillPerson(targetPerson, Relation.Husband, relatives);
            }

            if ((targetPerson = person.getMother()) != null) {
                this.fillPerson(targetPerson, Relation.Mother, relatives);;
            }

            if ((targetPerson = person.getFather()) != null) {
                this.fillPerson(targetPerson, Relation.Father, relatives);
            }

            if (person.getBrothersOrSistersList().size() != 0) {
                this.fillPersonList(person.getBrothersOrSistersList(), relatives,
                        Relation.Brother, Relation.Sister, person.getMother(), person.getFather());
            }

            if (person.getChildrens().size() != 0) {
                this.fillPersonList(person.getChildrens(), relatives,
                        Relation.Son, Relation.Daughter, person, person.getWife());
            }
            this.persons.add(relatives);
        }

    }

    /**
     * @param firstName
     * @param lastName
     * @param relation
     * @return String
     */
    public String getInfo(String firstName, String lastName, Relation relation) {
        StringBuilder output = new StringBuilder();
        for (HashMap<Relation, List<Person>> record: persons) {
            for (Person personItem: record.get(Relation.Person)) {
                if (personItem.getFirstName().equals(firstName) &&
                        personItem.getLastName().equals(lastName)) {
                    if (record.get(relation) != null) {
                        for (Person relationItem: record.get(relation)) {
                            output.append(relationItem);
                            output.append("---------------------------------" + "\n");
                        }
                        return output.toString();
                    }
                }
            }
        }
        output.append("Запись отсутствует.");
        return output.toString();
    }

    public String getInfo(String firstName, String lastName) {
        Relation relation = Relation.Person;
        StringBuilder output = new StringBuilder();
        for (HashMap<Relation, List<Person>> record: persons) {
            for (Person personItem: record.get(Relation.Person)) {
                if (personItem.getFirstName().equals(firstName) &&
                        personItem.getLastName().equals(lastName)) {
                    if (record.get(relation) != null) {
                        for (Person relationItem: record.get(relation)) {
                            output.append(relationItem);
                            output.append("---------------------------------" + "\n");
                        }
                        return output.toString();
                    }
                }
            }
        }
        output.append("Запись отсутствует.");
        return output.toString();
    }

    public Person getPerson(String firstName, String lastName) {
        Relation relation = Relation.Person;
        for (HashMap<Relation, List<Person>> record: persons) {
            for (Person personItem: record.get(Relation.Person)) {
                if (personItem.getFirstName().equals(firstName) &&
                        personItem.getLastName().equals(lastName)) {
                    return personItem;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("All records of Family Tree:" + "\n");
        output.append("##################################" + "\n");
        for (HashMap<Relation, List<Person>> record: persons) {
            String indent = "";
            for (Person item: record.get(Relation.Person)) {
                output.append(item.getFirstName() + " " + item.getLastName() + "\n");
            }
            output.append("---------------------------------" + "\n");
        }
        output.append("##################################" + "\n");
        return output.toString();
    }
}
