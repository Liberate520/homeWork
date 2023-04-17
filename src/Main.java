import java.io.IOException;

import model.Service;
import model.Comparator.SortByLastName;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.FindHuman;
import model.FamilyTree.AddIntoTree.AddPerson;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;
import model.Comparator.SortById;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main 
{
    public static void main(String[] args) throws ClassNotFoundException, IOException 
    {
        View view = new Console();

        FamilyTree familyTree = new FamilyTree();
        SaveBinFormat saveBinFormat = new SaveBinFormat();
        SaveTextFormat saveTextFormat = new SaveTextFormat();
        SaveDocFormat saveDocFormat = new SaveDocFormat();
        SaveMdFormat saveMdFormat = new SaveMdFormat();
        SortByLastName sortByLastName = new SortByLastName();
        FindHuman findHuman = new FindHuman();
        AddPerson addPerson = new AddPerson();
        SortById sortById = new SortById();

        Service service = new Service(familyTree,
         saveBinFormat, saveTextFormat, saveDocFormat,
          saveMdFormat, sortById, sortByLastName, findHuman, addPerson);

        Presenter presenter = new Presenter(view, service);
        view.StartProgram();    
    }
}
