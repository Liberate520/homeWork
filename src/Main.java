import service.Persons.Comparators.SortByDate;
import service.Persons.Comparators.SortByName;
import presenter.Presenter;
import service.Service;
import service.io.DataLoad;
import service.io.DataSave;
import service.io.FileHandlerLoad;
import service.io.FileHandlerSaver;
import service.tree.AddToTree.AddPerson;
import service.tree.FamilyTree;
import service.tree.FindHuman;
import view.ConsoleUI;
import view.View;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, IOException
    {
        View view = new ConsoleUI();

        FamilyTree familyTree = new FamilyTree();
        DataSave saveData = new FileHandlerSaver();
        DataLoad dataLoad = new FileHandlerLoad();
        SortByName sortByName = new SortByName();
        FindHuman findHuman = new FindHuman();
        AddPerson addPerson = new AddPerson();
        SortByDate sortByDate = new SortByDate();

        Service service = new Service(familyTree, saveData, sortByName, findHuman, addPerson, sortByDate);

        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
