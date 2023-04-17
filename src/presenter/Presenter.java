package presenter;
import view.View;

import java.io.IOException;
import java.util.Scanner;

import model.*;
import model.Service;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.FindHuman;
// import model.FamilyTree.AddIntoTree.AddHuman;
import model.Persons.Human;
import model.Persons.Person;
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

    public void PresenterTreeFillsByHuman() // добавление людей в дерево и вывод дерева на экран
    {
        service.addHuman();
        service.addOthers();
    }

    public void PresenterFindPerson() // нахождение персоны по имени и фамилии
    {
        service.FindHuman();
    }

    public void PresenterSortById() // сортировка дерева id
    {
        // service.SortId();
        service.SortById();
    }

    public void PresenterSortByName() // сортировка дерева по имени 
    {
        service.SortByLastName();
    }
    // методы для записи в файл:

    public void PresenterSaveBinFormat() throws IOException, ClassNotFoundException
    {
        service.SaveBinFormat(); // сериализация дерева в бинарный файл
    }

    public void PresenterSaveTxtFormat() throws IOException, ClassNotFoundException
    {
        service.SaveTxtFormat(); // сохранение дерева в текстовом формате
    }

    public void PresenterSaveDocFormat() throws IOException, ClassNotFoundException
    {
        service.SaveDocFormat();  // сохранение дерева в формате Doc
    }

    public void PresenterSaveMdFormat() throws IOException, ClassNotFoundException
    {
        service.SaveMdFormat(); // сохранение дерева в формате Md
    }

    // методы для чтения из файлов:

    public void PresenterReadBinFormat() throws IOException, ClassNotFoundException
    {
        service.ReadBin(); // чтение дерева из бинарного файла (десериализация) и загрузка данных в дерево
    }

    public void PresenterReadTxtFormat() throws IOException, ClassNotFoundException
    {
        service.ReadTxt(); // чтение дерева из текстового файла
    }

    public void PresenterReadDocFormat() throws IOException, ClassNotFoundException
    {
        service.ReadDoc(); // чтение дерева из док файла
    }

    public void PresenterReadMdFormat() throws IOException, ClassNotFoundException
    {
        service.ReadMd(); // чтение дерева из Md файлала
    }

}
    