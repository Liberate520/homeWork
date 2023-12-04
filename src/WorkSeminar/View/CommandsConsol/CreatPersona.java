package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class CreatPersona extends Commands{

    public CreatPersona(View view){
        super("Создать нового члена семьи: ", view);
    }
    public void execute() {
        getView().creatPersona();
    }
}
