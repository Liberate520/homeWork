package View.Buttons;

import View.View;

public class CreateHumanTreeButton extends MenuButton{
    String buttonName = "Создать древо людей";
    View view;

    public CreateHumanTreeButton(View view) {
        this.view = view;
    }

    @Override
    public void onClick() {
        view.callCreateHumanTreeButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
