package buttons;

import menu.userButtons;

public class ExitButton extends MenuButton implements userButtons {
    public ExitButton(MenuButton parent) {
        this.parent = parent;
        this.buttonName = "Выйти";
    }

    public ExitButton() {
        this(null);
    }

    public void execute() {
        if (this.parent == null){
            System.out.println("Спасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return getButtonName();
    }
}