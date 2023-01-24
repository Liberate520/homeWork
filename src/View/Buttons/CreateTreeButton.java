package View.Buttons;

import View.View;

public class CreateTreeButton extends MenuButton{
    String buttonName = "Создать древо";
    View view;

    public CreateTreeButton(View view) {
        this.view = view;
    }

    @Override
    public void onClick() {
        view.CallCreateTreeButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
