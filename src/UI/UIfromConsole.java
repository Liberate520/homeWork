package src.UI;

import src.FamilyTree.FTObjects;
import src.FamilyTree.FamilyTree;
import src.Presenter.Presenter;

import java.io.IOException;

public class UIfromConsole<T extends FTObjects> {
    private FamilyTree<T> people;
    private Presenter presenter;
    private static Integer actionNumber;

    public UIfromConsole(FamilyTree<T> people, Presenter<T> presenter) throws ClassNotFoundException, IOException {
        this.people = (FamilyTree<T>) people;
        this.presenter = presenter;
    }

//    public Integer menu() throws IOException, ClassNotFoundException {
//        Integer actionNumber = null;
//        Scanner iScanner = new Scanner(System.in);
//        people = (FamilyTree<T>) SavingFT.restoreFromFile();
//        people.sortByName();
//        people.getList();

/*  выводим в консоль список персон для ознакомления и печатаем меню, выбор из которого отправляем в Presenter

 */

//        return actionNumber;
//    }
}
