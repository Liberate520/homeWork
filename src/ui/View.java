package ui;

import Presenter.Presenter;

public interface View {
    public void setPresenter(Presenter presentr);
    public void start(Presenter presentr);
    public void print(String text);
    // public void showAllPerson();
    // public String showPerson(Integer chois);
    public void сhildrentoSring();
    public void addChild();
    public void delChild();
    public void choisParent();
    public void SortPerson();
    public void load();
    public void save();
    public void Exit();
    public void ExitAncestry();
    public void ChangMenuAncestry();
}
