package View.Buttons;

import View.View;

public class UpButton extends MenuButton {

    public UpButton(View view) {
        this.buttonName = "Вернуться к предыдущему меню";
        this.view = view;
    }

    @Override
    public void onClick() {
        view.setMenu(view.getLastMenu());
        view.CallMenu();
    }
}
