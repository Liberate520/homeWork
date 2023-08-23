package FT_Project.view.Actions;

import FT_Project.view.Console;

public class SortById extends Action{
    public SortById(Console console) {
        super(console);
        description = "Отсортировать древо по порядку";
    }
    public void execute(){
        console.sortById();
    }
}
