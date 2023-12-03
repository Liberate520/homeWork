package FamilyTree.view;

public interface View {

    void start();
    void answer(String str);

    void addPerson();
    void getTree();
    void sortByName();
    void sortByAge();
    void saveTree();
    void loadTree();

    void setMarriage();

    void finish();
}
