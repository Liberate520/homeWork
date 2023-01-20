package menu;

import buttons.MenuButton;
import tree.Gender;

public class View {

    public void UserInterface(UserMenu userMenu){
        MenuButton currentButton = userMenu.start();
        Model model = new Model();
        Controller controller = new Controller(model);
        Integer choice = null;
        while(true){
            userMenu.printMenu(currentButton);
            choice = userMenu.getChoice();
            currentButton = controller.getCurrentButton(currentButton, choice);
        }
    }
}
