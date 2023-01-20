package menu;

import buttons.*;
import menu.LoadMenu;

import java.util.Scanner;

public class UserMenu<T extends MenuButton> {
    private MenuButton mainButton;

    public UserMenu() {
        this.mainButton = new MainButton();
    }

    public void printMenu(MenuButton currentButton) {
        System.out.printf("----- %s -----\n", currentButton.getButtonName());
        for (int i = 0; i < currentButton.getSubMenuButtons().size(); i++) {
            System.out.println("" + i + " - " + currentButton.getSubMenuButtons().get(i));
        }
        System.out.println("--------------");
        System.out.print("Выберите из списка: ");
    }

    public Integer getChoice(){
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        return Integer.parseInt(choice);
    }

    public String getInfo(String question){
        System.out.print(question + ": ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer;
    }

    public MenuButton getMainButton() {
        return mainButton;
    }

    private void setMainButton(MenuButton mainButton) {
        this.mainButton = mainButton;
    }

    public void load() {
        this.setMainButton(LoadMenu.execute());
    }

    public MenuButton start(){
        return this.getMainButton();
    }
}
