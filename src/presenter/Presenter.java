package presenter;
import view.View;
import model.FamilyTree;
import model.Service;
import presenter.Presenter;
import view.Console;


public class Presenter 
{
    private View view;
    private Service service;

    public Presenter(View view, Service service)
    {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public FamilyTree getFamilyTree(FamilyTree familyTree)
    {
        return familyTree;
    }

    public FamilyTree Show(FamilyTree familyTree)
    {
     view.print(familyTree); // работает выводит дерево  
     return familyTree; 
    }

    public void findHuman(FamilyTree familyTree)
    {
        familyTree.findHuman();
        
    } 
    
    public void SortId(FamilyTree familyTree)
    {
        familyTree.sortById();
        System.out.println("Список, отсортированный по Id: " + familyTree);
    }

    public void sortLastName(FamilyTree familyTree)
    {
        familyTree.sortByLastName();
        System.out.println("Список, отсортированный по фамилии: " + familyTree);
    }
}
