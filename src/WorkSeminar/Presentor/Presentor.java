package WorkSeminar.Presentor;

import WorkSeminar.View.View;
import WorkSeminar.model.Service.Service;

import java.time.LocalDate;
import java.util.Scanner;

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

    public void getNamePersona(String name){
        String infoTree = service.getNamePersona(name);
        view.aswer(infoTree);
    }

    public void sortTreeByName(){
        service.sortTreeByName();
        view.aswer("Древо отсортировано по имени персонажей!");
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
        service.saveTree();
        view.aswer("Древо сохранено!");
    }

    public void loadTree(){
        service.loadTree();
        view.aswer("Древо загружено!");
    }


    /*
    Методы ручного изменения древа.
     */

    public  void creatPerson(Scanner scanner){
        service.creatPerson(scanner);
        view.aswer("Персонаж создан.");
    }
    public void Wedding(long personaOne, long personaTwo){
        service.setWedding(personaOne, personaTwo);
        view.aswer("Связь установлена.");
    }

    public void Parent(long personaOne, long personaTwo, long kid){
        service.addParent(personaOne, personaTwo, kid);
        view.aswer("Роители добавлены.");
    }

    public void addKid(long personaOne, long personaKid){
        service.addKid(personaOne, personaKid);
        view.aswer("Ребёнок добавлен.");
    }

    public  void setDathday(long persona, LocalDate date){
        service.setDathday(persona, date);
        view.aswer("Дата смерти установлена.");
    }

    public void getSisBroth(long id){
        service.getSisBroth(id);
        view.aswer("Список братьев и сестёр: ");
    }
    /*
    Работа с файлом.
     */
    public void setPathFile(String path){
        service.setPathFile(path);
        view.aswer("Путь файла обновлёт!");
    }
    public void defoldPathFile(){
        service.defoldPathFile();
        view.aswer("Путь файла установлен по умолчанию!");
    }
    public void getPathFile(){
        String path = service.getPathFile();
        view.aswer(path);
    }

}
