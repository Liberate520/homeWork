package Tree.ui;

import Tree.presenter.Presenter;

// интерфейс реализует методы для запуска приложения
public interface View {

    // методы для реализации
    void setPresenter(Presenter presenter);

    void start();

    void print(String text);
}
