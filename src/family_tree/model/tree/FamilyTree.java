package family_tree.model.tree;

import family_tree.model.comparator.ComparatorByName;
import family_tree.model.comparator.ComparatorByBirthDate;
import family_tree.model.human.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static family_tree.model.base.SortFileByIncome.humans;

public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T>, FamilyTreeHub {

    private String lastName;
    private String firstName;
    private static List<Human> humanList;
    private double income;
    private Position position;    
    public String info;    
    private Fondation fondation;
    private SocialPosition socialPosition;    
    private LocalDate birthDate;
    private LocalDate deathDate;


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

    @Override
    public boolean setId() {
        return true;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public Position getPosition() { return position; }

    @Override
    public void getAge() {

    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

//    @Override
//    public void getAge() {  }

//    @Override
//    public LocalDate getBirthDate() { return birthday; }


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


    public static Human handlerForTree() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Human human = null;
//        try (FileInputStream fileInputStream = new FileInputStream(filePath);
//             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//            // Десериализуем объекты
//            while (true) {
//                try {
//                    human = (Human) objectInputStream.readObject();
//                    System.out.println(human);
//                }
//                catch (EOFException e) {
//                    return null;
//                }
//            }
//        }
//        catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ошибка чтения файла : " + e.getMessage());
        }
        return human;
    }

    public static Human handlerForIncome() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Human human = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
            while (true) {
                try {
                    human = (Human) objectInputStream.readObject();
                    //Сортировка списка по Доходам
                    humans.sort(Comparator.comparing(Human::getIncome).reversed());
                    System.out.println(human);
                }
                catch (EOFException e) {
                    return null;
                }
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static Human handlerForAge() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Human human = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
            while (true) {
                try {
                    human = (Human) objectInputStream.readObject();
                    //Сортировка списка по Возрасту
                    humans.sort(Comparator.comparing(Human::getAge).reversed());
                    System.out.println(human);
                }
                catch (EOFException e) {
                    return null;
                }
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }



    public void sortByName(){
        humans.sort(new ComparatorByName());
    }

    public void sortByAge(){
        humans.sort(new ComparatorByBirthDate());
    }

//    public static void addNewHumans(Human newHuman){
//        humanList.add(newHuman);
//    }



    @Override
    public Iterator<T> iterator() {
        return new TreeIterator((List) humanList);
    }


}