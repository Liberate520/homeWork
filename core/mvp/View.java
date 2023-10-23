package homeWork3.core.mvp;

public interface View {
    void setPresenter(Presenter presenter);

    void start();

    void print(String text);

    String scan();
}