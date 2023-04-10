package presenter;
import view.View;

import java.util.Scanner;

import model.FamilyTree;
import model.Node;
import model.Service;
import presenter.Presenter;
import view.Console;


public class Presenter<T> 
{
    private View view;
    private Service service;

    public Presenter(View view, Service service)
    {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public T getFamilyTree(T t)
    {
        return t;
    }

    public T Show(T t)
    {
     view.print(t); // работает выводит дерево  
     return t; 
    }

    public <T extends FamilyTree> void startFindHuman(T t)
     {
         FamilyTree.findHuman(t);
    }
    
    public void SortId(T t)
    {
        ((FamilyTree) t).sortById();
        System.out.println("Список, отсортированный по Id: " + t);
    }

    public void sortLastName(T t)
    {
        ((FamilyTree) t).sortByLastName();
        System.out.println("Список, отсортированный по фамилии: " + t);
    }
}
