package ui;

import Presenter.Presenter;

public interface View {
    public void setPresenter(Presenter presentr);
    public void start(Presenter presentr);
    public void print(String text);
    public void showAllPerson();
    public String showPerson(Integer chois);
    public String сhildrentoSring(Integer cur);
    public void addFater(Integer chois,Integer chois2);
    public void addMother(Integer chois,Integer chois2);
    public void addChild(Integer chois,Integer chois2);
}
