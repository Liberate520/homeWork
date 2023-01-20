package buttons;

import menu.userButtons;

public class SaveButton extends MenuButton implements userButtons {
    public SaveButton(MenuButton parent) {
        this.parent = parent;
        this.buttonName = "Сохранить";
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
            System.out.println("Сохранено");
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