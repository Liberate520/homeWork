package familyTrees.console_view;

import familyTrees.FamilyTree;
import human.Human;

import java.util.List;
import java.util.Optional;

public class FamilyTreeView {
    FamilyTree familyTreeView;


    public FamilyTreeView(FamilyTree familyTree) {
        this.familyTreeView = familyTree;
    }

    public void showChildren() {

    }

    public void showParents(String childName, int yearOfBirth) {
        Human child = familyTreeView.getPersonFromTree(childName, yearOfBirth);
        if (child != null) {
            String father = Optional.ofNullable(child.getFather()).
                    map(Human::getNAME).orElse("Неизвестно");
            String mother = Optional.ofNullable(child.getMother()).
                    map(Human::getNAME).orElse("Неизвестно");
            System.out.printf("Ребенок -> %s, отец -> %s, мать %s\n",
                    child.getNAME(), father, mother);
        } else {
            System.out.println("Не найден в древе");
        }
    }

    public void showFamilyTree() {
        if (familyTreeView.getFamilyTree().isEmpty()) {
            System.out.println("Семейное древо пусто.");
        } else {
            System.out.println("Семейное древо:");
            for (Human person : familyTreeView) {
                System.out.println(person.getNAME() + " (" + person.getYearOfBirth() + ")");
            }
        }
    }
}
