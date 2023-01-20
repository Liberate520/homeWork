package buttons;

import menu.userButtons;

public class SaveXlsButton extends MenuButton implements userButtons {
    public SaveXlsButton(MenuButton parent) {
        this.parent = parent;
        this.buttonName = "Сохранить в XLS";
        this.addChildToParent();
    }

    private void addChildToParent(){
        if (this.parent.subMenuButtons.size() == 0){
            this.parent.subMenuButtons.add(new ExitButton(this.parent.parent));
        }
        this.parent.subMenuButtons.add(this);
    }

    public void execute() {
        if (getSubMenuButtons().size() == 0){
            //дописать метод, который нужно вызывать (выбор того, что нужно распечатать)
            System.out.println("Сохранено в XLS");
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