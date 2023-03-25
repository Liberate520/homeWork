package mvp;

public interface View {

    void start();

    void showMainMenu();

    void showNoteInputWelcome();

    String mainMenuItem();

    String note();

    String scan();

    void print(String outputString);

    void setPresenter(Presenter presenter);
}
