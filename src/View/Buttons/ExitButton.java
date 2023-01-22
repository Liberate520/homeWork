package View.Buttons;

import View.View;

public class ExitButton extends MenuButton {

    public ExitButton(View view) {
        this.buttonName = "Завершить работу";
        this.view = view;
    }

    @Override
    public void onClick() {
        view.CallExitButton();
    }
}
