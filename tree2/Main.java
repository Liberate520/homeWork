package homeWork.tree2;


import java.time.LocalDate;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human[] people = new Human[10];

        people[0] = new Human("John", LocalDate.of(1950, 5, 15));
        people[1] = new Human("Elise", LocalDate.of(1951, 2, 11));
        people[2] = new Human("Mark", LocalDate.of(1974, 1, 11));
        people[3] = new Human("Iren", LocalDate.of(1976, 11, 7));
        people[4] = new Human("Nina", LocalDate.of(1998, 9, 9));
        people[5] = new Human("Artem", LocalDate.of(1999, 5, 5));
        people[6] = new Human("Jack", LocalDate.of(2010, 5, 12));
        people[7] = new Human("Jane", LocalDate.of(2012, 7, 12));
        people[8] = new Human("Alex", LocalDate.of(2014, 5, 15));
        people[9] = new Human("Soo", LocalDate.of(2019, 5, 30));


        people[3].setFather(people[1]);
        people[3].setMother(people[2]);
        people[3].getChildren().add(people[7]);
        people[3].getChildren().add(people[8]);

        people[5].setFather(people[3]);
        people[6].setMother(people[4]);
        people[7].getChildren().add(people[9]);


        FamilyTree familyTree = new FamilyTree();

        for (int i = 0; i < people.length; i++) {
            familyTree.addPeople(people[i]);
        }


        FileHandler fileHandler = new FileHandler();


        fileHandler.save(familyTree);
        System.out.println(fileHandler.load().getFamilies());


        String[] familiesArray = fileHandler.load().getFamilies().split("\n");
        String firstElement = familiesArray[3]; // Выберите 3, т.к. там и родители и дети!
        System.out.println("Этот тот самый человек!" + " " + familyTree.findPersonByName(familyTree, firstElement));
        System.out.println("А вот его родители:" + " " + familyTree.findPersonByName(familyTree, firstElement).getFather() +
                " " + familyTree.findPersonByName(familyTree, firstElement).getMother());
        System.out.println("А вот его дети:" + " " + familyTree.findPersonByName(familyTree, firstElement).getChildren().toString());



    }


}
