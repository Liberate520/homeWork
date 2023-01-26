package presenter;

import entity.Mammal;
import familytree.FamilyTree;
import service.Service;
import view.*;
import write.Writable;

import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onGetMember(String name){
        Mammal answer = service.getMember(name);
        if (answer != null)
            view.print(answer.toString());
        else
            view.print("Member with name " + name + " not found");
    }

    public void onGetTree(){
        FamilyTree answer = service.getTree();
        view.print(answer.toString());
    }

    public void onGetTree(int index){
        FamilyTree answer = service.getTree(index);
        view.print(answer.toString());
    }

    public String onGetTreeName(){
        return service.getTree().getName();
    }

    public List<String> onGetTreeNames(){
        return service.getTreeNames();
    }

    public void onSortTree(int sortType){
        service.sortTree(sortType);
        onGetTree();
    }

    public List<String> onGetWriterDescriptions() {
        return  service.getWriterDescriptions();
    }

    public int onGetFileType(int writerIndex)
    {
        return service.getFileType(writerIndex);
    }

    public void onSaveTree(int fileType){
        service.sortTree(0);
        String answer = service.saveTree(fileType);
        view.print(answer);
    }

    public void onLoadTree(int fileType){
        String answer = service.loadTree(fileType);
        view.print(answer);
    }
}