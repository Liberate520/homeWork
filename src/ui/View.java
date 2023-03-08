package ui;

import Presenter.Presenter;

public interface View {
    public void setPresenter(Presenter presentr);
    void start(Presenter presentr);
    void print(String text);
    void ShowAllPerson();
    
}
