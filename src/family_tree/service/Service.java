package family_tree.service;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Gender;
import family_tree.person.Person;

import java.util.Scanner;
import java.lang.NullPointerException;

public class Service<T extends FamilyTreeItem<T>> {

    public String getFamilyTree(FamilyTree<T> tree) {
        if (tree.getAllUnits().isEmpty()) {
            return "Дерево пусто";
        } else return tree.toString();
    }

    public String getFamilyTreeShort(FamilyTree<T> tree) {
        if (tree.getAllUnits().isEmpty()) {
            return "Дерево пусто";
        } return tree.printShort();
    }

    public String getUnitByName(FamilyTree<T> tree) {
        System.out.print("Введите имя -> ");
        T unit = tree.getPersonByName(new Scanner(System.in).nextLine().trim());
        String finded = unit == null ? "Никто не найден! " : unit.toString();
        return finded.substring(0, finded.length()-1);
    }

    public String getUnitByIndex(String data, FamilyTree<T> tree) {
        T unit = tree.getPersonByIndex(Integer.parseInt(data) - 1);
        String finded = unit == null ? "Никто не найден! " : unit.toString();
        return finded.substring(0, finded.length()-1);
    }

    public String getUnitAfterChange(String action, String data, FamilyTree<T> tree) {
        int index = Integer.parseInt(data) - 1;
        T unit = tree.getPersonByIndex(index);
        String newParameter = scan();
        switch (action) {
            case "41" -> unit.setFullname(newParameter);
            case "42" -> unit.setBirthDate(Integer.parseInt(newParameter.split(" ".trim())[0]),
                    Integer.parseInt(newParameter.split(" ".trim())[1]),
                    Integer.parseInt(newParameter.split(" ".trim())[2]));
            case "43" -> unit.setEndLifeDate(Integer.parseInt(newParameter.split(" ".trim())[0]),
                    Integer.parseInt(newParameter.split(" ".trim())[1]),
                    Integer.parseInt(newParameter.split(" ".trim())[2]));
            case "44" -> unit.setGender(newParameter.equals("1") ? Gender.Female : Gender.Male);
            case "45" -> {
                if (tree.getPersonByName(newParameter) == null) {
                    System.out.printf("по ФИО %s не найден в дереве -> мама не добавлена\n", newParameter);
                } else { unit.setMother(tree.getPersonByName(newParameter)); }
            }
            case "46" -> {
                if (tree.getPersonByName(newParameter) == null) {
                    System.out.printf("по ФИО %s не найден в дереве -> папа не добавлен\n", newParameter);
                } else { unit.setFather(tree.getPersonByName(newParameter)); }
            }
            case "47" -> {
                if (tree.getPersonByName(newParameter) == null) {
                    System.out.printf("по ФИО %s не найден в дереве -> ребенок не добавлен\n", newParameter);
                } else { unit.setChildren(tree.getPersonByName(newParameter)); }
            }
            case "48" -> unit.setCommit(newParameter);
        }
        return unit.toString();
    }

    public String getFamilyTreeSort(FamilyTree<T> tree, String option) {
        switch (option) {
            case "name" -> tree.sortByName();
            case "nameReverse" -> tree.sortByNameReverse();
            case "age" -> tree.sortByAge();
            case "ageReverse" -> tree.sortByAgeReverse();
            case "birthDate" -> tree.sortByBirth();
            case "birthDateReverse" -> tree.sortByBirthReverse();
            case "children" -> tree.sortByChildren();
            case "childrenReverse" -> tree.sortByChildrenReverse();
        }
        return tree.toString();
    }

    public String getAddToTree(String data, FamilyTree<T> tree) {
        String fullName = data.split(",")[0];
        int birthY = Integer.parseInt(data.split(",")[1].split(" ")[0]);
        int birthM = Integer.parseInt(data.split(",")[1].split(" ")[1]);
        int birthD = Integer.parseInt(data.split(",")[1].split(" ")[2]);
        Gender gender = data.split(",")[2].equals("1") ? Gender.Female : Gender.Male;
        tree.addPerson((T) new Person (fullName, birthY, birthM, birthD, gender));
        return tree.getPersonByName(fullName).toString();
    }

    public String delFromTree(String data, FamilyTree<T> tree) {
        return tree.delByName(data) ? "Найден и удален" : "Никто не найден";
    }

    private String scan() {
        return new Scanner(System.in).nextLine();
    }

    public String getPeakByIndex(String data, FamilyTree<T> tree) {
        int index = Integer.parseInt(data) - 1;
        T unit = tree.getPersonByIndex(index);
        tree.setPeak(unit.getName());
        return "Новый \"глава\"\n"+unit.toString();
    }

    public String getPeak(FamilyTree<T> tree) {
        T mother = tree.getPeakMother();
        T father = tree.getPeakFather();
        StringBuilder sb = new StringBuilder();
        sb.append("Текущие \"главы\"\n");
        sb.append(mother != null ? mother.printShort(): "Пусто\n");
        sb.append(father != null ? father.printShort(): "Пусто");
        return sb.toString();
    }

    public String SaveTree(String action, String data, FamilyTree<T> tree) {
        if (action.equals("61")) {
            IOObject obj = new IOObject();
            obj.save(tree, "src/family_tree/in_out_files/"+data+".bin");
            return "Сохранено с помощью класса ObjectOutputStream";
        } else {
            IOByteArr byteArr = new IOByteArr();
            byteArr.save(tree, "src/family_tree/in_out_files/"+data+".txt");
            return "Сохранено с помощью класса ByteArrayOutputStream";
        }
    }

    public String deleteTree(FamilyTree<T> tree) {
//        tree.getAllUnits().clear();
        tree = new FamilyTree<>();
        return "Дерево очищено!";
    }

    public FamilyTree<T> getLoadTree(String action, String data) {
        if (action.equals("71")) {
            IOObject obj = new IOObject();
            return (FamilyTree<T>) obj.read("src/family_tree/in_out_files/"+data+".bin");
        } else {
            IOByteArr byteArr = new IOByteArr();
            return (FamilyTree<T>) byteArr.read("src/family_tree/in_out_files/"+data+".txt");
        }
    }

    public FamilyTree<T> getNewTree() {
        return new FamilyTree<>();
    }
}
