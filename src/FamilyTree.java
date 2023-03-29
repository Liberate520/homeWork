import java.util.ArrayList;

public class FamilyTree {

    public Human createHuman(String sex, Human father, Human mother, String name) {
        Human child = new Human(sex, name, father.lastName, mother, father, new ArrayList<>());
        father.addChild(child);
        mother.addChild(child);
        return child;
    }
}
