package View.Buttons;

import View.View;

import java.io.IOException;

public class UpButton extends MenuButton {

    public UpButton(View view) {
        this.buttonName = "Вернуться к предыдущему меню";
        this.view = view;
    }

    @Override
    public void onClick() throws IOException {
        view.setMenu(view.getLastMenu());
        view.CallMenu();
    }
}
