package family_tree.model.tree;

import family_tree.model.Comparator.ComparatorByName;
import family_tree.model.Comparator.ComparatorByBirthDate;
import family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public abstract class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T>, FamilyTreeHub<Human> {

    protected int age;
    private String lastName;

//    private String firstName;
    private static List<Human> humanList;
    private double income;
    private String position;
    private LocalDate birthDate;
    public String info;

    //    ArrayList<Human> humans = new ArrayList<>();
//    public FamilyTree() { };

//    public void addHuman(Human human){
//        human.setId(Id++);
//        humanList.add(human);
//    }

//    public String getRelativeInfo(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список :\n");
//        for (Human human: humanList){
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

//    public void sortByLastName(){
//        FamilyTree familyTree = null;
//        familyTree.sortByLastName();
//    }

    @Override
    public String getLastName() {
        return lastName;
    }

//    @Override
//    public String getFirstName() {
//        return null;
//    }

//    @Override
//    public String getFirstName() {
//        return firstName;
//    }

    @Override
    public boolean setId() {
        return true;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public String getPosition() { return position; }

//    @Override
//    public void getAge() {  }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator((List) humanList);
    }

//    public static void main(String[] args){
//        System.out.println("вывод из FamilyTree ============ >>>>.");
//        methodSortByLastName();
//        methodSortByAge();
//        sortByIncome();
//    }

//    public void methodSortByLastName() {
//        ArrayList<Human> humans = new ArrayList<>();
//        System.out.println("\n============= Сортировка списка по Фамилии (по алфавиту) :");
//        //  Сортировка списка по Фамилии
//        humans.sort(Comparator.comparing(Human::getLastName));
//        for (Human human : humans) {
//            System.out.println(human);
//        }
//    }

//    public void methodSortByAge() {
//        ArrayList<Human> humans = new ArrayList<>();
//        System.out.println("\n============= Сортировка списка по Возрасту (по убыванию) :");
//        //  Сортировка списка по Возрасту
//        humans.sort(Comparator.comparing(Human::getAge).reversed());
////        humans.sort(Comparator.comparingInt(TreeNode::getAge).reversed());
//        for (Human human : humans) {
//            System.out.println(human);
////            humanList.add(human);
//        }
////        return humanList;
//
//    }

//    public void sortByIncome() {
//        ArrayList<Human> humans = new ArrayList<>();
//        System.out.println("\n============= Сортировка списка по Доходу (по убыванию) :");
////          Сортировка списка по Доходам
//        humans.sort(Comparator.comparing(Human::getIncome).reversed());
//        for (Human human : humans) {
//            System.out.println(human);
//        }
//    }


//    public void sortByAge(ArrayList<Human> humans) {
//        System.out.println("\n============= Сортировка списка по Возрасту (по убыванию) :");
//        //  Сортировка списка по Возрасту
//        humans.sort(Comparator.comparing(Human::getAge).reversed());
////        humans.sort(Comparator.comparingInt(TreeNode::getAge).reversed());
//        for (Human human : humans) {
//            System.out.println(human);
////            humanList.add(human);
//        }
//    }

    public void sortByName(){
        humanList.sort(new ComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new ComparatorByBirthDate());
    }



}