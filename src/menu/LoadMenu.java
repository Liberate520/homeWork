package menu;

import ui.View;

public class LoadMenu  extends Command{
    
    public LoadMenu(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Чтение из файла";
    }

    @Override
    public void execute() {
        this.getView().load();
    }
    
}
