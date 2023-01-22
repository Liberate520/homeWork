package View.Buttons;

import View.View;

public class SaveXlsButton extends MenuButton{
    String buttonName = "Сохранить в XLS";
    View view;

    public SaveXlsButton(View view) {
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
