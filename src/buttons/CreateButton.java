package buttons;

import menu.userButtons;

public class CreateButton extends MenuButton implements userButtons {
    public CreateButton(MenuButton parent) {
        this.parent = parent;
        this.buttonName = "Создать";
        this.addChildToParent();
    }

    private void addChildToParent(){
        if (this.getParent().getSubMenuButtons().size() == 0){
            this.getParent().getSubMenuButtons().add(new ExitButton(this.getParent().getParent()));
        }
        this.getParent().getSubMenuButtons().add(this);
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
        return buttonName;
    }
}