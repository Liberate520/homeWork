package model;

import java.util.List;

public interface ModelInterface {
    String commandResult(String commandNumber);
    String createMenu();
    void createNewNote(String text);

    boolean exit();
}
