package view;

import presenter.Presenter;

/**
 * Не придумал особо что сюда добавить
 */
public interface View {
    void setPresenter(Presenter presenter);
    void start();
}
