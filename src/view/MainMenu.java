package view;

import view.comands.GetFamilyMembers;
import view.comands.Comand;
import view.comands.Finish;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Comand> options;
    public MainMenu( ConsoleUI consoleUI )
    {
        options = new ArrayList<>();
        options.add( new GetFamilyMembers( consoleUI ));
        options.add( new Finish( consoleUI ));
    }
    public String menu()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Основное меню:\n");
        for ( int i = 0; i < options.size(); i++ )
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append( options.get(i).getDescription() );
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean checkChosenInput( int chosenOptionNum )
    {
        return chosenOptionNum > 0 && chosenOptionNum <= options.size();
    }

    public void execute(int numOption) {
        Comand chosenOption = options.get( --numOption );
        chosenOption.execute();
    }
}
