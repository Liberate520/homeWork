package family_tree.service;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Gender;
import family_tree.person.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Service<T extends FamilyTreeItem<T>> {
    FamilyTree<T> tree;

    public Service(FamilyTree<T> tree) {
        this.tree = tree;
    }

    public Service() {

    }

    public String getTree() {
        if (tree.getAllItems().isEmpty()) {
            return "Дерево пусто";
        } else return tree.toString();
    }

    public String getTreeShort() {
        if (tree.getAllItems().isEmpty()) {
            return "Дерево пусто";
        } return tree.printShort();
    }

    public String getItemByName(String fullName) {
        T unit = tree.getPersonByName(fullName);
        return unit.toString().substring(0, unit.toString().length()-1);
    }

    public String getItemByNameShort(String fullName) {
        T unit = tree.getPersonByName(fullName);
        return unit.printShort();
    }

//    public String getUnitAfterChange(String action, String data, FamilyTree<T> tree) {
//        int index = Integer.parseInt(data) - 1;
//        T unit = tree.getPersonByIndex(index);
//        String newParameter = scan();
//        switch (action) {
//            case "41" -> unit.setFullname(newParameter);
//            case "42" -> unit.setBirthDate(Integer.parseInt(newParameter.split(" ".trim())[0]),
//                    Integer.parseInt(newParameter.split(" ".trim())[1]),
//                    Integer.parseInt(newParameter.split(" ".trim())[2]));
//            case "43" -> unit.setEndLifeDate(Integer.parseInt(newParameter.split(" ".trim())[0]),
//                    Integer.parseInt(newParameter.split(" ".trim())[1]),
//                    Integer.parseInt(newParameter.split(" ".trim())[2]));
//            case "44" -> unit.setGender(newParameter.equals("1") ? Gender.Female : Gender.Male);
//            case "45" -> {
//                if (tree.getPersonByName(newParameter) == null) {
//                    System.out.printf("по ФИО %s не найден в дереве -> мама не добавлена\n", newParameter);
//                } else { unit.setMother(tree.getPersonByName(newParameter)); }
//            }
//            case "46" -> {
//                if (tree.getPersonByName(newParameter) == null) {
//                    System.out.printf("по ФИО %s не найден в дереве -> папа не добавлен\n", newParameter);
//                } else { unit.setFather(tree.getPersonByName(newParameter)); }
//            }
//            case "47" -> {
//                if (tree.getPersonByName(newParameter) == null) {
//                    System.out.printf("по ФИО %s не найден в дереве -> ребенок не добавлен\n", newParameter);
//                } else { unit.setChildren(tree.getPersonByName(newParameter)); }
//            }
//            case "48" -> unit.setCommit(newParameter);
//        }
//        return unit.toString();
//    }


    public Boolean addToTree(String data, Gender gender) {
//        tree.addPerson((T) new Person (fullName, birthY, birthM, birthD, gender));
        return tree.addPersonStrData(data, gender);
    }

    public Boolean delFromTree(String data) {
        return tree.delByName(data);
    }

    private String scan() {
        return new Scanner(System.in).nextLine();
    }

    public Boolean setPeakByIndex(int index) {
        T unit = tree.getPersonByIndex(index);
        tree.setPeak(unit.getName());
        if (unit.getGender() == Gender.Female) {
            return tree.getPeakMother() == unit;
        } else {
            return tree.getPeakFather() == unit;
        }
    }

    public String getPeakTree() {
        T mother = tree.getPeakMother();
        T father = tree.getPeakFather();
        StringBuilder sb = new StringBuilder();
        sb.append("Текущие \"главы:\"\n");
        sb.append(mother != null ? mother.printShort(): "Пусто\n");
        sb.append(father != null ? father.printShort(): "Пусто");
        return sb.toString();
    }

    public Boolean saveTree(String option) {
        if (option.equals("1")) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
            String fileName = format.format(date);
            IOObject obj = new IOObject();
            return obj.save(tree, "src/family_tree/in_out_files/"+fileName+".bin");
        } else {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
            String fileName = format.format(date);
            IOByteArr byteArr = new IOByteArr();
            return byteArr.save(tree, "src/family_tree/in_out_files/"+fileName+".txt");
        }
    }

    public Boolean delTree() {
        tree = new FamilyTree<>();
        return tree.isEmpty();
    }

    public Boolean loadTree(String option, String filename) {
        if (option.equals("1")) {
            IOObject obj = new IOObject();
            tree = (FamilyTree<T>) obj.read("src/family_tree/in_out_files/"+filename+".bin");
            return tree == (FamilyTree<T>) obj.read("src/family_tree/in_out_files/"+filename+".bin");
        } else {
            IOByteArr byteArr = new IOByteArr();
            tree = (FamilyTree<T>) byteArr.read("src/family_tree/in_out_files/"+filename+".txt");
            return tree == (FamilyTree<T>) byteArr.read("src/family_tree/in_out_files/"+filename+".txt");
        }
    }

    public FamilyTree<T> getNewTree() {
        return new FamilyTree<>();
    }

    public int getTreeSize() {
        return tree.getSize();
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
        item.setBirthDate(endlifeY, endlifeM, endlifeD);
        return compareDates(endlifeY, endlifeM, endlifeD, item.getBirthDate());
    }

    public Boolean compareDates(int year, int month, int day, String dateFromTree) {
        GregorianCalendar dateCompare = new GregorianCalendar(year, month - 1, day);
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        return df.format(dateCompare.getTime()).equals(dateFromTree);
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
        item.setMother(tree.getPersonByName(motherName));
        return motherName.equals(item.getMother().getName());
    }

    public Boolean setFather(String itemIndex, String fatherName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setMother(tree.getPersonByName(fatherName));
        return fatherName.equals(item.getFather().getName());
    }

    public Boolean setChild(String itemIndex, String childName) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        item.setMother(tree.getPersonByName(childName));
        return item.getChildren().contains(tree.getPersonByName(childName));
    }

    public Boolean setCommit(String itemIndex, String commit) {
        int index = Integer.parseInt(itemIndex);
        T item = tree.getPersonByIndex(index);
        return commit.equals(item.getCommit());
    }

    public void exit() {
        System.exit(0);
    }
}
