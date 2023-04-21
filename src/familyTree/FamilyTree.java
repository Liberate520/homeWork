package familyTree;

import person.Person;
import person.Relation;
import person.Sex;
import saving.FileOutStr;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Person> {
    private HashSet<Person> personsSet;

    public FamilyTree() {
        this.personsSet = new HashSet<>();
    }

    public void pushSpouseToSet(Person person, Person spouse) {
        if (spouse != null) {
            person.setSpouse(spouse);
            spouse.setSpouse(person);
            if (person.getChildrenSet() != null) {
                spouse.addChildren(person.getChildrenSet());
            }
            this.personsSet.add(spouse);
        }
    }

    public void pushFatherToSet(Person person, Person father) {
        person.setFather(father);
        Person mother = person.getMother();
        if (father != null) {
            father.addChildren(person);
            if (mother != null) {
                father.setSpouse(mother);
                mother.setSpouse(father);
            }
            this.personsSet.add(father);
        }
    }

    public void pushMotherToSet(Person person, Person mother) {
        person.setMother(mother);
        Person father = person.getFather();
        if (mother != null) {
            mother.addChildren(person);
            if (father != null) {
                mother.setSpouse(father);
                father.setSpouse(mother);
            }
            this.personsSet.add(mother);
        }
    }

    public void pushBrotherToSet(Person person, Person brother) {
        if (brother != null) {
            person.addBrother(brother);
            pushBrothersOrSistersToSet(person);
        }
    }

    public void pushSisterToSet(Person person, Person sister) {
        if (sister != null) {
            person.addSister(sister);
            pushBrothersOrSistersToSet(person);
        }
    }

    private void pushBrothersOrSistersToSet(Person person) {
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
        Person mother = person.getMother();
        Person father = person.getFather();
        if (father != null) {
            father.addChildren(brothersOrSistersSet);
        }
        if (mother != null) {
            mother.addChildren(brothersOrSistersSet);
        }
    }

    private void pushChildrenToSet(Person person) {
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

    private String getMotherInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getMother() != null) {
            return output.append(item.getMother() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getFatherInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getFather() != null) {
            return output.append(item.getFather() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSpouseInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getSpouse() != null) {
            return output.append(item.getSpouse() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getBrotherInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getBrothersOrSistersSet() != null) {
            Iterator<Person> iteratorBS = item.getBrothersOrSistersSet().iterator();
            while (iteratorBS.hasNext()) {
                Person itemBS = iteratorBS.next();
                if (itemBS.getSex() == Sex.Male) {
                    output.append(itemBS + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSisterInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getBrothersOrSistersSet() != null) {
            Iterator<Person> iteratorBS = item.getBrothersOrSistersSet().iterator();
            while (iteratorBS.hasNext()) {
                Person itemBS = iteratorBS.next();
                if (itemBS.getSex() == Sex.Female) {
                    output.append(itemBS + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSonInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getChildrenSet() != null) {
            Iterator<Person> iteratorCh = item.getChildrenSet().iterator();
            while (iteratorCh.hasNext()) {
                Person itemCh = iteratorCh.next();
                if (itemCh.getSex() == Sex.Male) {
                    output.append(itemCh + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getDaughterInfo(Person item) {
        StringBuilder output = new StringBuilder();
        if (item.getChildrenSet() != null) {
            Iterator<Person> iteratorCh = item.getChildrenSet().iterator();
            while (iteratorCh.hasNext()) {
                Person itemCh = iteratorCh.next();
                if (itemCh.getSex() == Sex.Female) {
                    output.append(itemCh + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    public void pushToTree(Person person) {
        this.personsSet.add(person);
        pushSpouseToSet(person, person.getSpouse());
        pushMotherToSet(person, person.getMother());
        pushFatherToSet(person, person.getFather());
        pushBrothersOrSistersToSet(person);
        pushChildrenToSet(person);
    }

    public String getInfo(String firstName, String lastName, Relation relation) {
        Person item = getPerson(firstName, lastName);
        if (item == null) {
            return "Запись отсутствует." + "\n";
        } else {
            switch (relation) {
                case Mother: return getMotherInfo(item);
                case Father: return getFatherInfo(item);
                case Spouse: return getSpouseInfo(item);
                case Brother: return getBrotherInfo(item);
                case Sister: return getSisterInfo(item);
                case Son: return getSonInfo(item);
                case Daughter: return getDaughterInfo(item);
            }
        }
        return "Запись отсутствует." + "\n";
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

    public FamilyTree loadFamilyTreeFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        return format.getFamilyTreeFrom(path);
    }

    public void savePersonAs(Person person, String path, FileOutStr format) throws IOException {
        format.savePersonAs(person, path);
    }

    public Person loadPersonFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
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
//            output.append(item.getFirstName() + " " + item.getLastName() + "\n");
            output.append(item + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return personsSet.iterator();
    }
}
