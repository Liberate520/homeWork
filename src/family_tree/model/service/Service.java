package family_tree.model.service;

import family_tree.model.familytree.FamilyTree;
import family_tree.model.familytree.FamilyTreeItem;
import family_tree.model.person.Gender;
import family_tree.model.person.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Service<T extends FamilyTreeItem<T>> {
    private FamilyTree<T> tree;

    public Service(FamilyTree<T> tree) {
        this.tree = tree;
    }

    public Service() {

    }

    public Boolean isTreeEmpty() {
        return tree.isEmpty();
    }

    public String getTree() {
        return tree.toString();
    }

    public int getTreeSize() {
        return tree.getSize();
    }

    public Boolean isContainsItem(String fullName) {
        return tree.getPersonByName(fullName) != null;
    }

    public Boolean compareDates(int year, int month, int day, String dateFromTree) {
        GregorianCalendar dateCompare = new GregorianCalendar(year, month - 1, day);
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        return df.format(dateCompare.getTime()).equals(dateFromTree);
    }

    public String getTreeShort() {
        return tree.printShort();
    }

    public String getItemByName(String fullName) {
        T unit = tree.getPersonByName(fullName);
        return unit.toString().substring(0,unit.toString().length()-1);
    }

    public String getItemByNameShort(String fullName) {
        T unit = tree.getPersonByName(fullName);
        return unit.printShort();
    }

    public String sortByName() {
        tree.sortByName();
        return tree.toString();
    }

    public String sortByNameReverse() {
        tree.sortByNameReverse();
        return tree.toString();
    }

    public String sortByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    public String sortByAgeReverse() {
        tree.sortByAgeReverse();
        return tree.toString();
    }

    public String sortByDateBirth() {
        tree.sortByBirth();
        return tree.toString();
    }

    public String sortByDateBirthReverse() {
        tree.sortByBirthReverse();
        return tree.toString();
    }

    public String sortByChildren() {
        tree.sortByChildren();
        return tree.toString();
    }

    public String sortByChildrenReverse() {
        tree.sortByChildrenReverse();
        return tree.toString();
    }

    public Boolean addPersonToTree(String data) {
        String fullName = data.split(",")[0];
        int birthY = Integer.parseInt(data.split(",")[1]);
        int birthM = Integer.parseInt(data.split(",")[2]);
        int birthD = Integer.parseInt(data.split(",")[3]);
        Gender gender = data.split(",")[4].equalsIgnoreCase("женский") ? Gender.Female : Gender.Male;
        Person personToAdd = new Person(fullName, birthY, birthM, birthD, gender);
        return tree.addPerson((T) personToAdd);
    }

    public Boolean delFromTree(String fullName) {
        return tree.delByName(fullName);
    }

    public Boolean setFullname(String itemIndex, String fullName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setFullname(fullName);
        return fullName.equals(tree.getPersonByIndex(index).getName());
    }

    public Boolean setDateBirth(String itemIndex, int birthY, int birthM,  int birthD) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setBirthDate(birthY, birthM, birthD);
        return compareDates(birthY, birthM, birthD, item.getBirthDate());
    }

    public Boolean setDateEndlife(String itemIndex, int endlifeY, int endlifeM, int endlifeD) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setEndLifeDate(endlifeY, endlifeM, endlifeD);
        return compareDates(endlifeY, endlifeM, endlifeD, item.getEndLifeDate());
    }

    public Boolean setGenderChange(String itemIndex, Gender gender) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setGender(gender);
        return gender == item.getGender();
    }

    public Boolean setMother(String itemIndex, String motherName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        T mother = tree.getPersonByName(motherName);
        if (mother == null) {
            return false;
        } else {
            item.setMother(mother);
            return motherName.equals(item.getMother().getName());
        }
    }

    public Boolean setFather(String itemIndex, String fatherName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        T father = tree.getPersonByName(fatherName);
        if (father == null) {
            return false;
        } else {
            item.setFather(father);
            return fatherName.equals(item.getFather().getName());
        }
    }

    public Boolean setChild(String itemIndex, String childName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        T child = tree.getPersonByName(childName);
        if (child == null) {
            return false;
        } else {
            item.setChildren(child);
            return item.getChildren().contains(tree.getPersonByName(childName));
        }
    }

    public Boolean setCommit(String itemIndex, String commit) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        return commit.equals(item.getCommit());
    }

    public String getPeakTree() {
        T mother = tree.getPeakMother();
        T father = tree.getPeakFather();
        StringBuilder sb = new StringBuilder();
        sb.append("Текущие \"главы:\"\n");
        sb.append(mother != null ? mother.printShort(): "Пусто\n");
        sb.append(father != null ? father.printShort(): "Пусто");
        return sb.toString().substring(0,sb.length()-1);
    }

    public Boolean setPeakByIndex(int index) {
        T unit = tree.getPersonByIndex(index);
        tree.setPeak(unit.getName());
        // проверка
        if (unit.getGender() == Gender.Female) {
            return tree.getPeakMother() == unit;
        } else {
            return tree.getPeakFather() == unit;
        }
    }

    public Boolean saveTree(String option) {
        if (option.equals("1")) {
//            Date date = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
//            String fileName = format.format(date);
            IOObject obj = new IOObject();
            return obj.save(tree);
        } else {
//            Date date = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
//            String fileName = format.format(date);
            IOByteArr byteArr = new IOByteArr();
            return byteArr.save(tree);
        }
    }

    public Boolean loadTree(String option, String filename) {
        if (option.equals("1")) {
            IOObject obj = new IOObject();
            FamilyTree <T> loadedTree = (FamilyTree<T>) obj.read(filename);
            FamilyTree <T> oldTree = tree;
            tree = loadedTree;
            return oldTree != loadedTree;
        } else {
            IOByteArr byteArr = new IOByteArr();
            FamilyTree <T> loadedTree = (FamilyTree<T>) byteArr.read(filename);
            FamilyTree <T> oldTree = tree;
            tree = loadedTree;
            return oldTree != loadedTree;
        }
    }

    public Boolean delTree() {
        tree = new FamilyTree<>();
        return tree.isEmpty();
    }

    public void exit() {
        System.exit(0);
    }

}
