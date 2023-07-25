package view;

public interface View {
    void print(String text);
    void showResult(String result);
    String input(String message);
    void start();
}