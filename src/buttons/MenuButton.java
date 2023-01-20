package buttons;

import menu.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MenuButton<T extends MenuButton> {
    protected String buttonName;
    protected MenuButton<T> parent;
    protected ExitButton exitButton;
    protected List<MenuButton> subMenuButtons = new ArrayList<MenuButton>();

    public List<MenuButton> getSubMenuButtons() {
        return subMenuButtons;
    }

    public MenuButton<T> getParent() {
        return parent;
    }

    public String getButtonName() {
        return buttonName;
    }

    public abstract void execute();
}
