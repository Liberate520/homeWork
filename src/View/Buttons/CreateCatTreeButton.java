package View.Buttons;

import View.View;

public class CreateCatTreeButton extends MenuButton{
    String buttonName = "Создать древо котов";
    View view;

    public CreateCatTreeButton(View view) {
        this.view = view;
    }

    @Override
    public void onClick() {
        view.callCreateCatTreeButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
