package ui.View;

import presenter.PresenterDog;

public interface ViewDog extends  View{
    void addChild();
    void addMember();
    void setPresenter(PresenterDog presenterDog);
}
