import familyTree.FamilyTree;
import familyTree.FamilyTreeSerializer;
import human.Gender;
import human.Human;

import java.io.*;
import java.util.GregorianCalendar;


public class Main {
        public static void main(String[] args) {
            FamilyTree tree = new FamilyTree();
            tree.add(new Human("Василий", Gender.Male, new GregorianCalendar(1973, 03, 21)));
            tree.add(new Human("Мария", Gender.Female, new GregorianCalendar(1977, 04, 23)));
            tree.add(new Human("Кристина", Gender.Female, new GregorianCalendar(2000, 05, 10),
                    tree.getByName("Василий"), tree.getByName("Мария")));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2002, 9, 5),
                    tree.getByName("Василий"), tree.getByName("Мария")));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2003, 11, 6),
                    tree.getByName("Семен"), new Human("Ольга", Gender.Female)));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2004, 10, 8),
                    new Human("Владимир", Gender.Male), new Human("Евгения", Gender.Female)));
            tree.add(new Human("Семен", Gender.Male, new GregorianCalendar(2005, 8, 11),
                    tree.getByName("Александр"), new Human("Юлия", Gender.Female)));

            System.out.println(tree.getInfo());

            tree.sortByName();
            System.out.println("Отсортированно по имени: "+tree.getInfo());

            tree.sortByBirthDate();
            System.out.println("Отсортированно по дате рождения: "+tree.getInfo());



            FamilyTreeSerializer serializer = new FamilyTreeSerializer();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("familyTree.txt"))){
                oos.writeObject(tree);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("familyTree.txt"))){
                FamilyTree loadedTree = (FamilyTree) ois.readObject();
                //System.out.println(loadedTree.getInfo()+"555");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }