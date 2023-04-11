package presenter;

import java.io.IOException;
import java.util.List;

import model.familyTree.FamilyTree;
import model.human.Human;
import view.View;
import model.Service;

public class Presenter {
    private View view;
    private Service service;

    private String nameFile;
    private List<Human> hUMList;

    FamilyTree<Human>newObject = new FamilyTree<>();

    

    /**
     * @nameFile - имя файла для чтения и записи объектов
     */

    {
        nameFile =  "familyTree.out";
        this.hUMList=hUMList;
    }





    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }


    public Presenter() {
        this.nameFile = nameFile;
    }


    public String getFileName() {
        return nameFile;
    }


    /**
     * 
     * @throws IOException
     * @addObject - метод добавления объекта в дерево
     */


    public void addObject(String name, String family, String dateBirth, String father, Object mother) {


        service.addNewHuman(name, family, dateBirth,  father,  mother);

        view.print("Объект добавлен");

    }


    /**
     * @treeView - метод получения всех объектов из файла(десериализация)
     */
    public void familyTreeViewAll() {

    service.printListHuman();

    }

    public  void searchHuman(String nameSearch){

        view.print(service.searchHuman(nameSearch).getInfo());
       //System.out.println(service.searchHuman(newObject));

    }

}
