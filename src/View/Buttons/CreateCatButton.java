package View.Buttons;

import View.View;

public class CreateCatButton extends MenuButton{
    String buttonName = "Создать кота";
    View view;

    public CreateCatButton(View view) {
        this.view = view;
    }

    public void onClick(){
        view.CallCreateCatButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
