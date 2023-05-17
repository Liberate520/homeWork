package java_oop_homeWork.src.ui.menues;

import java_oop_homeWork.src.ui.View;
import java_oop_homeWork.src.ui.commands.*;

public class AddMenu extends Menu {
    String firstName;
    String lastName;
    public AddMenu(View view) {
        super(view);
        commandList.add(new AddParent(view));
        commandList.add(new AddChild(view));
        commandList.add(new FinishAddMenu(view));
    }
}
