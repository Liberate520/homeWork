package genealogy_tree.Human;

import java.util.Collections;
import java.util.List;

public class Human2 extends Human {
    public Human2(String mother, String father, List<String> children, Gender gender, String name, int age) {
        super(mother, father, children, gender, name, age);
    }
    public Human2(){
        this("Mora", "Kotlin", Collections.singletonList("Saha, Masha"), Gender.Male, "Ibragim Sansich", 33 );
    }
}

