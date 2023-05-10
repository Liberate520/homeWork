package ui;

import Presenter.Presenter;

public interface View  {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addMember();
    void getMembersByName();
    void getAllMembers();
    void finish();
}
