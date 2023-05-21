package ui.View;

import presenter.PresenterHuman;

public interface ViewHuman extends  View{
    void addChild();
    void addMember();
    void getMarried();
    void setPresenter(PresenterHuman presenter);
}
