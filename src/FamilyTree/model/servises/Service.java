package FamilyTree.model.servises;

import java.io.IOException;
import FamilyTree.model.fileManagement.SaveLoad;
import FamilyTree.presenter.Presenter;

public interface Service  {
    
    public void setPresenter(Presenter presenter);//настройка связи с презентором
    void addNode();//добавление записи
    void searchNode(String text);//поиск записи по тексту
    String getAllPersons();//получение списка записей дерева
    String getQuestion(int i);//по номеру запроса отправляет в ответ текст вопроса 
    int getQuestionCount();//определение количества вопросов
    void getAnswer(String msg);//получить ответ от вью
    void save(SaveLoad sl, String path) throws ClassNotFoundException, IOException;
    void load(SaveLoad sl, String path) throws ClassNotFoundException, IOException;
    String findNodes (String searchText);
    void showNodeFullInfo(int index);
    void deleteNode(int index);

    
    //Все основные методы перетащить потом сюда
    }


