package presenter;

import model.FamilyTree;
import model.FamilyTreeItem;
import model.Gender;
import model.Human;
import ui.View;

public class Presenter {
    private View view;
    private FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public void addHuman(String name, int age, String gender, String motherName, String fatherName) {
        Gender gender1 = Gender.male;
        if (gender.equals("ж")) {
            gender1 = Gender.female;
        }

        Human mother = null;
        Human father = null;

        if (familyTree.findHumanByName(motherName) != null) {
            mother = (Human) familyTree.findHumanByName(motherName);
        }
        if (familyTree.findHumanByName(fatherName) != null) {
            father = (Human) familyTree.findHumanByName(fatherName);
        }

        Human newHuman = new Human(name, age, gender1, mother, father);

        familyTree.addHuman(newHuman);
    }


    public void showAllRelatives() {
        view.print(familyTree.showAllRelatives());
    }

    public String findHumanByName(String name) {
        Human human = null;

        if (familyTree.findHumanByName(name) != null) {
            human = (Human) familyTree.findHumanByName(name);
            return human.toString();
        }

        return "Такого человека не существует";
    }

    public void showKids(String name) {
        Human human = null;
        if (familyTree.findHumanByName(name) != null) {
            human = (Human) familyTree.findHumanByName(name);
            human.showKids();
        } else System.out.println("Некорректное имя");
    }

    public void findSiblings(String name) {
        Human human = null;
        if (familyTree.findHumanByName(name) != null) {
            human = (Human) familyTree.findHumanByName(name);
            human.findSiblings();
        } else System.out.println("Некорректное имя");
    }



}
