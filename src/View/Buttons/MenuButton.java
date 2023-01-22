package View.Buttons;

import View.Clickable;
import View.View;

public abstract class MenuButton implements Clickable {
    String buttonName;
    View view;

    public void onClick(){
        view.CallCommandButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
