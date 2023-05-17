package java_oop_homeWork.src.ui.menues;

import java_oop_homeWork.src.ui.View;
import java_oop_homeWork.src.ui.commands.*;

public class MainMenu extends Menu {
    public MainMenu(View view) {
        super(view);
        commandList.add(new GetAllTrees(view));
        commandList.add(new SelectFamilyTree(view));
        commandList.add(new NewFamilyTree(view));
        commandList.add(new FinishMainMenu(view));
    }
}
