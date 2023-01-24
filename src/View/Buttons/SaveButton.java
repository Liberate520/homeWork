package View.Buttons;

import View.View;

import java.io.IOException;

public class SaveButton extends MenuButton{
    String buttonName = "Сохранить";
    View view;

    public SaveButton(View view) {
        this.view = view;
    }

    public void onClick() throws IOException {
        view.CallSaveButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
