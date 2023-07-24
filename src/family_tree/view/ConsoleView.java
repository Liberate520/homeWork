package family_tree.view;

import family_tree.model.human.Human;

public class ConsoleView implements View {
    @Override
    public void displayFamilyTreeInfo(String info) {
        System.out.println("Family Tree Info:");
        System.out.println(info);
        System.out.println();
    }

    @Override
    public void displayPersonInfo(Human person) {
        System.out.println("Person Info:");
        if (person != null) {
            System.out.println(person.getInfo());
        } else {
            System.out.println("Person not found.");
        }
        System.out.println();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void displayErrorMessage(String errorMessage) {
        System.out.println("Error: " + errorMessage);
        System.out.println();
    }
}
