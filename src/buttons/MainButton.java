package buttons;

import menu.userButtons;

public class MainButton extends MenuButton implements userButtons {
    public MainButton() {
        this.parent = null;
        this.buttonName = "Главное меню";
        this.subMenuButtons.add(new ExitButton());
    }

    public void execute() {
        if (getSubMenuButtons().size() == 0){
            System.out.println("Создано");
        } else {
            for (int i = 0; i < getSubMenuButtons().size(); i++) {
                System.out.println("\n" + i + getSubMenuButtons().get(i));
            }
        }
    }

    @Override
    public String toString() {
        return getButtonName();
    }
}