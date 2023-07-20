package family_tree.view.consoleUI.menu;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.mainMenu.CreateNewTree;
import family_tree.view.consoleUI.menu.mainMenu.Finish;
import family_tree.view.consoleUI.menu.mainMenu.ReadTreeOfPersonFromFile;
import family_tree.view.consoleUI.menu.menuChooseType.CreateDogsTree;
import family_tree.view.consoleUI.menu.menuChooseType.CreatePersonTree;
import family_tree.view.consoleUI.menu.menuWorkWithTree.*;

public class Menu {
    ConsoleUi consoleUi;
    private MenuSection mainMenu;
    private MenuSection menuChooseType;
    private MenuSection menuWorkWithTree;



    public Menu(ConsoleUi consoleUi) {
        this.consoleUi = consoleUi;
        this.mainMenu = new MenuSection(consoleUi);
        this.menuChooseType = new MenuSection(consoleUi);
        this.menuWorkWithTree = new MenuSection(consoleUi);

        mainMenu.addCommand(new CreateNewTree(consoleUi));
        mainMenu.addCommand(new ReadTreeOfPersonFromFile(consoleUi));
        mainMenu.addCommand(new Finish(consoleUi));

        menuChooseType.addCommand(new CreateDogsTree(consoleUi));
        menuChooseType.addCommand(new CreatePersonTree(consoleUi));
        menuChooseType.addCommand(new Finish(consoleUi));

        menuWorkWithTree.addCommand(new AddItem(consoleUi));
        menuWorkWithTree.addCommand(new PrintTree(consoleUi));
        menuWorkWithTree.addCommand(new SaveTree(consoleUi));
        menuWorkWithTree.addCommand(new SortByAge(consoleUi));
        menuWorkWithTree.addCommand(new SortByName(consoleUi));
        menuWorkWithTree.addCommand(new Finish(consoleUi));
    }

    public void openMainMenu() {
            consoleUi.printAnswer(mainMenu.menu());
            String choice = consoleUi.getScanner().nextLine();
            int numChoice = Integer.parseInt(choice);
            mainMenu.execute(numChoice);

        }

    public void openMenuChooseType() {
        consoleUi.printAnswer(menuChooseType.menu());
        String choice = consoleUi.getScanner().nextLine();
        int numChoice = Integer.parseInt(choice);
        menuChooseType.execute(numChoice);
    }

    public void openMenuWorkWithTree() {
        consoleUi.printAnswer(menuWorkWithTree.menu());
        String choice = consoleUi.getScanner().nextLine();
        int numChoice = Integer.parseInt(choice);
        menuWorkWithTree.execute(numChoice);
    }

}
