package L1;

import java.io.*;
import java.util.ArrayList;

public class Family_tree implements Serializable {


    ArrayList<Human> listOfPeople = new ArrayList<>();

    public ArrayList<Human> fillPeople() throws IOException {
        Human person_x = new Human(0, 0, "Adam", "0.0.0", Gender.male);
        Human person_y = new Human(0, 0, "Eva", "0.0.0", Gender.female);
//        Human person_1 = new Human(1, 25, "Oleg", "21.02.1999", Gender.male, person_x, person_y);
//        Human person_2 = new Human(2, 26, "Olga", "21.02.1998", Gender.female, person_x, person_y);
//        Human person_3 = new Human(3, 1, "Ivan", "21.02.2025", Gender.male, person_1, person_2);
//
//        listOfPeople.add(person_1);
//        listOfPeople.add(person_2);
//        listOfPeople.add(person_3);
//        FileHandler saveInfo = new FileHandler();
//        saveInfo.savePeople(people);
        return listOfPeople;
    }

    public ArrayList<Human> getPeople() {
        return listOfPeople;
    }

    @Override
    public String toString() {
        for (Human human: listOfPeople
             ) {
            System.out.println(human);
        }
        return "end of list";
    }
}
