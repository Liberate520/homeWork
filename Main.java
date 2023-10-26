package FamilyTree;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание нескольких человек
        Human grandparent1 = new Human("Татьяна",1934);
        Human grandparent2 = new Human("Николай ", 1935);
        Human parent1 = new Human("Петр ", 1960);
        Human parent2 = new Human("Мария", 1965);
        Human child1 = new Human("Игорь", 1990);
        Human child2 = new Human("Иван", 1995);

        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree(grandparent1);


        familyTree.addFamilyMember(grandparent1, parent1);
        familyTree.addFamilyMember(grandparent2, parent2);
        familyTree.addFamilyMember(parent1, child1);
        familyTree.addFamilyMember(parent2, child2);
        

        // Получение всех детей выбранного человека
        List<Human> childrenOfParent = familyTree.getChildrenOfHuman(parent1);
        System.out.println("Children of " + parent1.getName());
        for (Human child : childrenOfParent) {
            System.out.println(child.getName());
            System.out.println();
        }
    }
}
