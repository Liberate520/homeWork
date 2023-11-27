package WorkSeminar.Presentor;

import WorkSeminar.View.View;
import WorkSeminar.model.Service.Service;

public class Presentor {
    private View view;
    private Service service;

    public  Presentor(View view){
        this.view = view;
        service = new Service();
    }

    public void creatTree(){
        service.createTree();
        view.aswer("Тестовое семейное древо создано!");
    }

    public void showTree(){
        String infoTree = service.showTree();
        view.aswer(infoTree);
    }

    public void sortTreeByAge(){
        service.sortTreeByAge();
        view.aswer("Древо отсортировано от младшего к старшему!");
    }

    public void sortDefaut(){
        service.sortDefaut();
        view.aswer("Древо отсортировано от страшего к младшему!");
    }

    public void sortTreeByGender(){
        service.sortTreeByGender();
        view.aswer("Древо отсортировано по гнедорному признаку!");
    }

    public boolean exit(){
        view.aswer("Завершение работы... \n");
        service.endWork();
        return false;
    }

    public void saveTree(){
        service.seveTree();
        view.aswer("Древо сохранено!");
    }

    public void loadTree(){
        service.loadTree();
        view.aswer("Древо загружено!");
    }

}
