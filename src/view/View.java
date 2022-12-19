package view;

public interface View {

    int menu();
    int [] input();
    void output(int[] answer);

    void setOper(String s);

    String getOper();
}
