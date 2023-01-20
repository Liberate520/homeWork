package menu;

import buttons.MenuButton;
import tree.Cat;
import tree.UserMenu;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public MenuButton getCurrentButton(MenuButton currentButton, Integer choice){
        currentButton = (MenuButton) currentButton.getSubMenuButtons().get(choice);
        Integer submenuSize = getSubmenuSize(currentButton);
        if (submenuSize == 0){
            buttonClick(currentButton);
            currentButton = getParent(currentButton);
        }
        return currentButton;
    }

    public Integer getSubmenuSize(MenuButton currentButton){
        return currentButton.getSubMenuButtons().size();
    }

    public void buttonClick(MenuButton currentButton){
        currentButton.execute();
    }

    public MenuButton getParent(MenuButton currentButton){
        return currentButton.getParent();
    }

    public Cat Create(){
        return model.CreateCat();
    }


}
