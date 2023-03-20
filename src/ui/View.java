package ui;

import Presenter.Presenter;

public interface View {
    public void setPresenter(Presenter presentr);
    public void start(Presenter presentr);
    public void print(String text);
    public void showAllPerson();
    public String showPerson(Integer chois);
    public String сhildrentoSring(Integer cur);
    // public void addFater(Integer cur,Integer fat);
    // public void addMother(Integer cur,Integer mot);
    public void addChild(Integer cur,Integer chil,Integer delChil);
}
