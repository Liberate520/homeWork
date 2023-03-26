package Seminar6.src.ui;

import Seminar6.src.presenter.Presenter;

public interface View {
    void addNote(String str);
    String printNote();
    void allList();
    void launch();
    void setPresenter(Presenter presenter);
}
