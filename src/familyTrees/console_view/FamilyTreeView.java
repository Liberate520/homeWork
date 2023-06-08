package familyTrees.console_view;

import familyTrees.FamilyTree;
import members.Human;
import members.Member;

import java.util.Optional;

public class FamilyTreeView <T extends Member>{
    FamilyTree<T> familyTreeView;


    public FamilyTreeView(FamilyTree<T> familyTree) {
        this.familyTreeView = familyTree;
    }



    public void showParents(String childName, int yearOfBirth) {
        Member child = familyTreeView.getHumanFromTree(childName, yearOfBirth);
        if (child != null) {
            String father = Optional.ofNullable(child.getFather()).
                    map(Member::getName).orElse("Неизвестно");
            String mother = Optional.ofNullable(child.getMother()).
                    map(Member::getName).orElse("Неизвестно");
            System.out.printf("Ребенок -> %s, отец -> %s, мать %s\n",
                    child.getName(), father, mother);
        } else {
            System.out.println("Не найден в древе");
        }
    }

    public void showFamilyTree() {
        if (familyTreeView.getFamilyTree().isEmpty()) {
            System.out.println("Семейное древо пусто.");
        } else {
            System.out.println("Семейное древо:");
            for (T person : familyTreeView) {
                System.out.println(person.getName() + " (" + person.getYearOfBirth() + ")");
            }
        }
    }

    public void sortByDateBirth() {
        familyTreeView.sortTreeByDateBirth();
    }
}
