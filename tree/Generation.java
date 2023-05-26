package homeWork.tree;

import java.time.LocalDate;
import java.util.ArrayList;

public class Generation {
    public static void main(String[] args) {

    }

    public static ArrayList<Human> generateFamily(){
        ArrayList<Human> family = new ArrayList<>();
        family.add(new Human("Anton", "male", LocalDate.of(1914, 7, 28), false, false ));
        family.add(new Human("Ann", "female", LocalDate.of(1917, 2, 14), false, false ));
        family.add(new Human("Sergey", "male", LocalDate.of(1923, 4, 8), false, true ));
        family.add(new Human("Mark", "male", LocalDate.of(1910, 7, 28), false, true ));
        family.add(new Human("Alisa", "female", LocalDate.of(1920, 12, 16), false, false ));
        family.add(new Human("John", "male", LocalDate.of(1913, 4, 5), false, true ));
        family.add(new Human("Vasiliy ", "male", LocalDate.of(1920, 7, 18), false, false ));
        family.add(new Human("Anastasia", "female", LocalDate.of(1946, 2, 6), true, false ));
        family.add(new Human("Elise", "female", LocalDate.of(1950, 9, 22), false, true ));
        family.add(new Human("Nil", "male", LocalDate.of(1953, 2, 27), false, false ));
        family.add(new Human("Erick", "male", LocalDate.of(1949, 9, 21), false, true ));
        family.add(new Human("Tania", "female", LocalDate.of(1950, 9, 22), false, true ));
        family.add(new Human("Victor", "male", LocalDate.of(1982, 1, 27), true, false ));
        family.add(new Human("Victoria", "female", LocalDate.of(1985, 4, 23), true, false ));
        family.add(new Human("Angela", "female", LocalDate.of(1986, 10, 2), true, false ));
        family.add(new Human("Evgeny", "male", LocalDate.of(1987, 6, 7), true, false ));
        family.add(new Human("Eva", "female", LocalDate.of(1986, 4, 11), true, false ));
        family.add(new Human("Olga", "female", LocalDate.of(2010, 7, 8), true, true ));
        family.add(new Human("Artur", "male", LocalDate.of(2011, 9, 1), true, true ));
        family.add(new Human("John", "male", LocalDate.of(2018, 10, 8), true, true ));
        family.add(new Human("Alex", "male", LocalDate.of(2015, 4, 8), true, true ));
        family.add(new Human("Misha", "male", LocalDate.of(2016, 11, 18), true, true ));

        return family;
    }

    public static ArrayList<Parent> generateParents(){
        ArrayList<Human> family = generateFamily();
        ArrayList<Parent> parents = new ArrayList<>();
        for (Human human : family) {
            if (human.getBirthday().getYear() < 2000) {
                Parent parent = new Parent(human.getName(), human.getGender(), human.getBirthday(), human.getAlive(), human.getChildfree());
                parents.add(parent);
            }
        }

        parents.get(0).addChild(generateFamily().get(7));
        parents.get(1).addChild(generateFamily().get(7));
        parents.get(0).addChild(generateFamily().get(10));
        parents.get(1).addChild(generateFamily().get(10));

        parents.get(4).addChild(generateFamily().get(8));
        parents.get(4).addChild(generateFamily().get(9));
        parents.get(6).addChild(generateFamily().get(8));
        parents.get(6).addChild(generateFamily().get(9));


        parents.get(7).addChild(generateFamily().get(12));
        parents.get(9).addChild(generateFamily().get(12));

        parents.get(13).addChild(generateFamily().get(17));
        parents.get(14).addChild(generateFamily().get(17));
        parents.get(13).addChild(generateFamily().get(18));
        parents.get(14).addChild(generateFamily().get(18));

        parents.get(15).addChild(generateFamily().get(19));
        parents.get(16).addChild(generateFamily().get(19));
        parents.get(15).addChild(generateFamily().get(20));
        parents.get(16).addChild(generateFamily().get(20));
        parents.get(15).addChild(generateFamily().get(21));
        parents.get(16).addChild(generateFamily().get(21));







        return parents;
    }

    public static ArrayList<Child> generateChildren(){

        ArrayList<Parent> parents = generateParents();
        ArrayList<Child> children = new ArrayList<>();

        for(Parent parent: parents){
            for (Human child: parent.getChildren()){
                Child ch = new Child(child.getName(), child.getGender(), child.getBirthday(), child.getAlive(), child.getChildfree());
                if(!children.contains(ch)){
                    children.add(ch);
                    ch.addParent(parent);
                }
                else {
                    ch.addParent(parent);
                }

            }
        }
        return children;
    }





}
