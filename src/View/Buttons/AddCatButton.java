package View.Buttons;

import View.View;

public class AddCatButton extends MenuButton{
    String buttonName = "Добавить кота в древо";
    View view;

    public AddCatButton(View view) {
        this.view = view;
    }

    public void onClick(){
        view.callAddCatButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
