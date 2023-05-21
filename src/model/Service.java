package model;

public class Service {
    private FamilyTree tree;

    public Service(FamilyTree tree) {
        this.tree = tree;
    }

    public Service() {
        this(new FamilyTree());
    }

    public void addHuman(String name, int age, String gender, String motherName, String fatherName) {
        Gender gender1 = Gender.male;
        if (gender.equals("ж")) {
            gender1 = Gender.female;
        }

        Human mother = null;
        Human father = null;

        if (tree.findHumanByName(motherName) != null) {
            mother = (Human) tree.findHumanByName(motherName);
        }
        if (tree.findHumanByName(fatherName) != null) {
            father = (Human) tree.findHumanByName(fatherName);
        }

        Human newHuman = new Human(name, age, gender1, mother, father);

        tree.addHuman(newHuman);
    }

    public void showAllRelatives() {
        System.out.println(tree.showAllRelatives());
    }

    public String findHumanByName(String name) {
        Human human = null;

        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            return human.toString();
        }

        return "Такого человека не существует";
    }

    public void showKids(String name) {
        Human human = null;
        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            human.showKids();
        } else System.out.println("Некорректное имя");
    }

    public void findSiblings(String name) {
        Human human = null;
        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            human.findSiblings();
        } else System.out.println("Некорректное имя");
    }
}
