package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class GetNamePersona extends Commands{
    public GetNamePersona(View view){
        super("Найти членов семьи по имени ", view);
    }
    public void execute() {
        getView().getNamePersona();
    }
}
