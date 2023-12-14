package family_Tree.model.builder;

import family_Tree.model.familyTree.FamilyTree;
import family_Tree.model.human.Gender;
import family_Tree.model.human.Human;

import java.time.LocalDate;

public class TreeBuilder {

    private int currentId = 7;

    public Human buildHuman(String name, LocalDate dateOfBirth, Gender gender){
        Human human = new Human(currentId++, name, dateOfBirth, gender);
        return human;
    }

    public Human buildHumanWithParents(String name, LocalDate dateOfBirth, Gender gender, Human mother, Human father){
        Human human = new Human(currentId++, name, dateOfBirth, gender, mother, father);
        return human;
    }

    public FamilyTree generateTree() {
        FamilyTree tree = new FamilyTree();
        Human Elena = new Human(0, "Елена", LocalDate.of(1963, 1, 27), Gender.Female);
        tree.addHuman(Elena);
        Human Oleg = new Human(1,"Олег", LocalDate.of(1968, 4, 9), Gender.Male);
        tree.addHuman(Oleg);
        Human Dima = new Human(2,"Дмитрий", LocalDate.of(1985, 5, 29), Gender.Male, Elena, Oleg);
        tree.addHuman(Dima);
        Human Rita = new Human(3,"Маргарита", LocalDate.of(1985, 10, 13), Gender.Female);
        tree.addHuman(Rita);
        Elena.addChild(Dima);
        Human Olesya = new Human(4,"Олеся", LocalDate.of(1988, 9, 8), Gender.Female);
        Olesya.addParent(Oleg);
        Olesya.addParent(Elena);
        tree.addHuman(Olesya);
        Human Nadezhda = new Human(5,"Надежда", LocalDate.of(1932,9,18), Gender.Female);
        Nadezhda.addChild(Elena);
        Nadezhda.setDateOfDeath(LocalDate.of(2005,9,5));
        tree.addHuman(Nadezhda);
        Human Vasyliy = new Human(6,"Василий", LocalDate.of(1930,5,30), Gender.Male);
        Vasyliy.addChild(Elena);
        Vasyliy.setDateOfDeath(LocalDate.of(2009,4,20));
        tree.addHuman(Vasyliy);

        return tree;
    }

}
