package family_tree.model.family_tree;

import family_tree.model.base.TreeNode;
import family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>, FamilyTreeHub<Human> {
    private String lastName;
    private String firstName;
    private double Id;
    private final List<Human> humanList;
    private double income;
    private double id;
    private String position;
    private LocalDate birthDate;

    public FamilyTree(double id) {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(Id++);
        humanList.add(human);
    }

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

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setId(double id) {
        this.id = id;
    }

    @Override
    public double setId() {
        return 0;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public String getPosition() { return position; }

    @Override
    public int getAge() { return 0; }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public Iterator<E> iterator() { return (Iterator<E>) new TreeIterator<>(humanList); }


    public static <E> void methodSortByLastName(ArrayList<Human> humans) {
        System.out.println("\n============= Сортировка списка по Фамилии (по алфавиту) :");
        //  Сортировка списка по Фамилии
        humans.sort(Comparator.comparing(Human::getLastName));
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static void methodSortByAge(ArrayList<Human> humans) {
        System.out.println("\n============= Сортировка списка по Возрасту (по убыванию) :");
        //  Сортировка списка по Возрасту
        humans.sort(Comparator.comparing(Human::getAge).reversed());
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static void methodSortByIncome(ArrayList<Human> humans) {
        System.out.println("\n============= Сортировка списка по Доходу (по убыванию) :");
//          Сортировка списка по Доходам
        humans.sort(Comparator.comparing(Human::getIncome).reversed());
        for (Human human : humans) {
            System.out.println(human);
        }
    }


}