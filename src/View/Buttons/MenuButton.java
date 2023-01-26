package View.Buttons;

import View.Clickable;
import View.View;

import java.io.IOException;

public abstract class MenuButton implements Clickable {
    String buttonName;
    View view;

    public abstract void onClick() throws IOException;

    @Override
    public String toString() {
        return buttonName;
    }
}
