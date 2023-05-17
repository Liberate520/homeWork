package java_oop_homeWork.src.ui.menues;

import java_oop_homeWork.src.ui.View;
import java_oop_homeWork.src.ui.commands.*;

public class SexMenu extends Menu {
    public SexMenu(View view) {
        super(view);
        commandList.add(new SelectMen(view));
        commandList.add(new SelectWomen(view));
    }
}
