package src.Presenter;

import src.FamilyTree.FTService;
import src.UI.View;


public class Presenter {
    private View view;
    private FTService ftService;


    public Presenter(View view, FTService ftService) {
        this.view = view;
        this.ftService = ftService;
        view.setPresenter(this);

    }

    public void PrintingListOfPersons(){
        view.print(ftService.PrintingListOfPersons());
    }

    public void YearsOfTheReignOfPersons(){
        view.print(ftService.YearsOfTheReignOfPersons());
    }
    public void load() {
        ftService.load();
    }

    public void save() {
        ftService.save();
    }
}





/*   Принимаем от UIfromConsole данные String и Integer для добавления персон в FamilyTree,
    а также номера команд меню, для возвращения в консоль результатов этих команд;
*/



