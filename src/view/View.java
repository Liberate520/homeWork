package view;

import presenter.Presenter;

/*
Интерфейс вывода информации.
 */
public interface View {
    void setPresenter(Presenter presenter);

    void start();

    void print(String data);
}
