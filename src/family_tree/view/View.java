package family_tree.view;

import family_tree.model.human.Human;

public interface View {
    void displayFamilyTreeInfo(String info);
    void displayPersonInfo(Human person);
    void displayMessage(String message);
    void displayErrorMessage(String errorMessage);
}
