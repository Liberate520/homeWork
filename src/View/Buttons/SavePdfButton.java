package View.Buttons;

import View.View;

public class SavePdfButton extends MenuButton{
    String buttonName = "Сохранить в PDF";
    View view;

    public SavePdfButton(View view) {
        this.view = view;
    }

    public void onClick(){
        view.CallCommandButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
