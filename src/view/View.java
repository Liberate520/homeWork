package view;

import presenter.Presenter;

//----------------- Интерфейс ---------------------------------------
public interface View {
    void print(String text);
    void setPresenter(Presenter presenter);
    void start(); //!<--- Запуск приложения
}
