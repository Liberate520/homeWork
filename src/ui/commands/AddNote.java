package Seminar6.src.ui.commands;


import Seminar6.src.ui.ConsoleUi;


public class AddNote extends Commands {

    public AddNote(ConsoleUi cU) {
        super(cU);
    }

    @Override
    public String toString() {
        return "Добавить запись в ежедневник";
    }
    public void  execute(){
        consoleUi.addingNote();







    }
}
