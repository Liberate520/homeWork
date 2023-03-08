package menu;

import ui.View;

public class StartMenu  extends Command{

    public StartMenu(View view) {
        super(view);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return "Список Всех людей ";
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.getView().ShowAllPerson();;
        
    }
    
}
