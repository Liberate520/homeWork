import java.io.IOException;

import model.Service;
import model.Comparator.SortByLastName;
import model.Comparator.SortId;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.FindHuman;
import model.FamilyTree.AddIntoTree.AddHuman;
import model.FamilyTree.AddIntoTree.AddPerson;
import model.Iterator.HumanIterator;
import model.Persons.Human;
import model.Persons.Others;
import model.Persons.Person;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main 
{
    public static void main(String[] args) throws ClassNotFoundException, IOException 
    {
        View view = new Console();
        FamilyTree familyTree = new FamilyTree();
        AddHuman addHuman = new AddHuman();
        SaveBinFormat saveBinFormat = new SaveBinFormat();
        SaveTextFormat saveTextFormat = new SaveTextFormat();
        SaveDocFormat saveDocFormat = new SaveDocFormat();
        SaveMdFormat saveMdFormat = new SaveMdFormat();
        SortId sortId = new SortId();
        SortByLastName sortByLastName = new SortByLastName();
        FindHuman findHuman = new FindHuman();
        AddPerson addPerson = new AddPerson();

        Service service = new Service(familyTree, addHuman,
                                        saveBinFormat, saveTextFormat, saveDocFormat, 
                                        sortId, sortByLastName, findHuman, addPerson);

        Presenter presenter = new Presenter(view, service);
        view.StartProgram();    
    }
}
