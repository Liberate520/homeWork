package View.Buttons;

import View.View;

public class PrintContainer extends MenuButton{
    String buttonName = "Показать данные, доступные для работы";
    View view;

    public PrintContainer(View view) {
        this.view = view;
    }

    public void onClick(){
        view.callPrintContainer();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
