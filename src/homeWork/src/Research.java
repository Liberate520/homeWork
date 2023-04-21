package homeWork.src;

public class Research {
    public static void main(String[] args) {
        GenealogicalTree<Human> familyTree = new FamilyTree<>();
        Human parentTemplate = new Human("", 0, "");
        UserInterface<Human> userInterface = new UserInterface<>(familyTree, parentTemplate);
        userInterface.run();
    }
}




    