package L1;

import java.util.ArrayList;

public class Family_tree {


    ArrayList<Human> people = new ArrayList<>();

    public void fillPeople(){
        Human person_x = new Human(0, 0, "Adam", "0.0.0", Gender.male);
        Human person_y = new Human(0, 0, "Eva", "0.0.0", Gender.female);
        Human person_1 = new Human(1, 25, "Oleg", "21.02.1999", Gender.male, person_x, person_y);
        Human person_2 = new Human(2, 26, "Olga", "21.02.1998", Gender.female, person_x, person_y);
        Human person_3 = new Human(3, 1, "Ivan", "21.02.2025", Gender.male, person_1, person_2);
        person_1.children.add(person_3);
        person_2.children.add(person_3);
        people.add(person_1);
        people.add(person_2);
        people.add(person_3);
    }

    public ArrayList<Human> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        for (Human human: people
             ) {
            System.out.println(human);
        }
        return "end of list";
    }
}
