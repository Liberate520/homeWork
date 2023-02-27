package src.Presenter;

import src.FamilyTree.FTObjects;
import src.FamilyTree.FamilyTree;


public class Presenter<T extends FTObjects> {
    private FamilyTree<T> people;

    public Presenter(FamilyTree<T> people) {
        this.people = (FamilyTree<T>) people;
    }


/*   Принимаем от UIfromConsole данные String и Integer для добавления персон в FamilyTree,
    а также номера команд меню, для возвращения в консоль результатов этих команд;
*/


}
