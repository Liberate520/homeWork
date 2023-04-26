package familyTree;

import interfaces.Anthropoid;
import person.Relation;
import person.Sex;
import person.comparators.PersonComparatorByAge;
import person.comparators.PersonComparatorByFirstName;
import person.comparators.PersonComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Anthropoid> implements Serializable, Iterable<E> {
    private HashSet<E> personsSet;

    public FamilyTree() {
        this.personsSet = new HashSet<>();
    }

    public void pushSpouseToSet(E person, E spouse) {
        if (spouse != null) {
            person.setSpouse(spouse);
            spouse.setSpouse(person);
            if (person.getChildrenSet() != null) {
                spouse.addChildren(person.getChildrenSet());
            }
            this.personsSet.add(spouse);
        }
    }

    public void pushFatherToSet(E person, E father) {
        person.setFather(father);
        Anthropoid mother = person.getMother();
        if (father != null) {
            father.addChildren(person);
            if (mother != null) {
                father.setSpouse(mother);
                mother.setSpouse(father);
            }
            this.personsSet.add(father);
        }
    }

    public void pushMotherToSet(E person, E mother) {
        person.setMother(mother);
        Anthropoid father = person.getFather();
        if (mother != null) {
            mother.addChildren(person);
            if (father != null) {
                mother.setSpouse(father);
                father.setSpouse(mother);
            }
            this.personsSet.add(mother);
        }
    }

    public void pushBrotherToSet(E person, E brother) {
        if (brother != null) {
            person.addBrother(brother);
            pushBrothersOrSistersToSet(person);
        }
    }

    public void pushSisterToSet(E person, E sister) {
        if (sister != null) {
            person.addSister(sister);
            pushBrothersOrSistersToSet(person);
        }
    }

    private void pushBrothersOrSistersToSet(E person) {
        HashSet<Anthropoid> brothersOrSistersSet = new HashSet<>(person.getBrothersOrSistersSet());
        if (brothersOrSistersSet != null && brothersOrSistersSet.size() == 1) {
            Iterator<Anthropoid> iterator = brothersOrSistersSet.iterator();
            while (iterator.hasNext()) {
                Anthropoid item = iterator.next();
                item.setMother(person.getMother());
                item.setFather(person.getFather());
                item.addBrotherOrSisterSet(person);
                this.personsSet.add((E)item);
            }
        } else if (brothersOrSistersSet != null && brothersOrSistersSet.size() > 1) {
            Iterator<Anthropoid> iterator = brothersOrSistersSet.iterator();
            while (iterator.hasNext()) {
                Anthropoid item = iterator.next();
                item.setMother(person.getMother());
                item.setFather(person.getFather());
                item.addBrotherOrSisterSet(person);
                HashSet<Anthropoid> copyBrothersOrSistersSet = new HashSet<>(brothersOrSistersSet);
                copyBrothersOrSistersSet.remove(item);
                item.addBrotherOrSisterSet(copyBrothersOrSistersSet);
                this.personsSet.add((E)item);
            }
        }
        Anthropoid mother = person.getMother();
        Anthropoid father = person.getFather();
        if (father != null) {
            father.addChildren(brothersOrSistersSet);
        }
        if (mother != null) {
            mother.addChildren(brothersOrSistersSet);
        }
    }

    public void pushSonToSet(E person, E son) {
        if (son != null) {
            person.addChildren(son);
            Anthropoid spouse = person.getSpouse();
            if (spouse != null) {
                spouse.addChildren(son);
            }
            pushChildrenToSet(person);
        }
    }

    public void pushDaughterToSet(E person, E daughter) {
        if (daughter != null) {
            person.addChildren(daughter);
            Anthropoid spouse = person.getSpouse();
            if (spouse != null) {
                spouse.addChildren(daughter);
            }
            pushChildrenToSet(person);
        }
    }

    private void pushChildrenToSet(E person) {
        HashSet<Anthropoid> childrenSet = person.getChildrenSet();
        if (childrenSet != null && childrenSet.size() == 1) {
            Iterator<Anthropoid> iterator = childrenSet.iterator();
            while (iterator.hasNext()) {
                Anthropoid item = iterator.next();
                item.setMother(person.getSpouse());
                item.setFather(person);
                this.personsSet.add((E)item);
            }
        } else if (childrenSet != null && childrenSet.size() > 1) {
            Iterator<Anthropoid> iterator = childrenSet.iterator();
            while (iterator.hasNext()) {
                Anthropoid item = iterator.next();
                item.setMother(person.getSpouse());
                item.setFather(person);
                HashSet<Anthropoid> copyChildrenSet = new HashSet<>(childrenSet);
                copyChildrenSet.remove(item);
                item.addBrotherOrSisterSet(copyChildrenSet);
                this.personsSet.add((E)item);
            }
        }
    }

    private String getMotherInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getMother() != null) {
            return output.append(item.getMother() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getFatherInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getFather() != null) {
            return output.append(item.getFather() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSpouseInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getSpouse() != null) {
            return output.append(item.getSpouse() + "\n").toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getBrotherInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getBrothersOrSistersSet() != null) {
            Iterator<Anthropoid> iteratorBS = item.getBrothersOrSistersSet().iterator();
            while (iteratorBS.hasNext()) {
                Anthropoid itemBS = iteratorBS.next();
                if (itemBS.getSex() == Sex.Male) {
                    output.append(itemBS + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSisterInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getBrothersOrSistersSet() != null) {
            Iterator<Anthropoid> iteratorBS = item.getBrothersOrSistersSet().iterator();
            while (iteratorBS.hasNext()) {
                Anthropoid itemBS = iteratorBS.next();
                if (itemBS.getSex() == Sex.Female) {
                    output.append(itemBS + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getSonInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getChildrenSet() != null) {
            Iterator<Anthropoid> iteratorCh = item.getChildrenSet().iterator();
            while (iteratorCh.hasNext()) {
                Anthropoid itemCh = iteratorCh.next();
                if (itemCh.getSex() == Sex.Male) {
                    output.append(itemCh + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    private String getDaughterInfo(E item) {
        StringBuilder output = new StringBuilder();
        if (item.getChildrenSet() != null) {
            Iterator<Anthropoid> iteratorCh = item.getChildrenSet().iterator();
            while (iteratorCh.hasNext()) {
                Anthropoid itemCh = iteratorCh.next();
                if (itemCh.getSex() == Sex.Female) {
                    output.append(itemCh + "\n");
                }
            }
            return output.toString();
        } else {
            return output.append("Запись отсутствует." + "\n").toString();
        }
    }

    public void pushToTree(E person) {
        this.personsSet.add(person);
        pushSpouseToSet(person, (E)person.getSpouse());
        pushMotherToSet(person, (E)person.getMother());
        pushFatherToSet(person, (E)person.getFather());
        pushBrothersOrSistersToSet(person);
        pushChildrenToSet(person);
    }

    public String getInfo(String firstName, String lastName, Relation relation) {
        E item = getPerson(firstName, lastName);
        if (item == null) {
            return "Запись отсутствует." + "\n";
        } else {
            switch (relation) {
                case Mother: return getMotherInfo((E)item);
                case Father: return getFatherInfo((E)item);
                case Spouse: return getSpouseInfo((E)item);
                case Brother: return getBrotherInfo((E)item);
                case Sister: return getSisterInfo((E)item);
                case Son: return getSonInfo((E)item);
                case Daughter: return getDaughterInfo((E)item);
            }
        }
        return "Запись отсутствует." + "\n";
    }

    public String getInfo(String firstName, String lastName){
        StringBuilder output = new StringBuilder();
        Iterator<E> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            E item = iterator.next();
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return output.append(item + "\n").toString();
            }
        }
        return output.append("Запись отсутствует.").toString();
    }

    public E getPerson(String firstName, String lastName) {
        Iterator<E> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            E item = iterator.next();
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return item;
            }
        }
        return null;
    }

    public List<E> getListSortByFirstName(){
        List<E> personList = new ArrayList<>(personsSet);
        personList.sort(new PersonComparatorByFirstName<E>());
        return personList;
    }

    public List<E> getListSortByLastName(){
        List<E> personList = new ArrayList<>(personsSet);
        personList.sort(new PersonComparatorByLastName<E>());
        return personList;
    }

    public List<E> getListSortByAge(){
        List<E> personList = new ArrayList<>(personsSet);
        personList.sort(new PersonComparatorByAge<E>());
        return personList;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("All records of Family Tree:" + "\n");
        output.append("##################################" + "\n");
        Iterator<E> iterator = personsSet.iterator();
        while (iterator.hasNext()) {
            E item = iterator.next();
            output.append(item + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return personsSet.iterator();
    }
}
