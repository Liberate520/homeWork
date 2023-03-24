package menu;

import ui.View;

public class SaveMenu  extends Command{
    
    public SaveMenu(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Запись в файл";
    }

    @Override
    public void execute() {
        this.getView().save();
    }
}
