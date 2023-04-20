package FamilyTree.presenter;

import java.io.IOException;

import FamilyTree.model.fileManagement.SaveLoad;
import FamilyTree.model.servises.Service;
import FamilyTree.view.View;

public class Presenter {
    private View view;
    private Service service;
    private int questCounter;
    // private String answer;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        service.setPresenter(this);
    }

    public void addRecord() { //добавление новой записи в дерево. для этого происходит опрос пользователя по списку вопросов. для каждого типа узлов впопросы отличаются
        for (questCounter = 0; questCounter < service.getQuestionCount(); questCounter++){
            view.askAndAnswer(service.getQuestion(questCounter));
        }
        service.addNode();    
    }

    public void getAnswer(String answer) {
        service.getAnswer(answer);
    }

    public void getRecords() {
        //получить в виде текста список всех записей и отправить во вью
        String records = service.getAllPersons();
        view.print(records);
    }

    public void setQuestionNumber(int number){//устанавливает номер текущего вопроса, чтобы пропускать некоторые
        questCounter = number-1;//поправка на инкремент в цикле после выхода из Case в сервисе
    }

    public void print(String text){
        view.print(text);
    }

    public void load(SaveLoad sl, String path) throws ClassNotFoundException, IOException {//
        service.load(sl, path);
    }

    public void save(SaveLoad sl, String path) throws ClassNotFoundException, IOException {//
        service.save(sl, path);
    }


}
