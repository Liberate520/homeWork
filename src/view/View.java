package homeWork.src.view;

public interface View {
    void start();
    void answer(String answer);
    void addFamilyMember();
    void getFamilyTreeInfo();
    void sortBySurname();
    void sortByBirthdate();
    void save();
    void loadFamilyTree();
    void changeFamilyMember();
    void exit();

}
