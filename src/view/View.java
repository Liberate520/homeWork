package view;

public interface View {
    void printAnswer(String text);
    void start();
    void addHuman();
    void getHumansListInfo();
    void sortByName();
    void sortBySurname();
    void finish();
}
