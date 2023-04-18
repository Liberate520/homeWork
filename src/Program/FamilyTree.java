package Program;

import Saving.FileOutStr;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class FamilyTree implements Serializable {
    private HashSet<Person> personsSet;

    public FamilyTree() {
        this.personsSet = new HashSet<>();
    }

    public void pushToTree(Person person) {

        this.personsSet.add(person);

        Person spouse = person.getSpouse();
        Person father = person.getFather();
        Person mother = person.getMother();

        if (spouse != null) {
            spouse.setSpouse(person);
            if (person.getChildrenSet() != null) {
                spouse.addChildren(person.getChildrenSet());
            }
            this.personsSet.add(spouse);
        }

        if (father != null) {
            father.addChildren(person);
            if (mother != null) {
                father.setSpouse(mother);
            }
            this.personsSet.add(father);
        }

        if (mother != null) {
            mother.addChildren(person);
            if (father != null) {
                mother.setSpouse(father);
            }
            this.personsSet.add(mother);
        }

        HashSet<Person> brothersOrSistersSet = person.getBrothersOrSistersSet();
        if (brothersOrSistersSet != null && brothersOrSistersSet.size() == 1) {
            Iterator<Person> iterator = brothersOrSistersSet.iterator();
            while (iterator.hasNext()) {
                Person item = iterator.next();
                item.setMother(person.getMother());
                item.setFather(person.getFather());
                item.addBrotherOrSisterSet(person);
                this.personsSet.add(item);
            }
        } else if (brothersOrSistersSet != null && brothersOrSistersSet.size() > 1) {
            Iterator<Person> iterator = brothersOrSistersSet.iterator();
            while (iterator.hasNext()) {
                Person item = iterator.next();
                item.setMother(person.getMother());
                item.setFather(person.getFather());
                item.addBrotherOrSisterSet(person);
                HashSet<Person> copyBrothersOrSistersSet = new HashSet<>(brothersOrSistersSet);
                copyBrothersOrSistersSet.remove(item);
                item.addBrotherOrSisterSet(copyBrothersOrSistersSet);
                this.personsSet.add(item);
            }
        }

        HashSet<Person> childrenSet = person.getChildrenSet();
        if (childrenSet != null && childrenSet.size() == 1) {
            Iterator<Person> iterator = childrenSet.iterator();
            while (iterator.hasNext()) {
                Person item = iterator.next();
                item.setMother(person.getSpouse());
                item.setFather(person);
                this.personsSet.add(item);
            }
        } else if (childrenSet != null && childrenSet.size() > 1) {
            Iterator<Person> iterator = childrenSet.iterator();
            while (iterator.hasNext()) {
                Person item = iterator.next();
                item.setMother(person.getMother());
                item.setFather(person.getFather());
                HashSet<Person> copyChildrenSet = new HashSet<>(childrenSet);
                copyChildrenSet.remove(item);
                item.addBrotherOrSisterSet(copyChildrenSet);
                this.personsSet.add(item);
            }
        }
    }

    public String getInfo(String firstName, String lastName, Relation relation) {
        StringBuilder output = new StringBuilder();
        Iterator<Person> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                if (relation == Relation.Mother) {
                    if (item.getMother() != null) {
                        return output.append(item.getMother() + "\n").toString();
                    }
                } else if (relation == Relation.Father) {
                    if (item.getFather() != null) {
                        return output.append(item.getFather() + "\n").toString();
                    }
                } else if (relation == Relation.Spouse){
                    if (item.getSpouse() != null) {
                        return output.append(item.getSpouse() + "\n").toString();
                    }
                } else if (relation == Relation.Brother) {
                    if (item.getBrothersOrSistersSet() != null) {
                        Iterator<Person> iteratorBS = item.getBrothersOrSistersSet().iterator();
                        while (iteratorBS.hasNext()) {
                            Person itemBS = iteratorBS.next();
                            if (itemBS.getSex() == Sex.Male) {
                                output.append(itemBS + "\n");
                            }
                        }
                        return output.toString();
                    }
                } else if (relation == Relation.Sister) {
                    if (item.getBrothersOrSistersSet() != null) {
                        Iterator<Person> iteratorBS = item.getBrothersOrSistersSet().iterator();
                        while (iteratorBS.hasNext()) {
                            Person itemBS = iteratorBS.next();
                            if (itemBS.getSex() == Sex.Female) {
                                output.append(itemBS + "\n");
                            }
                        }
                        return output.toString();
                    }
                } else if (relation == Relation.Son) {
                    if (item.getChildrenSet() != null) {
                        Iterator<Person> iteratorCh = item.getChildrenSet().iterator();
                        while (iteratorCh.hasNext()) {
                            Person itemCh = iteratorCh.next();
                            if (itemCh.getSex() == Sex.Male) {
                                output.append(itemCh + "\n");
                            }
                        }
                        return output.toString();
                    }
                } else if (relation == Relation.Daughter) {
                    if (item.getChildrenSet() != null) {
                        Iterator<Person> iteratorCh = item.getChildrenSet().iterator();
                        while (iteratorCh.hasNext()) {
                            Person itemCh = iteratorCh.next();
                            if (itemCh.getSex() == Sex.Female) {
                                output.append(itemCh + "\n");
                            }
                        }
                        return output.toString();
                    }
                }
            }
        }
        return output.append("Запись отсутствует.").toString();
    }

    public String getInfo (String firstName, String lastName){
        StringBuilder output = new StringBuilder();
        Iterator<Person> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return output.append(item + "\n").toString();
            }
        }
        return output.append("Запись отсутствует.").toString();
    }

    public Person getPerson (String firstName, String lastName) {
        Iterator<Person> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return item;
            }
        }
        return null;
    }

    public void saveFamilyTreeAs(String path, FileOutStr format) throws IOException {
        format.saveFamilyTreeAs(this, path);
    }

    public FamilyTree getFamilyTreeFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        return format.getFamilyTreeFrom(path);
    }

    public void savePersonAs(Person person, String path, FileOutStr format) throws IOException {
        format.savePersonAs(person, path);
    }

    public Person getPersonFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        return format.getPersonFrom(path);
    }

    @Override
    public String toString () {
        StringBuilder output = new StringBuilder();
        output.append("All records of Family Tree:" + "\n");
        output.append("##################################" + "\n");
        Iterator<Person> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            Person item = iterator.next();
            output.append(item.getFirstName() + " " + item.getLastName() + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }
}
