package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class GetListInfo extends Command{


    public GetListInfo(ConsoleUI consoleUI) {
        super(consoleUI, "Показать семейное дерево");
    }
    public void execute(){
        consoleUI.getHumanListUI();
    }
}

