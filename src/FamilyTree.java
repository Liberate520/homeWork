import java.util.*;

public class FamilyTree {
    private HashSet<Person> personsSet;

    public FamilyTree() {
        this.personsSet = new HashSet<>();
    }

    public void pushToTree(Person person) {

        this.personsSet.add(person);

        Person wife = person.getWife();
        Person husband = person.getHusband();
        Person father = person.getFather();
        Person mother = person.getMother();

        if (wife != null) {
            wife.setHusband(person);
            if (person.getChildrenSet() != null) {
                wife.addChildren(person.getChildrenSet());
            }
            this.personsSet.add(wife);
        }

        if (husband != null) {
            husband.setWife(person);
            if (person.getChildrenSet() != null) {
                husband.addChildren(person.getChildrenSet());
            }
            this.personsSet.add(husband);
        }

        if (father != null) {
            father.addChildren(person);
            if (mother != null) {
                father.setWife(mother);
            }
            this.personsSet.add(father);
        }

        if (mother != null) {
            mother.addChildren(person);
            if (father != null) {
                mother.setHusband(father);
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
                item.setMother(person.getWife());
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
                } else if (relation == Relation.Wife) {
                    if (item.getFather() != null) {
                        return output.append(item.getWife() + "\n").toString();
                    }
                } else if (relation == Relation.Husband) {
                    if (item.getHusband() != null) {
                        return output.append(item.getHusband() + "\n").toString();
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
