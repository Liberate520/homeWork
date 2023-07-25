package genealogy_tree.Human;

import java.util.Collections;
import java.util.List;

public class Human3 extends Human {
    public Human3(String mother, String father, List<String> children, Gender gender, String name, int age) {
        super(mother, father, children, gender, name, age);
    }
    public Human3(){
        this("Toscka", "Shak-Shak", Collections.singletonList("null"), Gender.Male, "Dobrina Nikusin", 21 );
    }
}

