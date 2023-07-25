package genealogy_tree.Human;

import java.util.Collections;
import java.util.List;

public class Human1 extends Human {


    public Human1(String mother, String father, List<String> children, Gender gender, String name, int age) {
        super(mother, father, children, gender, name, age);
    }
    public Human1(){
        this("Dora", "Jony", Collections.singletonList("Gosha"), Gender.Female, "Dusa Pupkina", 45 );
}

}
