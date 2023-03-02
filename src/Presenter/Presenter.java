package src.Presenter;

import src.FamilyTree.FamilyTree;
import src.FamilyTree.Person;
import src.UI.View;

public class Presenter {
    private View view;
    private FamilyTree<Person> family;

    public Presenter(View view) {
        this.view = view;
    }

    }





/*   Принимаем от UIfromConsole данные String и Integer для добавления персон в FamilyTree,
    а также номера команд меню, для возвращения в консоль результатов этих команд;
*/



