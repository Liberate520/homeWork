package View.Buttons;

import View.View;

public class AddHumanButton extends MenuButton{
    String buttonName = "Добавить человека в древо";
    View view;

    public AddHumanButton(View view) {
        this.view = view;
    }

    public void onClick(){
        view.callAddHumanButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
