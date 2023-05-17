package java_oop_homeWork.src.ui.menues;

import java_oop_homeWork.src.ui.View;
import java_oop_homeWork.src.ui.commands.*;

public class TreeMenu extends Menu {
    public TreeMenu(View view) {
        super(view);
        commandList.add(new GetFamily(view));
        commandList.add(new StartAddMenu(view));
        commandList.add(new FinishTreeMenu(view));
    }
}
