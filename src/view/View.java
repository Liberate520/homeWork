package view;

public interface View {
    void start();
    void answer(String answer);
    void sortByAge();
    void sortByName();
    void sortBySurname();
    void sortById();
    void getFamilyList();
    void load();
    void save();
//    void addHuman();
    void addHuman();
    void setChild();
    void findByName();
    void finish();
}
