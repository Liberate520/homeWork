package mvp;

public interface View {
    void showMainMenu();

    void showNoteInputWelcome();

    String mainMenuItem();

    String note();

    String scan();

    void print(String outputString);
}
