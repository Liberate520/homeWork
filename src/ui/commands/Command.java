package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public interface Command {
    String getDescription();
    void execute();
}
