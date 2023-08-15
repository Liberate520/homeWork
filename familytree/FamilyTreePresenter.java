package homeWork.familytree;

public interface FamilyTreePresenter {
    void onAddMember(String name, String dateOfBirth, Human.Gender gender);
    void onDisplayFamilyTree();
    // Add other methods to handle user interactions and updates
}
